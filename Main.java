import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello fucking World!");

        String test = "this is a test";

        System.out.println(test);

        int testA = 25;

        System.out.println("your lucky number is: " + testA );
        System.out.println("YAY");

        User user = new User("carlos");

        int choice = JOptionPane.showConfirmDialog(
                null, "Do you want to log in?", "TEST LOGIN", JOptionPane.YES_NO_OPTION
        );
        // NO-option == 1; YES-option == 0


        if(choice == 0){
            // Yes-Option
            String userName = JOptionPane.showInputDialog(
                    null, "Please enter your name", "LOGIN", JOptionPane.INFORMATION_MESSAGE
            );

            user.setName(userName);

        }else{
            // NO-Option
            JOptionPane.showInternalMessageDialog(
                    null, "OK, Goodbye then!", "byebye", JOptionPane.INFORMATION_MESSAGE
            );
        }

        System.out.println("userName = " + user.getName());


    }
}
