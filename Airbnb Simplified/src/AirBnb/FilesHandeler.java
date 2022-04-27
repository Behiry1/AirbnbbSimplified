package AirBnb;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import  java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors


public class FilesHandeler {
    private ArrayList<Host> hosts = new ArrayList<Host>();
    private ArrayList<Traveler> travelers = new ArrayList<Traveler>();
    private ArrayList<Properties> properties = new ArrayList<Properties>();
    private String HostPath = "D:/Project/DataStrucures/Airbnb/Airbnb Simplified/src/AirBnb/Host_File.csv";
    private String TraverlerPath = "D:/Project/DataStrucures/Airbnb/Airbnb Simplified/src/AirBnb/Traveller_file.csv";
    private String PropertiesPath = "D:/Project/DataStrucures/Airbnb/Airbnb Simplified/src/AirBnb/Properties_files .csv";


    public void ReadHostData() {

        try {
            File HP = new File(HostPath);
            Scanner myReader = new Scanner(HP);
            while (myReader.hasNextLine()) {
                String Data = myReader.nextLine();
                String[] Row = Data.split(",");
                int x = Integer.parseInt(String.valueOf(Row[6]));
                hosts.add(new Host(Row[0], Row[1], Row[2], Row[3], Row[4], Row[5], x, Row[7]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void ReadTraverlerData() {

        try {
            File TP = new File(TraverlerPath);
            Scanner myReader = new Scanner(TP);
            while (myReader.hasNextLine()) {
                String Data = myReader.nextLine();
                String [] Row = Data.split(",");
                int x = Integer.parseInt(String.valueOf(Row[6]));
                travelers.add(new Traveler(Row[0],Row[1],Row[2],Row[3],Row[4],Row[5],x,Row[7]));
            }
               myReader.close();
           } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
             System.out.println(travelers.get(1).id);
    }


    public void ReadPropertiesData() {

        try {
            File PP = new File(PropertiesPath);
            Scanner myReader = new Scanner(PP);
            while (myReader.hasNextLine()) {
                String Data = myReader.nextLine();
                String [] Row = Data.split(",");
                int x = Integer.parseInt(String.valueOf(Row[4])); //numofguest
                double y = Double.parseDouble(String.valueOf(Row[2])); //price
                double y2 = Double.parseDouble(String.valueOf(Row[3])); //area
                properties.add(new Properties (Row[0],Row[1],y,y2,x,Row[5],Row[6]));
            }
               myReader.close();
           } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
             System.out.println(properties.get(1).getPlace());
    }


    public void AddHost(String name, String phoneNumber, String password, String email, String nation, String id, int age, String gender){
        hosts.add(new Host(name,phoneNumber,password,email,nation,id,age,gender));

    }


    public void AddTraveler(String name, String phoneNumber, String password, String email, String nation, String id, int age, String gender){
        travelers.add(new Traveler(name,phoneNumber,password,email,nation,id,age,gender));

    }


    public void WriteToHostData(){
        try
        {

            FileWriter myWriter = new FileWriter(HostPath);
            for(int i=0;i<hosts.size();i++) {

                myWriter.write(hosts.get(i).name);
                myWriter.write(',');
                myWriter.write(hosts.get(i).phoneNumber);
                myWriter.write(',');
                myWriter.write(hosts.get(i).password);
                myWriter.write(',');
                myWriter.write(hosts.get(i).email);
                myWriter.write(',');
                myWriter.write(hosts.get(i).nation);
                myWriter.write(',');
                myWriter.write(hosts.get(i).id);
                myWriter.write(',');
                myWriter.write(hosts.get(i).age);
                myWriter.write(',');
                myWriter.write(hosts.get(i).gender);
                myWriter.write(',');
                myWriter.write('\n');
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void WriteToTraverlersData(){}


    public void WriteToPropertiesData(){}


       /*
       * display
       *
       * delete
       * */


}




