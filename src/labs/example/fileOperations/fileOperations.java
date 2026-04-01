/*
@author: Colt Amlee
@date: 1 April 2026
@purpose: Week 11 lab
*/

package labs.example.fileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileOperations { 

    public static void main(String[] args) {
        csvReader();
        //logReader();
    }

    public static void csvReader(){

        try (BufferedReader br = new BufferedReader(new FileReader("T:\\CSC_151_Colt_Amlee\\src\\labs\\example\\fileOperations\\users.csv"))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String values[] = line.split(","); // Splits by comma
                if (count > 0){
                    System.out.printf("%-7s|%-4s|%-7s|%-7s|%-7s|%n", values[0], values[1], values[2], values[3], (Integer.parseInt(values[1]) + Integer.parseInt(values[2]) + Integer.parseInt(values[3]))/3);}
                    else {
                        System.out.printf("%-7s|%-4s|%-7s|%-7s|Average|%n-------------------------------------%n", values[0], values[1], values[2], values[3]);
                        count++;
                    }
                
            }
        } catch (IOException e) { e.printStackTrace();}
    }

    public static void logReader(){
        int errorTally = 0;
        int warningTally = 0;
        int infoTally = 0;
        int totalTally = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("T:\\CSC_151_Colt_Amlee\\src\\labs\\example\\fileOperations\\api_error.log"))) {
            String line;
            
            while ((line = br.readLine()) != null) {

                //System.out.println(line); //This just prints out every line
                String severityLevel = line.substring(line.indexOf("[") + 1,line.indexOf("]"));
                if (severityLevel.equals("ERROR")) {
                    errorTally += 1;
                } else if (severityLevel.equals("WARN")) {
                    warningTally += 1;
                } else if (severityLevel.equals("INFO")){
                    infoTally += 1;
                }
                totalTally += 1;
                
                //Need to figure out what logic to use to detect when a "flag?" character is used and a way to turn data into usable formats. ie, a way to detect the brackets and store whether something is an error, a warning, or just info.
                //From there, a way to tally how much of each, and what types of [errors/warnings/info] are logged. For instance, return how many errors there are, and a tally of each type of error.
                //I could theoretically just go through each line character by character and print every index starting after a certain char like "[" until we get to "]", but how would I convert this into a usable format? What flexibility do I have when I switch between different separators?
            }
            System.out.printf("Amount of errors: %s%nAmount of warnings: %s%nAmount of info: %s%nTotal logs: %s", errorTally, warningTally, infoTally, totalTally);
        }
        catch (IOException e) { e.printStackTrace();}}
    }
