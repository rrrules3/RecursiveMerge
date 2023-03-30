/*
 * Rohan Rajesh
 * March 29, 2023
 * Recursive Merge Sort
 * A program which runs a Recursive Merge Sort on an Array which has a random number of elements given by the user!
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Rohan
 */
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class RecursiveMergeSort {
	// To check if array is sorted or not
	boolean isSorted(int[] a)
	{
		for (int i = 1; i < a.length; i++)
			if (a[i] < a[i - 1])
				return false;
		return true;
	}
    public static void merge(int[] a, int[] leftside, int[] rightside, int left, int right) {
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < left && j < right) {
        if (leftside[i] <= rightside[j]) {
            a[k++] = leftside[i++];
        }
        else {
            a[k++] = rightside[j++];
        }
    }
    while (i < left) {
        a[k++] = leftside[i++];
    }
    while (j < right) {
        a[k++] = rightside[j++];
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
} void printArray(int[] arr)
{
    //this method helps us print out the array
    for (int i = 0; i < arr.length; i++){
    System.out.print(arr[i] + " ");
    System.out.println();
    }
}
    
     public static void main(String args[]){
         Scanner scan = new Scanner(System.in);
         System.out.println("how many elements?");
         int input = scan.nextInt();
         Random randomize = new Random();
         int[] array = new int[input];
         
         for (int i = 0; i < array.length; i++) {
			array[i] = randomize.nextInt(1000);
		}
         
         RecursiveMergeSort e = new RecursiveMergeSort();
         e.printArray(array);
         double start = System.nanoTime();
         e.mergeSort(array, input);
         System.out.println("Sorted:");
         double end = System.nanoTime();
         double total = end - start;
         e.printArray(array);
         System.out.println("It took " + total + " nanoseconds.");
         
         
     }
}
