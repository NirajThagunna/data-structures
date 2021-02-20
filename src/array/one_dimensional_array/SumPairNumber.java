package array.one_dimensional_array;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Given an array A[] and a number x, check for pair in A[] with sum as x
//		-> Write a program that, given an array A[] of n numbers and another number x, determines whether or not there exist
// 		   two elements in S whose sum is exactly x. 

public class SumPairNumber {
	
	// function to find the pair of numbers to find the sum is equal to the number x
	public static void sumPair(int[] arr, int n, int sum) {
		
		int i, j;
		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				if (arr[i] + arr[j] == sum) {
					System.out.print(arr[i] + ", " + arr[j] + " ");
				}
			}
		}
		System.out.println();
	}
	
	// Main || Driver method
	public static void main(String[] args) {
		
		int MAX;
		try {
			System.out.print("How many elements do you want to store? ");
			MAX = UserIO.readInt();
			
			int[] arr = ArrayIO.readArray(MAX);
			
			System.out.print("Original Array : ");
			ArrayIO.printArray(arr);
			
			System.out.print("\nSum = ");
			int sum = UserIO.readInt();
			
			System.out.print("\nSum pair : ");
			sumPair(arr, MAX, sum);
		}
		catch (Exception ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String error = sw.toString();
			System.out.println("Error : \n" + error);
		}
	}
}
