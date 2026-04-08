/*
@author: Colt Amlee
@date: 23 March 2026
@purpose: Week 10 lab
*/

package labs.example.arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        //ArrayOperations.createNewArray(15);
        //System.out.println("-------------------------");
        //ArrayOperations.sortArray(new int[]{5, 3, 8, 1, 2, 22, 9, 0, 15, 12});
        //System.out.println("-------------------------");
        //ArrayOperations.getDaysAndMonths();
        int firstArray[] = {10,25,2,7,14,1,1,5,9,8,6};
        int secondArray[] = {10,4,17,8,5,1,5,3,7,9};
        //int secondArray[] = {10,25,2,7,14,1,1,5,9,8,6};
        //int secondArray[] = {10,25,2,7,14,1,1,5,9,8};
        //int secondArray[] = {10,25,2,7,14,1,1,5,9,8,5};
          ArrayOperations.compareArray(firstArray, secondArray);
        int arr1[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}; //1-25
        int arr2[] = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368}; //fibonacci sequence
        int arr3[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}; //1*25
        ArrayOperations.sumArray(arr1, arr2, arr3);
        int myArray[] = {37, 12, 45, 3, 28, 49, 7, 22, 14, 41, 9, 33, 1, 26, 48, 19, 6, 30, 24, 50, 11, 43, 17, 32, 4, 39, 21, 46, 2, 35, 16, 29, 8, 42, 13, 31, 5, 47, 20, 36, 10, 44, 18, 27, 15, 40, 23, 38, 25, 34};
        ArrayOperations.highestValue(myArray);

        int ccn[] = {4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        ArrayOperations.mod10Check(ccn);
    }
}