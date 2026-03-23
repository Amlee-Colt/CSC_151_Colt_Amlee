/*
@author: Colt Amlee
@date: 23 March 2026
@purpose: Week 11 lab
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class fileOperations {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("T:\\CSC_151_Colt_Amlee\\src\\labs\\example\\fileOperations\\\\users.csv"))) {
            String line;
            //double mathTotal = 0;
            while ((line = br.readLine()) != null) {
                String values[] = line.split(","); // Splits by comma
                // Process values[]
                System.out.printf("%-7s|%-4s|%-7s|%-7s|%n", values[0], values[1], values[2], values[3]);
            }
        } catch (IOException e) { e.printStackTrace(); }


    }
}
