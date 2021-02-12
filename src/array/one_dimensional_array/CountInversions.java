package array.one_dimensional_array;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted 
// then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
// Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j 

public class CountInversions {

	// function to count the inversions
	public static int countInversions(int[] arr, int n) {

		int count = 0;

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {

				if (arr[i] > arr[j]) {
					count++;
				}
			}
		}

		return count;
	}

	// function to print the pairs of inversions
	public static void printInversions(int[] arr, int n) {

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {

				if (arr[i] > arr[j]) {
					System.out.print("(" + arr[i] + ", " + arr[j] + ")" + ", ");
				}
			}
		}
	}

	// Main || Driver method
	public static void main(String[] args) {

		int MAX;
		try {
			System.out.print("How many elements do you want to store? ");
			MAX = UserIO.readInt();

			int[] arr = ArrayIO.readArray(MAX);

			System.out.println("Original Array : ");
			ArrayIO.printArray(arr);

			int result = countInversions(arr, MAX);
			System.out.println("\nNumber of inversions are : " + result);

			System.out.println("\nGiven array has " + result + " inversions:");
			printInversions(arr, MAX);
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

// Complexity Analysis: 
// 		-> Time Complexity : O(n^2), Two nested loops are needed to traverse the array from start to end. 
//         so, the Time complexity is O(n^2).

// 		-> Space Complexity : O(1), No extra space is required.


