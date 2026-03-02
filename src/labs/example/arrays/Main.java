/*
@author: Colt Amlee
@date: 2 March 2026
@purpose: Week 8 lab
*/

package labs.example.arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        ArrayOperations.createNewArray(15);
        System.out.println("-------------------------");
        ArrayOperations.sortArray(new int[]{5, 3, 8, 1, 2, 22, 9, 0, 15, 12});
        System.out.println("-------------------------");
        ArrayOperations.getDaysAndMonths();
    }
}