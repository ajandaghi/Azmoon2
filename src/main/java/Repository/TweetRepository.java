package Repository;

import entity.Tweet;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TweetRepository {
    public Connection connection;
    public TweetRepository() {
        this.connection = Connect.getInstance().getConnect();

    }

    public void insert(Tweet tweet) throws SQLException {
        String insert="insert into tweet (userId, text) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1,tweet.getId());
        preparedStatement.setString(2, tweet.getText());
        preparedStatement.execute();
    }

    public void update(Tweet tweet) throws SQLException {
        String update="update tweet set userId=?, text=? where id=? ";
        PreparedStatement preparedStatement =connection.prepareStatement(update);
        preparedStatement.setInt(1,tweet.getUserId());
        preparedStatement.setString(2, tweet.getText());

        preparedStatement.execute();
    }

    public List<Tweet> selectAll() throws SQLException {
        String select="select * from tweet";
        PreparedStatement preparedStatement= connection.prepareStatement(select);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Tweet> tweets=new ArrayList<>();
        while(resultSet.next()){
            Tweet tweet=new Tweet(resultSet.getInt("id"),resultSet.getInt("userId"),resultSet.getString("text"));
            tweets.add(tweet);
        }
        return tweets;
    }

    public void delete(int id) throws SQLException {
        String delete="delete from tweet where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();

    }

}
