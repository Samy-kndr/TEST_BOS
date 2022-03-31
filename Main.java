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

        int choice = JOptionPane.showConfirmDialog(null, "Do you want to log in?", "TEST LOGIN", JOptionPane.YES_NO_OPTION);

        if(choice == 1){
            System.out.println("ok"); // NO-option == 1
        }else{
            System.out.println("meh"); // YES-option == 0
        }


    }
}
