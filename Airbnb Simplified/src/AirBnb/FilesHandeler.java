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
    private String PropertiesPath = "E:/AirbnbbSimplified-master/Airbnb Simplified/src/AirBnb/Properties_files .csv";
    int counter=0;
    public ArrayList<Host> getHosts() {
        return hosts;
    }

    public ArrayList<Traveler> getTravelers() {
        return travelers;
    }

    public ArrayList<Properties> getProperties() {
        return properties;
    }

    public void ReadHostData() {

        try {
            File HP = new File(HostPath);
            Scanner myReader = new Scanner(HP);
            while (myReader.hasNextLine()) {
                String Data = myReader.nextLine();
                String[] Row = Data.split(",");
                int x = Integer.parseInt(String.valueOf(Row[6]));
                hosts.add(new Host(Row[0], Row[1], Row[2], Row[3], Row[4], Row[5], x, Row[7]));

                properties=new ArrayList<Properties>();
                for (int i=8; i<Row.length ;i=i+7)
                {

                    double d1 = Double.parseDouble(String.valueOf(Row[i+2]));
                    double d2 = Double.parseDouble(String.valueOf(Row[i+3]));
                    int i3 = Integer.parseInt(String.valueOf(Row[i+4]));
         //           properties.add(new Properties(Row[i],Row[i+1],d1,d2,i3,Row[i+5],Row[i+6]));
                }
                hosts.get(counter).setProperties(properties);
                counter=counter+1;
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


         //       properties.add(new Properties (Row[0],Row[1],y,y2,x,Row[5],Row[6]));
            }
               myReader.close();
           } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

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
            int counter=0;
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
                myWriter.write(Integer.toString(hosts.get(i).age));
                myWriter.write(',');
                myWriter.write(hosts.get(i).gender);
                myWriter.write(',');

                for(int j=0;j< hosts.get(i).getProperties().size();j++)
                {

                    myWriter.write(hosts.get(i).getProperties().get(j).getCapacity());
                    myWriter.write(',');
                    myWriter.write(hosts.get(i).getProperties().get(j).getPlace());
                    myWriter.write(',');
                    myWriter.write(Double.toString(hosts.get(i).getProperties().get(j).getPrice()));
                    myWriter.write(',');
                    myWriter.write(Double.toString(hosts.get(i).getProperties().get(j).getArea()));
                    myWriter.write(',');
                    myWriter.write(Integer.toString(hosts.get(i).getProperties().get(j).getNumOfGuests()));
                    myWriter.write(',');
             //       myWriter.write(hosts.get(i).getProperties().get(j).getStartDate());
                    myWriter.write(',');
             //       myWriter.write(hosts.get(i).getProperties().get(j).getEndDate());
                    myWriter.write(',');

                }
                myWriter.write('\n');

            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void WriteToTraverlersData()
    {
        try
        {

            FileWriter myWriter = new FileWriter(TraverlerPath);
            for(int i=0;i<travelers.size();i++) {

                myWriter.write(travelers.get(i).name);
                myWriter.write(',');
                myWriter.write(travelers.get(i).phoneNumber);
                myWriter.write(',');
                myWriter.write(travelers.get(i).password);
                myWriter.write(',');
                myWriter.write(travelers.get(i).email);
                myWriter.write(',');
                myWriter.write(travelers.get(i).nation);
                myWriter.write(',');
                myWriter.write(travelers.get(i).id);
                myWriter.write(',');
                myWriter.write(Integer.toString(travelers.get(i).age));
                myWriter.write(',');
                myWriter.write(travelers.get(i).gender);
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


    public void WriteToPropertiesData(){}
    public void DisplayHostData() {

        try {
            File HP = new File(HostPath);
            Scanner myReader = new Scanner(HP);
            while (myReader.hasNextLine()) {
                String Data = myReader.nextLine();
                String[] Row = Data.split(",");
                for (int i=0;i< Row.length;i++)
                {
                    System.out.print(Row[i]);
                    System.out.print(',');
                }
                System.out.println('\n');
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void DisplayTravelersData() {

        try {
            File HP = new File(TraverlerPath);
            Scanner myReader = new Scanner(HP);
            while (myReader.hasNextLine()) {
                String Data = myReader.nextLine();
                String[] Row = Data.split(",");
                for (int i=0;i< Row.length;i++)
                {
                    System.out.print(Row[i]);
                    System.out.print(',');
                }
                System.out.println('\n');
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void DeleteHostData(String id)
    {
        for (int i=0;i<= hosts.size();i++)
        {
            if (id.equals(hosts.get(i).id))
            {
            hosts.remove(i);
            break;
            }
        }
    }
    public void DeleteTravelerData(String id)
    {
        for (int i=0;i<= travelers.size();i++)
        {
            if (id.equals(travelers.get(i).id))
            {
                travelers.remove(i);
                break;
            }
        }
    }


}




