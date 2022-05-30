package AirBnb;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files


public class Main
{
    // the Files Handler object that handles all files in the whole program
    // that's why it's statics and public
    public static FilesHandeler f = new FilesHandeler();
    static Scanner in = new Scanner(System.in);
// Reads all data from files to be used while running
static void HelloWorld()
{
    f.ReadTraverlerData();
    f.ReadHostData();
    f.FillMaps();
}
// Writes data after being modified during run to be saved
static void ByeWorld()
{
    f.WriteToTraverlersData();
    f.WriteToHostData();
}

// just checks if the entered value is valid or not
static int validateInput(int choice, int l, int r)
{
    while(!(choice >= l && choice <= r))
    {
        System.out.println("Enter a valid answer");
        choice = in.nextInt();
    }
    return choice;
}

// handler of the log ins and registration through the user class
static void LogIn()
{
    System.out.println("Is this your first time here? \n1-YES \n2-NO");
    int choice = in.nextInt();

    choice = validateInput(choice, 1, 2);

    if(choice == 1)
        User.SignUp();

    while (true)
    {
        System.out.println("Would like to log in? \n 1-YES \n 2-NO i would like to EXIT");
        choice = in.nextInt();

        choice = validateInput(choice, 1, 2);

        if(choice == 2)
            return;

        User.SignIn();
    }
}

   public static void main(String[] args)
   {

        HelloWorld();

        LogIn();

       ByeWorld();
   }
}



