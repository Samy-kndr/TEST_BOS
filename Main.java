import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        User user = new User();

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

        if(user.getName() == null){
            System.out.println("cancelled...");

            System.exit(0);

        }else{
            System.out.println("userName = " + user.getName());

            JOptionPane.showInternalMessageDialog(
                    null, "Welcome, " + user.getName(), "WELCOME", JOptionPane.INFORMATION_MESSAGE
            );

            System.exit(0);

        }



    }
}
