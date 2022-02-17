package service;

import Repository.UserRepository;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserRepository userRepository=new UserRepository();
    public User selectByUser(String user){
        List<User> users=new ArrayList<>();
        try {

            users = userRepository.selectAll();
            for(User value:users){
               if(value.getUserName().equals(user)) {
                   return value;
               }
            }




        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void add(String fullName, String userName, String pass){

        if(selectByUser(userName)==null){
            try {
                userRepository.insert(new User(fullName, userName, pass));
                System.out.println("user added successfully");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }


        }else{
            System.out.println("user before exists!");
        }

    }

    public void update(String userName, String fullName, String pass){
        User user=selectByUser(userName);
        try {
            userRepository.update(new User(user.getId(), user.getUserName(), fullName, pass));
            System.out.println("user profile updated!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public User login(String userName, String pass){
        User user=selectByUser(userName);
        if(user!=null){
            if(user.getPass().equals(pass)){
                return user;
            }
        }

        return null;

    }
}
