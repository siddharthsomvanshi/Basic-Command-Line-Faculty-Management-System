package main;

import java.util.Scanner;

/**
 * Created by Siddharth Somvanshi on 5/2/2019.
 */
public class MenuMaker {
    private int id;
    private String pass;
    private boolean verify;
    private int count = 2;
    private boolean recreate = true;
    Admin ad = new Admin();
    Employee emp = new Employee();
    Scanner sc = new Scanner(System.in);
    Login lg = new Login();
    FileReaders fileReaders = new FileReaders();
    void createLoginMenu(String type) {
        if (type.equals("adminLogin")) {
            System.out.println("Login As Admin");
            System.out.print("Admin ID : ");
            id = sc.nextInt();
            System.out.print("Admin Password : ");
            pass = sc.next();
            if (id == (int) id && pass == (String) pass) {
                verify = lg.verifyAdmin(id, pass);
                if (verify == true) {
                    createAdminMenu();
                } else {
                    Error.displayError(405,null);
                    while(recreate) {
                        System.out.println("Login Again : Only "+count+" Left");
                        createLoginMenu("adminLogin");
                        count--;
                    }
                }
            }
        }else if (type.equals("empLogin")) {
                System.out.println("Login As Employee");
                System.out.print("Employee ID : ");
                id = sc.nextInt();
                System.out.print("Employee Password : ");
                pass = sc.next();
                if (id == (int) id && pass == (String) pass) {
                    verify = lg.verifyEmployee(id, pass);
                    if (verify == true) {
                        createEmpMenu();
                    } else {
                        Error.displayError(405,null);
                        while(recreate) {
                            System.out.println("Login Again : Only "+count+" Left");
                            createLoginMenu("empLogin");
                            count--;
                        }
                    }
                }
            } else {
                Error.displayError(404,null);
            }
        }
    void createAdminMenu(){
        System.out.println("\t\t\t\tWelcome Admin : "+id);
        System.out.println("1. Add New Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. View Profile");
        System.out.println("4. Get Faculty Details");
        System.out.println("5. View Faculty List");
        System.out.println("6. Leave Requests");
        System.out.println("7. Change Password");
        System.out.println("8. Exit");
        adMenuHandler();
    }
    void createEmpMenu(){
        System.out.println("\t\t\t\tWelcome Employee : "+id);
        System.out.println("1. View Profile");
        System.out.println("2. File Leave Request");
        System.out.println("3. Change Password");
        System.out.println("4. Exit");
        empMenuHandler();
    }
    void adMenuHandler(){
        int id=0;
        boolean d = false;
        int value = sc.nextInt();
        switch(value){
            case 1:
                d = ad.addEmployee();
                if(d==true){
                    System.out.println("Employee SuccessFully Added");
                }else{
                    Error.displayError(414,null);
                }
                adMenuWaiting();
                break;
            case 2:
                System.out.print("Enter Employee ID : ");
                id = sc.nextInt();
                d = ad.removeEmp(id);
                if(d==true){
                    System.out.println("Employee SuccessFully Removed");
                }else{
                    Error.displayError(414,null);
                }
                adMenuWaiting();
                break;
            case 3:
                ad.viewProfile(this.id);
                adMenuWaiting();
                break;
            case 4:
                ad.viewFacultyDetails();
                adMenuWaiting();
                break;
            case 5:
                ad.viewAllFacultyDetails();
                adMenuWaiting();
                break;
            case 6:
                ad.viewLeaveRequest();
                adMenuWaiting();
                break;
            case 7:
                d = ad.changePassword(this.id,pass);
                if(d==true) {
                    System.out.println("Password Successfully Changed : Logging Out");
                }else{
                    Error.displayError(412,null);
                }
                break;
            case 8:
                System.exit(0);
                break;
        }
    }
    void empMenuHandler(){
        int value = sc.nextInt();
        switch(value){
            case 1 :
                emp.viewProfile(id);
                empMenuWaiting();
                break;
            case 2 :
                emp.fileLeave(id);
                empMenuWaiting();
                break;
            case 3 :
                boolean val = emp.changePassword(id,pass);
                if(val==true){
                    System.out.println("Password Successfully Changed : Logging Out");
                    System.exit(0);
                }else{
                    Error.displayError(412,null);
                }
                break;
            case 4 :
                System.exit(0);
                break;
            default :
                Error.displayError(408,null);
                break;

        }
    }
    void adMenuWaiting(){
        System.out.println("Press Enter To Go Back To Dashboard.....\n");
        try {
            System.in.read();
        }catch (Exception e){}
        createAdminMenu();

    }
    void empMenuWaiting(){
        System.out.println("Press Enter To Go Back To Dashboard.....\n");
        try {
            System.in.read();
        }catch (Exception e){}
        createEmpMenu();

    }
    }
