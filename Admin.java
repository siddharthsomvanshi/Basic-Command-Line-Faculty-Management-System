package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Siddharth Somvanshi on 5/2/2019.
 */
public class Admin extends Employee implements adMethods {
    final int leaves = 25;
    final int defaultPassword = 12345;
    FileWriters fw = new FileWriters();
    FileReaders fr = new FileReaders();
    Scanner sc = new Scanner(System.in);
    @Override
    public boolean addEmployee() {
        String data;
        int id,age,salary;
        String fname,lname,email,position;
        System.out.println("Enter The Following Details Of Employee");
        System.out.print("ID : ");
        id = sc.nextInt();
        System.out.print("First Name : ");
        fname = sc.next();
        System.out.print("Last Name : ");
        lname = sc.next();
        System.out.print("Age : ");
        age = sc.nextInt();
        System.out.print("Salary : ");
        salary = sc.nextInt();
        System.out.print("Position : ");
        position = sc.next();
        System.out.print("Email : ");
        email = sc.next();
        data = id+" "+fname+" "+lname+" "+age+" "+salary+" "+position+" "+leaves+" "+email;
        fw.writeToFile(String.valueOf(id+""+defaultPassword),"employeeRecord.txt");
        return fw.writeToFile(data,"employeeDetails.txt");
    }

    @Override
    public boolean removeEmp(int id) {
        boolean status = false;
        try {
            String tempData;
            File newFile = new File("src\\main\\files\\temp.txt");
            FileWriter fw = new FileWriter(newFile,true);
            PrintWriter pw = new PrintWriter(fw);
            File oldfile = new File("src\\main\\files\\employeeRecord.txt");
            Scanner filereader = new Scanner(oldfile);
            while(filereader.hasNext()){
                tempData = filereader.nextLine();
                if(tempData.substring(0,10).equals(String.valueOf(id))){
                    continue;
                }
                System.out.println(tempData);
                pw.println(tempData);
            }
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

    @Override
    public void viewProfile(int id) {
        String i,firstName,lastName,age,salary,position,leaves_left,email;
        ArrayList<String> details = new ArrayList<String>();
        details = fileReaders.readDetail(id,"adminDetails.txt");

        //storing values
        i = String.valueOf(details.get(0));firstName = details.get(1).toString();lastName = details.get(2).toString();
        age = details.get(3).toString();salary = details.get(4).toString();position = details.get(5).toString();
        leaves_left = details.get(6).toString();email = details.get(7).toString();

        //---------------------------------------------------------------------------------------------------------

        System.out.println("Profile ----------------------------------------------------------->");
        System.out.println("\tID : "+i+
                "\n\tName : "+firstName+" "+lastName+
                "\n\tAge : "+age+
                "\n\tSalary : "+salary+
                "\n\tDesignation : "+position+
                "\n\tNO of Leaves Left : "+leaves_left+"\n\tEmail : "+email);
        System.out.println(" ------------------------------------------------------------------>");
    }
    @Override
    public void viewFacultyDetails(){
        System.out.print("Enter Employee ID :");
        int val = sc.nextInt();
        super.viewProfile(val);
    }

    @Override
    public void viewAllFacultyDetails() {
        System.out.println("------------------------------------------------------------------------------------------\n");
        System.out.println("    ID     FirstName LastName Age Salary   Position   Leaves     E-Mail\n");
        fr.readFile("employeeDetails.txt");
        System.out.println("------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void viewLeaveRequest() {
        System.out.println("------------------------------------------------------------------------------------------\n");
        System.out.println("ID       Days StartDate(DD/MM/YY)\n");
        fr.readFile("leave.txt");
        System.out.println("------------------------------------------------------------------------------------------\n");
    }

    @Override
    public boolean changePassword(int id,String oldPass) {
        boolean status = false;
        String newPass;
        System.out.print("Please Enter The New PassWord : ");
        newPass = sc.next();
        try {
            String tempData;
            File newFile = new File("src\\main\\files\\temp.txt");
            FileWriter fw = new FileWriter(newFile,true);
            PrintWriter pw = new PrintWriter(fw);
            File oldfile = new File("src\\main\\files\\adminRecord.txt");
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
            newFile.renameTo(new File("src\\main\\files\\adminRecord.txt"));
            status = true;
        }catch(IOException e){
            Error.displayError(406,"employeeRecord.txt");
        }
        return status;
    }
}
