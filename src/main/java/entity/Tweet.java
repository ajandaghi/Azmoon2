package entity;

public class Tweet {
    private int id;
    private int userId;
    private String text;

    public Tweet(int id, int userId, String text) {
        this.id = id;
        this.userId = userId;
        this.text = text;
    }

    public Tweet(int userId, String text) {
        this.userId = userId;
        this.text = text;
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
}
