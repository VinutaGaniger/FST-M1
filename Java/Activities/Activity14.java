package Activies;

import java.io.File;
import java.io.IOException;

public class Activity14 
{

	public static void main(String[] args) throws IOException {
        try {
            File file = new File("src/session4/newfile.txt");
            boolean fStatus = file.createNewFile();
            if(fStatus) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists at this path.");
            }

            //get the file Object
         //   File fileUtil = ((Object) fileUtil).getFile("src/session4/newfile.txt");
            //Read file
          //  System.out.println("Data in file: " + ((Object) fileUtil).readFileToString(fileUtil, "UTF8"));

            //Create directory
            File destDir = new File("resources");
            //Copy file to directory
           // ((Object) fileUtil).copyFileToDirectory(file, destDir);

            //Get file from new directory
         //   File newFile = ((Object) fileUtil).getFile(destDir, "newfile.txt");
            //Read data from file
       //     String newFileData = ((Object) fileUtil).readFileToString(newFile, "UTF8");
            //Print it
       //     System.out.println("Data in new file: " + newFileData);
        } catch(IOException errMessage) {
            System.out.println(errMessage);
        }
    }		
}