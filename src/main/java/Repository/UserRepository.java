package Repository;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
private Connection connection;

    public UserRepository() {
        this.connection = Connect.getInstance().getConnect();
    }

    public void insert(User user) throws SQLException {
        String insert="insert into userProfile (fullName, userName, pass) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1,user.getFullName());
        preparedStatement.setString(2, user.getUserName());
        preparedStatement.setString(3,user.getPass());
        preparedStatement.execute();
    }

    public void update(User user) throws SQLException {
        String update="update userProfile set fullName=?, userName=?, pass=? where id=? ";
        PreparedStatement preparedStatement =connection.prepareStatement(update);
        preparedStatement.setString(1,user.getFullName());
        preparedStatement.setString(2, user.getUserName());
        preparedStatement.setString(3,user.getPass());
        preparedStatement.setInt(4,user.getId());
        preparedStatement.execute();
    }

    public List<User> selectAll() throws SQLException {
        String select="select * from userProfile";
        PreparedStatement preparedStatement= connection.prepareStatement(select);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<User> users=new ArrayList<>();
        while(resultSet.next()){
            User user=new User(resultSet.getInt("id"),resultSet.getString("fullName"),resultSet.getString("userName"),resultSet.getString("pass"));
            users.add(user);
        }
        return users;
    }

    public void delete(int id) throws SQLException {
        String delete="delete from userProfile where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();

    }
}
