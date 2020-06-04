package main;

/**
 * Created by Siddharth Somvanshi on 5/5/2019.
 */
public interface adMethods {
    boolean addEmployee();
    boolean removeEmp(int id);
    void viewFacultyDetails();
    void viewAllFacultyDetails();
    void viewLeaveRequest();
    void viewProfile(int id);
    boolean changePassword(int id,String oldpass);
}
