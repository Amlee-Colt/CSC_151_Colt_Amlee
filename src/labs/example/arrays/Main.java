/*
@author: Colt Amlee
@date: 2 March 2026
@purpose: Week 8 lab
*/

package labs.example.arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        //ArrayOperations.createNewArray(15);
        //System.out.println("-------------------------");
        //ArrayOperations.sortArray(new int[]{5, 3, 8, 1, 2, 22, 9, 0, 15, 12});
        //System.out.println("-------------------------");
        //ArrayOperations.getDaysAndMonths();

        //  int firstArray[] = {10,25,2,7,14,1,1,5,9,8,6};
        //int secondArray[] = {10,4,17,8,5,1,5,3,7,9};
        //  int secondArray[] = {10,25,2,7,14,1,1,5,9,8,6};
        //int secondArray[] = {10,25,2,7,14,1,1,5,9,8};
        //int secondArray[] = {10,25,2,7,14,1,1,5,9,8,5};
        //  ArrayOperations.compareArray(firstArray, secondArray);

        int arr1[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}; //1-25
        int arr2[] = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368}; //fibonacci sequence
        int arr3[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}; //1*25
        ArrayOperations.sumArray(arr1, arr2, arr3);


    }
}