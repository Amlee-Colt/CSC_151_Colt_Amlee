/*
@author: Colt Amlee
@date: 15 April 2026
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
        System.out.println("-------------------------");
        getResponseSizes(openErrorLog("T:\\\\CSC_151_Colt_Amlee\\\\src\\\\labs\\\\example\\\\fileOperations\\\\http_access.log"));
        System.out.println("-------------------------");
        groupHTTPMethodsAndEndPoints(openErrorLog("T:\\\\CSC_151_Colt_Amlee\\\\src\\\\labs\\\\example\\\\fileOperations\\\\http_access.log"));
    }


    public static File openErrorLog(String URL){//I really don't know what I'm supposed to do with this. I know I'm supposed to return type BufferedReader, but how do I get that to work? Figuring this out would likely make everything WAY more compact.
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
                    //I don't like this, it's messy. Lacks elegance. I'd prefer to make this dynamic instead of a trillion repetitive if statements.
                    //I make something less repetitive in the groupHTTPMethodsAndEndPoints method
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
                    //Again, I'd prefer if I didn't use a ton of if statements, but this is easiest. 
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
            System.out.printf("There are %s logs with a response size above 3900 bytes.%n",counter);
        }
        catch (IOException e) { 
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public static void groupHTTPMethodsAndEndPoints(File path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            ArrayList<String> method = new ArrayList<String>();
            ArrayList<Integer> tally = new ArrayList<Integer>();
            while ((line = br.readLine()) != null) {
                String splitString[] = line.split("\"| ");     
                if (method.contains(splitString[6]) == false) {
                    method.add(splitString[6]);
                    tally.add(0);
                    //System.out.println(splitString[6]);
                    //Printing the above is enough to fulfill the assignment's requirements
                }
                for (String i : method) {
                    if (i.equals(splitString[6])) {
                        tally.set(method.indexOf(splitString[6]),tally.get(method.indexOf(splitString[6])) + 1);
                        //I decided to go a step beyond and tally how many times each method appears. 
                        //This tally is NOT hardcoded, it will update dynamically. 
                    }
                }
            }
            for (int i = 0; i < method.size(); i++) {
                System.out.printf("%s appears %s time%s.%n",method.get(i),tally.get(i), (tally.get(i) != 1) ? "s" : ""); 
                //The last part is just to make singulars correct. If OPTIONS appeared once, it would print "OPTIONS appears 1 time." 
                //This won't matter for the assignment since everything is plural, but I really wanted to make sure it was dynamic.
            }
        }
        catch (IOException e) { 
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
