package AirBnb;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files


public class Main {
    public static void StartApp(){
        Scanner in=new Scanner(System.in);
        int choice ;
        FilesHandeler f = new FilesHandeler();
        User u=new User(f);
        f.ReadTraverlerData();
        f.ReadHostData();
        System.out.println("Welcome to our Airbnb Simplified App");
        System.out.println("we hope you doing well");
        System.out.println("If you want to exit the program at any time please enter '0'");
        System.out.println("Would you like to ");
        System.out.println("SignUp please enter '1' , " + " SignIn please enter '2'");
        choice = in.nextInt();
        if(choice == 1) {
            u.SignUp();
        }
        else if(choice == 2){
            u.SignIn();
        }




    }
    public static void EndApp(){
        FilesHandeler f =new FilesHandeler();
        f.WriteToTraverlersData();
        f.WriteToHostData();
        return;
    }
    public static void main(String[] args)
    {
        int choice = 0;
        while(choice != 0) {
            StartApp();
        }

    }
}



