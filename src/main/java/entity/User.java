package entity;

public class User {
    private int id;
    private String fullName;
    private String userName;
    private String pass;

    public User(String fullName, String userName, String pass) {
        this.fullName = fullName;
        this.userName = userName;
        this.pass = pass;
    }

    public User() {
    }

    public User(int id, String fullName, String userName, String pass) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
