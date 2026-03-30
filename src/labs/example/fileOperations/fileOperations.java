/*
@author: Colt Amlee
@date: 23 March 2026
@purpose: Week 11 lab
*/

package labs.example.fileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileOperations { 

    public static void main(String[] args) {

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
        } catch (IOException e) { e.printStackTrace(); System.out.println(e);}

        
    }

}
