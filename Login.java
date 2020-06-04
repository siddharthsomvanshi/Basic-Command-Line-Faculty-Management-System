package main;

/**
 * Created by Siddharth Somvanshi on 5/2/2019.
 */
public class Login {
    FileReaders fr = new FileReaders();
    boolean found;
    boolean verifyAdmin(int id,String pass){
        found = fr.verifyLoginDetails("adminRecord.txt",id, pass);
        return found;
    }
    boolean verifyEmployee(int id,String pass){
        found = fr.verifyLoginDetails("employeeRecord.txt",id, pass);
        return found;
    }
}
