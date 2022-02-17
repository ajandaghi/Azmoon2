package service;

import Repository.TweetRepository;
import entity.Tweet;

import java.sql.SQLException;

public class TweetService {
    TweetRepository tweetRepository=new TweetRepository();
    public void add(int userId, String text){
        try{
            tweetRepository.insert(new Tweet(userId,text));
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void update(int id, int userId, String text){
        try{
            tweetRepository.update(new Tweet(id,userId,text));
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
