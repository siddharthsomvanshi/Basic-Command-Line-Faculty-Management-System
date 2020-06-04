package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Siddharth Somvanshi on 5/2/2019.
 */
public class FileReaders {
    private boolean found;
    Scanner fileReader;

    boolean verifyLoginDetails(String fileName, int id, String pass) {
        try {
            fileReader = new Scanner(new File("src\\main\\files\\" + fileName));
            String complete = id+pass;
            while (fileReader.hasNext()) {
                if(fileReader.nextLine().toString().equals(complete)){
                    found = true;
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            Error.displayError(406,fileName);
        }catch (NumberFormatException e){}
        return found;
    }

    void readFile(String filename){
        try {
            fileReader = new Scanner(new File("src\\main\\files\\" + filename));
            while (fileReader.hasNext()) {
                String temp = fileReader.nextLine();
                System.out.println(temp);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            Error.displayError(406,filename);
        }catch (NumberFormatException e){}
    }
    ArrayList<String> readDetail(int id, String filename){
        ArrayList<String> detail = new ArrayList<String>();
        try {
            fileReader = new Scanner(new File("src\\main\\files\\" + filename));
            while (fileReader.hasNext()) {
                if(fileReader.next().equals(String.valueOf(id))){
                    detail.add(String.valueOf(id));
                    for(int i=1;i<=7;i++){
                        detail.add(fileReader.next());
                    }
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            Error.displayError(406,filename);
        }catch (NumberFormatException e){}
        return detail;
    }
}

