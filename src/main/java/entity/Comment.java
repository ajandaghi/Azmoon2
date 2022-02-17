package entity;

public class Comment {
    private int id;
    private int userId;
    private String text;
    private int tweetId;


    public Comment(int id, int userId, String text, int tweetId) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.tweetId = tweetId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }
}
