/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author rohan
 */
import java.util.Scanner;
import static java.lang.System.currentTimeMillis;
import java.util.Random;
public class MergeSort {
    void mergeSort(int[] a)
	{       //Figures out start time and end time
                long startTime = System.nanoTime();

                long endTime = System.nanoTime();

                // Calculates the processing time by finding the end time - star ttime
                long timeElapsed = (endTime - startTime);
                System.out.println("Processing Time: " + timeElapsed + "ns");
	}
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
         double start = currentTimeMillis();
         Random randomize = new Random();
         int[] array = new int[input];
         
         for (int i = 0; i < array.length; i++) {
			array[i] = randomize.nextInt(1000);
		}
         
         MergeSort e = new MergeSort();
         e.printArray(array);
         e.mergeSort(array, input);
         System.out.println("Sorted:");
         double end = currentTimeMillis();
         double total = end - start;
         e.printArray(array);
         System.out.println(total + " milliseconds.");
         
         
     }
}
