import Repository.TweetRepository;
import entity.User;
import service.TweetService;
import service.UserService;

import java.util.Scanner;

public class Menus {
    UserService userService= new UserService();
    TweetService tweetService=new TweetService();

    Scanner scanner= new Scanner(System.in);
    public void mainMenu(){
        System.out.println("1.register user");
        System.out.println("2.login");
        String input=scanner.nextLine();
        switch(input){
            case"1":
                register();
                break;
            case "2":
                login();
                break;
        }
    }

    private void login() {
        System.out.println("enter user:");
        String user=scanner.nextLine();
        System.out.println("enter password:");
        String pass=scanner.nextLine();

        if(userService.login(user,pass)!=null){
            userMenu(userService.login(user,pass));
        }
        else
            mainMenu();
    }

    public void register(){
        System.out.println("enter fullName/userName/Pass");
        String[] cmd=scanner.nextLine().split("/");
        userService.add(cmd[0],cmd[1],cmd[2]);
        mainMenu();
    }

    public void userMenu(User user){
        System.out.println("1.edit my profile");
        System.out.println("2.tweets");
        System.out.println("3.comments");
        String input=scanner.nextLine();
        switch (input){
            case "1":
                editMyProfile(user);
                break;
            case "2":
                tweetMenu(user);
        }

    }

    private void tweetMenu(User user) {
        System.out.println("1.add tweet");
        System.out.println("2.edit tweet");
        System.out.println("3.delete tweet");
        String input=scanner.nextLine();
        switch(input){
            case "1":
                System.out.println("text");
                String cmd=scanner.nextLine();
                tweetService.add(user.getId(),cmd);
                break;
            case "2":
                System.out.println("tweetId/new text");
                String[] cmd1=scanner.nextLine().split("/");
                tweetService.update(Integer.parseInt(cmd1[0]),Integer.parseInt(cmd1[1]),cmd1[2]);
                break;
        }

        tweetMenu(user);
    }

    public void editMyProfile(User user){
       System.out.println("enter fullName/pass");
       String[] cmd=scanner.nextLine().split("/");
       userService.update(user.getUserName(),cmd[0],cmd[1]);

   }

}
