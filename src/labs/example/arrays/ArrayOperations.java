/*
@author: Colt Amlee
@date: 2 March 2026
@purpose: Week 8 lab
*/

package labs.example.arrays;

public class ArrayOperations {
    public static void createNewArray(int size) {
        int testArray[] = new int[size];
        for (int i = 0; i < size; i++) {
            testArray[i] = i;
        }
        displayArray(testArray);
    }

    private static void displayArray(int array[]) {
        System.out.println("I created a new array and it now has " + array.length + " items in it. \nThe array items and their values are listed below:");
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sortArray(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("The sorted array is:");
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void getDaysAndMonths() {
        int dayArray[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        String monthArray[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < dayArray.length; i++) {
            System.out.println("There are " + dayArray[i] + " days in " + monthArray[i]);
        }
    }
}
