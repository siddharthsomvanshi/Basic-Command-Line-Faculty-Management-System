package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Siddharth Somvanshi on 5/2/2019.
 */
public class Employee implements empMethods{

    private String id,firstName,lastName,age,salary,position,leaves_left,email;
    FileReaders fileReaders = new FileReaders();
    FileWriters fileWriters = new FileWriters();
    Scanner sc = new Scanner(System.in);
    public void viewProfile(int id) {
        ArrayList<String> details = new ArrayList<String>();
        details = fileReaders.readDetail(id,"employeeDetails.txt");

        //Setting Values ------------------------------------------------------------------------------------------

        this.id = String.valueOf(details.get(0));firstName = details.get(1).toString();lastName = details.get(2).toString();
        age = details.get(3).toString();salary = details.get(4).toString();position = details.get(5).toString();
        leaves_left = details.get(6).toString();email = details.get(7).toString();

        //---------------------------------------------------------------------------------------------------------
        System.out.println("Profile ----------------------------------------------------------->");
        System.out.println("\tID : "+this.id+
                "\n\tName : "+firstName+" "+lastName+
                "\n\tAge : "+age+
                "\n\tSalary : "+salary+
                "\n\tDesignation : "+position+
                "\n\tNO of Leaves Left : "+leaves_left+"\n\tEmail : "+email);
        System.out.println(" ------------------------------------------------------------------>");
        //loading menu

    }
    public void fileLeave(int id){
        boolean status=false;
        int noOfLeaves;
        int date;
        String data;
        System.out.print("Please Enter the No of leaves :");
        noOfLeaves = sc.nextInt();
        System.out.print("Please Enter the Date of Leave Starting(For Example : 02032019) :");
        date = sc.nextInt();
        data = id+" "+String.valueOf(noOfLeaves)+" "+String.valueOf(date);
        status = fileWriters.writeToFile(data,"leave.txt");
        if(status==true){
            System.out.println("Leave Successfully Requested");
        }else{
            Error.displayError(408,null);
        }
    }
    public boolean changePassword(int id, String oldPass){
        boolean status = false;
        String newPass;
        System.out.print("Please Enter The New PassWord : ");
        newPass = sc.next();
        try {
            String tempData;
            File newFile = new File("src\\main\\files\\temp.txt");
            FileWriter fw = new FileWriter(newFile,true);
            PrintWriter pw = new PrintWriter(fw);
            File oldfile = new File("src\\main\\files\\employeeRecord.txt");
            Scanner filereader = new Scanner(oldfile);
            while(filereader.hasNext()){
                tempData = filereader.nextLine();
                if(tempData.equals(String.valueOf(id)+" "+oldPass)){
                    continue;
                }
                pw.println(tempData);
            }
            pw.println(id+" "+newPass);
            pw.close();
            filereader.close();
            oldfile.delete();
            newFile.renameTo(new File("src\\main\\files\\employeeRecord.txt"));
            status = true;
        }catch(IOException e){
            Error.displayError(406,"employeeRecord.txt");
        }
        return status;
    }

    //getter for fields -------------------------------------------------------------------------------------------

    public String getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAge() {
        return age;
    }
    public String getSalary() {
        return salary;
    }
    public String getPosition() {
        return position;
    }
    public String getLeaves_left() {
        return leaves_left;
    }
    public String getEmail() {
        return email;
    }

}
