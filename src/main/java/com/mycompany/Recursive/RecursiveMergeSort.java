/*
 * Rohan Rajesh
 * March 29, 2023
 * Recursive Merge Sort
 * A program which runs a Recursive Merge Sort on an Array which has a random number of elements given by the user!
 */
package com.mycompany.Recursive;

/**
 *
 * @author Rohan
 */
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class RecursiveMergeSort {
    public static void merge(int[] a, int[] leftarr, int[] rightarr, int left, int right) {
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < left && j < right) {
        if (leftarr[i] <= rightarr[j]) {
            a[k++] = leftarr[i++];
        }
        else {
            a[k++] = rightarr[j++];
        }
    }
    while (i < left) {
        a[k++] = leftarr[i++];
    }
    while (j < right) {
        a[k++] = rightarr[j++];
    }
}
    public static void mergeSort(int[] a, int n) {
    if (n < 2) {
        return;
    }
    int mid = n / 2;
    int[] leftside = new int[mid];
    int[] rightside = new int[n - mid];

    for (int i = 0; i < mid; i++) {
        leftside[i] = a[i];
    }
    for (int i = mid; i < n; i++) {
        rightside[i - mid] = a[i];
    }
    mergeSort(leftside, mid);
    mergeSort(rightside, n - mid);

    merge(a, leftside, rightside, mid, n - mid);
} 
    void printArray(int[] arr){
    //this method helps us print out the array
    System.out.print("{");
    for (int i = 0; i < arr.length; i++){
    System.out.print(arr[i] + ", ");
    }
    System.out.print("}");
    System.out.println();
}
    
     public static void main(String args[]){
        //Initializes Scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("How many elements do you want to test?");
        //user inputs amount of elements they want in the array
        int input = scan.nextInt();
        Random randomize = new Random();
        int[] array = new int[input];
        //Sets random integers between 1 and 1000 in the array
        for (int i = 0; i < array.length; i++) {
		array[i] = randomize.nextInt(100);
	}
         
        RecursiveMergeSort tester = new RecursiveMergeSort();
        //Prints out unsorted array
        System.out.println("Unsorted:");
        tester.printArray(array);
        //starts a timer for how long the sort takes in nanoseconds and ends it when complete
        double start = System.nanoTime();
         
        tester.mergeSort(array, input);
         
        double end = System.nanoTime();
        double total = end - start;
        //prints out the sorted array as well as the time
        System.out.println("Sorted:");
        tester.printArray(array);
        System.out.println("It took " + total + " nanoseconds.");
         
     }
}
