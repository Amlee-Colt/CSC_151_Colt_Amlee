/*
@author: Colt Amlee
@date: 8 April 2026
@purpose: Week 13 lab
*/

package labs.example.fileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Logger {

    public static void main(String[] args) {
        getCountOfErrorTypes(openErrorLog());
        System.out.println("-------------------------");
        getMemoryLimitExceededCount(openErrorLog());
    }


    public static File openErrorLog(){
        File log_file = new File("T:\\CSC_151_Colt_Amlee\\src\\labs\\example\\fileOperations\\api_error.log");
        return log_file;
    }

    public static void getCountOfErrorTypes(File log_file){
        int errorTally = 0;
        int warningTally = 0;
        int infoTally = 0;
        int debugTally = 0; //There's none in the log file given, this will stay 0.
        int totalTally = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(log_file))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String splitString[] = line.split(" ");
                if (splitString[2].equals("[ERROR]")) {
                    errorTally += 1;
                } else if (splitString[2].equals("[WARN]")) {
                    warningTally += 1;
                } else if (splitString[2].equals("[INFO]")){
                    infoTally += 1;
                } else if (splitString[2].equals("[DEBUG]")) {
                    debugTally += 1;
                }
                totalTally += 1;
            }
            System.out.printf("Amount of error flags: %s%nAmount of warning flags: %s%nAmount of info flags: %s%nAmount of debug flags: %s%nTotal logs: %s%n", errorTally, warningTally, infoTally, debugTally, totalTally);
        }
        catch (IOException e) { 
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public static void getMemoryLimitExceededCount(File log_file) {
        try (BufferedReader br = new BufferedReader(new FileReader(log_file))) {
            String line;
            ArrayList<String> endpoint = new ArrayList<String>();
            int counter = 0;
            while ((line = br.readLine()) != null) {
                String splitString[] = line.split(" - | \\| |: ");
                ;
                if (splitString[1].equals("Memory limit exceeded in worker thread")) {
                    counter+=1;
                    if (endpoint.contains(splitString[3]) == false){
                        endpoint.add(splitString[3]);}
                }
                
            }
            System.out.printf("Memory limit has been exceeded %s times.%nThis occurred in the following endpoints:%n",counter);
            for (String i : endpoint){
                System.out.println(i);
            }
        }
        catch (IOException e) { 
            e.printStackTrace();
            System.out.println(e);
        }
    }

}
