/*
@author: Colt Amlee
@date: 13 April 2026
@purpose: Week 14 lab
*/

package labs.example.fileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Logger {

    public static void main(String[] args) {
        getCountOfErrorTypes(openErrorLog("T:\\\\CSC_151_Colt_Amlee\\\\src\\\\labs\\\\example\\\\fileOperations\\\\api_error.log"));
        System.out.println("-------------------------");
        getMemoryLimitExceededCount(openErrorLog("T:\\\\CSC_151_Colt_Amlee\\\\src\\\\labs\\\\example\\\\fileOperations\\\\api_error.log"));
        System.out.println("-------------------------");
        getDiskSpaceErrorsWithIPAddress(openErrorLog("T:\\\\CSC_151_Colt_Amlee\\\\src\\\\labs\\\\example\\\\fileOperations\\\\api_error.log"));
        System.out.println("-------------------------");
        getGMTOffset(openErrorLog("T:\\\\CSC_151_Colt_Amlee\\\\src\\\\labs\\\\example\\\\fileOperations\\\\http_access.log"));
        System.out.println("-------------------------");
        getHTTPCodes(openErrorLog("T:\\\\CSC_151_Colt_Amlee\\\\src\\\\labs\\\\example\\\\fileOperations\\\\http_access.log"));
        getResponseSizes(openErrorLog("T:\\\\CSC_151_Colt_Amlee\\\\src\\\\labs\\\\example\\\\fileOperations\\\\http_access.log"));
    }


    public static File openErrorLog(String URL){
        File path = new File(URL);
        return path;
    }


    public static void getCountOfErrorTypes(File path){
        int errorTally = 0;
        int warningTally = 0;
        int infoTally = 0;
        int debugTally = 0; //There's none in the log file given, this will stay 0.
        int totalTally = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
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

    public static void getMemoryLimitExceededCount(File path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            ArrayList<String> endpoint = new ArrayList<String>();
            int counter = 0;
            while ((line = br.readLine()) != null) {
                String splitString[] = line.split(" - | \\| |: ");

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

    public static void getDiskSpaceErrorsWithIPAddress(File path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null) {
                String splitString[] = line.split(" - | \\| |: ");
                String ipAddress[] = splitString[0].split(" ");
                
                if (splitString[1].equals("Disk space running low")) {
                    System.out.printf("Disk space error on line %s for IP Address: %s.%n" , counter, ipAddress[3]);
                }
                counter+=1;
            }
        }
        catch (IOException e) { 
            e.printStackTrace();
            System.out.println(e);
        }

    }

    public static void getGMTOffset(File path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            ArrayList<String> distinctTZ = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                String splitString[] = line.split("[ \\]]");                
                if (distinctTZ.contains(splitString[4]) == false) {
                    distinctTZ.add(splitString[4]);
                }
            }
            for (String i : distinctTZ){
                System.out.println(i);
            }
        }
        catch (IOException e) { 
            e.printStackTrace();
            System.out.println(e);
        }

    }

    public static void getHTTPCodes(File path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int TwoXError = 0;
            int ThreeXError = 0;
            int FiveXError = 0;
            while ((line = br.readLine()) != null) {
                String splitString[] = line.split("\"");     
                String statusCode[] = splitString[2].split(" ");           
                if (Integer.parseInt(statusCode[1]) >= 200 && Integer.parseInt(statusCode[1]) < 300) {
                    TwoXError += 1;
                } else if (Integer.parseInt(statusCode[1]) >= 300 && Integer.parseInt(statusCode[1]) < 400){
                    ThreeXError += 1;
                } else if (Integer.parseInt(statusCode[1]) >= 500 && Integer.parseInt(statusCode[1]) < 600) {
                    FiveXError += 1;
                }
            }
            System.out.printf("5xx Errors: %s%n2xx Errors: %s%n3xx Errors: %s%n",FiveXError,ThreeXError,TwoXError);
        }
        catch (IOException e) { 
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public static void getResponseSizes(File path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null) {
                String splitString[] = line.split("\"");     
                String statusCode[] = splitString[2].split(" ");           
                if (Integer.parseInt(statusCode[2]) > 3900) {
                    counter += 1;
                }
            }
            System.out.printf("There are %s logs with a response size above 3900 bytes.",counter);
        }
        catch (IOException e) { 
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
