import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {


        User user = new User();

        Gson gson = new Gson(); // for handling saving and loading .json files -MF

        int choice = JOptionPane.showConfirmDialog(
                null, "Do you want to log in?", "TEST LOGIN", JOptionPane.YES_NO_OPTION
        );
        // NO-option == 1; YES-option == 0 -MF

        System.out.println(choice);


        if(choice == 0){
            // YES-Option -MF
            String userName = JOptionPane.showInputDialog(
                    null, "Please enter your name", "LOGIN", JOptionPane.INFORMATION_MESSAGE
            );

            user.setName(userName);

        }else{
            // NO-Option -MF
            JOptionPane.showInternalMessageDialog(
                    null, "OK, Goodbye then!", "bye bye", JOptionPane.INFORMATION_MESSAGE
            );

            System.exit(0);
        }

        if(user.getName() == null){
            System.out.println("cancelled...");

        }else{
            System.out.println("userName = " + user.getName());

            JOptionPane.showInternalMessageDialog(
                    null, "Welcome, " + user.getName(), "WELCOME", JOptionPane.INFORMATION_MESSAGE
            );

        }

        // asking user to either clock in or clock out
        // -> "Clock In" --> saved current time in the user json
        // -> "Clock Out" --> calculates difference between current time and clock-in time and shows calculated "worktime"
        // -MF
        Object[] userOptions = { "Clock In", "Clock Out"};

        Object selectedOption =
                JOptionPane.showInputDialog(
                        null, "What do you want to do?", "Options",
                        JOptionPane.INFORMATION_MESSAGE, null, userOptions, userOptions[0]
                );

        if(selectedOption == "Clock In"){

            user.setClockInTime(System.currentTimeMillis());

            System.out.println("user ClockInTime: " + user.getClockInTime());

            long hours = user.getClockInTime() / 3600000;

            System.out.println("time in hours: " + hours);

            printObjectToJson(user, user.getName());

            JOptionPane.showInternalMessageDialog(
                    null,
                    "Thank you. You have successfully clocked in. \n" +
                            "Please don't forget to clock out before leaving work!",
                    "clocked in successfully",
                    JOptionPane.INFORMATION_MESSAGE);

            System.exit(0);

        }else{

            String userName = user.getName();
            String userJson = readJsonToString(userName);

            user = gson.fromJson(userJson, User.class);

            user.setClockOutTime(System.currentTimeMillis());

            long inTime = user.getClockInTime() / 3600000;
            long outTime = user.getClockOutTime() / 3600000;

            System.out.println("user ClockInTime: " + inTime +
                    "\n user ClockOutTime: " + outTime);

            long workTimeDifference = outTime - inTime;

            System.out.println("user working hours: " + workTimeDifference);

            JOptionPane.showInternalMessageDialog(
                    null,
                    "Thank you. You have successfully clocked out. \n" +
                            "You have worked " + workTimeDifference + " hours today!",
                    "clocked out successfully", JOptionPane.INFORMATION_MESSAGE);

            System.exit(0);

        }



    }

    // saves given Object to a .json file that can be loaded again later
    // -MF
    public static void printObjectToJson(Object object, String fileName){

        System.out.println("Saving Object to " + fileName + ".json...");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonToSave = gson.toJson(object);

        try{

            PrintWriter writer = new PrintWriter(fileName + ".json", StandardCharsets.UTF_8);
            writer.println(jsonToSave);
            writer.close();

        }catch(Exception e) {

            e.printStackTrace();

        }

        System.out.println(fileName + ".json successfully saved!");

    }

    // reads given Object from a .json file to a String value, so it can be loaded into an existing Object
    // ("pathname" is here the name of the file, because it is saved in the same folder as the program")
    // -MF
    public static String readJsonToString(String pathname){
        String jsonToReturn = "";

        try{

            File fileToRead = new File(pathname + ".json");
            Scanner reader = new Scanner(fileToRead);

            while(reader.hasNextLine()){
                jsonToReturn = jsonToReturn + reader.nextLine();
            }

        }catch(FileNotFoundException e){

            System.out.println(pathname + ".json was not found...");
            e.printStackTrace();

        }

        return jsonToReturn;
    }

}
