package labs.example.fileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;

public class Logger {

    public static void main(String[] args) {
        logReader();
    }

    public static void logReader(){
        int errorTally = 0;
        int warningTally = 0;
        int infoTally = 0;
        int debugTally = 0; //There's none in the log file given, this will stay 0.
        int totalTally = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("T:\\CSC_151_Colt_Amlee\\src\\labs\\example\\fileOperations\\api_error.log"))) {
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
                
                // TO DO: SPLIT BY SPACES, USE INDEXES FOR DATE/TIME/SEVERITY/IP, THEN SPLIT AGAIN BY |
                //Need to figure out what logic to use to detect when a "flag?" character is used and a way to turn data into usable formats. ie, a way to detect the brackets and store whether something is an error, a warning, or just info.
                //From there, a way to tally how much of each, and what types of [errors/warnings/info] are logged. For instance, return how many errors there are, and a tally of each type of error.
                //I could theoretically just go through each line character by character and print every index starting after a certain char like "[" until we get to "]", but how would I convert this into a usable format? What flexibility do I have when I switch between different separators?
            }
            System.out.printf("Amount of error flags: %s%nAmount of warning flags: %s%nAmount of info flags: %s%nAmount of debug flags: %s%nTotal logs: %s%n", errorTally, warningTally, infoTally, debugTally, totalTally);
            
        }
        catch (IOException e) { e.printStackTrace();}
    }
    


    //public static BufferedReader openErrorLog(){
    //    try (BufferedReader br = new BufferedReader(new FileReader("T:\\CSC_151_Colt_Amlee\\src\\labs\\example\\fileOperations\\api_error.log"))) {
    //        return br;
    //    }
    //    catch (IOException e) { e.printStackTrace();}
    //}
//
    //public static void getCountOfErrorTypes(String file){
    //    
    //}
}
