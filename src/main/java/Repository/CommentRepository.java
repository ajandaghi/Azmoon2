package Repository;

import entity.Comment;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentRepository {
private Connection connection;

    public CommentRepository() {
        this.connection = Connect.getInstance().getConnect();

    }

    public void insert(Comment comment) throws SQLException {
        String insert="insert into userProfile (userId, text, tweetId) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1,comment.getUserId());
        preparedStatement.setString(2, comment.getText());
        preparedStatement.setInt(3,comment.getTweetId());
        preparedStatement.execute();
    }

    public void update(Comment comment) throws SQLException {
        String update="update comment set userId=?, text=?, tweetId=? where id=?";
        PreparedStatement preparedStatement =connection.prepareStatement(update);
        preparedStatement.setInt(1,comment.getUserId());
        preparedStatement.setString(2, comment.getText());
        preparedStatement.setInt(3,comment.getTweetId());
        preparedStatement.setInt(4,comment.getId());
        preparedStatement.execute();
    }

    public List<Comment> selectAll() throws SQLException {
        String select="select * from comment";
        PreparedStatement preparedStatement= connection.prepareStatement(select);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Comment> comments=new ArrayList<>();
        while(resultSet.next()){
            Comment comment=new Comment(resultSet.getInt("id"),resultSet.getInt("userId"),resultSet.getString("text"),resultSet.getInt("tweetId"));
            comments.add(comment);
        }
        return comments;
    }

    public void delete(int id) throws SQLException {
        String delete="delete from userProfile where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();

    }
}
