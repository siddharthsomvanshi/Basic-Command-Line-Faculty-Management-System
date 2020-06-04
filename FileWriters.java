package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Siddharth Somvanshi on 5/2/2019.
 */
public class FileWriters {
    boolean writeToFile(String dataToWrite, String filename) {
        boolean status=false;
        try {
            File file = new File("src\\main\\files\\" + filename);
                FileWriter fw = new FileWriter(file,true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(dataToWrite);
                fw.close();
                pw.close();
                status = true;
        }catch(IOException e){
            Error.displayError(406,filename);
            status = false;
        }
        return status;
    }

}
