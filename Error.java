package main;

/**
 * Created by Siddharth Somvanshi on 5/2/2019.
 */
abstract public class Error {
    static final void displayError(int errorCode,String filename){
        switch(errorCode){
            case 403 :
                System.out.println("Invalid Input");
                break;
            case 404 :
                System.out.println("Menu Failed To Load");
                break;
            case 405 :
                System.out.println("Login Failed : Invalid ID or PassWord");
                break;
            case 406 :
                System.out.println(filename+" : Unable To Load File or File Not Found");
                break;
            case 408 :
                System.out.println("Failed To Retrieve User Info");
                break;
            case 410 :
                System.out.println("Leave Request Cannot Be Proceesed or You Have No Leave Left");
                break;
            case 412 :
                System.out.println("Password Change Failed");
                break;
            case 414 :
                System.out.println("Employee Record Deletion Failed");
                break;
            default :
                System.out.println("Got Unexpected Error");
        }
    }
}
