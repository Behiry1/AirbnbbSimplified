package AirBnb;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args) {
FilesHandeler f=new FilesHandeler();
f.ReadTraverlerData();
f.ReadHostData();
f.DeleteTravelerData("2");
f.DeleteHostData("2");
f.WriteToTraverlersData();
f.WriteToHostData();

    }
}



