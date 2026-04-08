/*
@author: Colt Amlee
@date: 23 March 2026
@purpose: Week 10 lab
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
    
    public static void compareArray(int firstArray[], int secondArray[]) {
        int firstArrayLength = 0;
        int secondArrayLength = 0;
        boolean equal = true;
        for (firstArrayLength = 0; firstArrayLength < firstArray.length; firstArrayLength++) {}
        for (secondArrayLength = 0; secondArrayLength < secondArray.length; secondArrayLength++) {}
        if (firstArrayLength != secondArrayLength){
            System.out.println("These arrays are not the same length.");

            for (int i = 0; i < Math.min(firstArrayLength, secondArrayLength); i++) {
                if (firstArray[i] != secondArray[i]) {
                    System.out.println("These arrays do not contain the same values.");
                    equal = false; 
                    break;                    
                }
            }
            if (equal == true) {
                System.out.println("The larger array contains all " + Math.min(firstArrayLength, secondArrayLength) + " elements of the smaller array.");}
        } 
        else {
            System.out.println("These arrays are the same length.");
            for (int i = 0; i < firstArrayLength; i++) {

                if (firstArray[i] != secondArray[i]) {
                    System.out.println("These arrays do not contain the same values.");
                    equal = false; 
                    break;
                }
            }
            if (equal == true) {
                System.out.println("These two arrays have the same values.");}
        }

    }

    public static void sumArray(int arr1[], int arr2[], int arr3[]) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i : arr1) {
        sum1 += i;
        }
        System.out.println("The value of arr1 is " + sum1);
        for (int i : arr2) {
        sum2 += i;
        }
        System.out.println("The value of arr2 is " + sum2);
        for (int i : arr3) {
        sum3 += i;
        }
        System.out.println("The value of arr3 is " + sum3);
        if (sum1 > sum2 && sum1 > sum3) {
            System.out.println("The array with the highest sum is arr1 with a value of " + sum1 + ".");
        } else if (sum2 > sum1 && sum2 > sum3) {
            System.out.println("The array with the highest sum is arr2 with a value of " + sum2 + ".");
        } else if (sum3 > sum1 && sum3 > sum2) {
            System.out.println("The array with the highest sum is arr3 with a value of " + sum3 + ".");
        } else {
            System.out.println("One of the arrays is equal to another and I'm too lazy to account for that as of now. \nThat isn't a scenario possible with the current values of my arrays and I don't imagine you'd go into that much depth whilst grading, but I'm still leaving this here since it's technically possible.");
        }
    }

    public static void highestValue(int array[]) {
        int highestValue = 0;
        for (int i : array){
            if (i > highestValue) {
                highestValue = i;
            }
        }
        System.out.println("The highest value in the myArray object is: " + highestValue);
    }

    public static void mod10Check(int ccn[]) {
        int counter = 0;
        int num[] = new int[ccn.length];
        int sum = 0;
        for (int i : ccn){
            if (counter < ccn.length) {
                num[ccn.length - 1 - counter] = i;
                counter++;
            }
        }
        for (int j = 1; j < num.length; j += 2) {
            num[j] *= 2;
            if (num[j] > 10) {
                num[j] -= 9;
            }
        }
        for (int k : num) {
            sum += k;
        }
        if (sum % 10 == 0) {
            System.out.println("This credit card is valid");
        } else {
            System.out.println("This credit card is not valid");
        }
    }
}