package array.one_dimensional_array;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

public class ReverseArrayRecursive {

	// function to reverse an array - Recursively
	public static void reverseArray(int[] arr, int start, int end) {
		
		int temp;
		if (start >= end)
			return;
		
		// Swapping
		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
		// Calling the same function recursively
		reverseArray(arr, start + 1, end - 1);
	}

	// Main || Driver Method
	public static void main(String[] args) {

		int MAX;
		try {
			System.out.print("How many elements do you want to store? ");
			MAX = UserIO.readInt();

			int[] arr = ArrayIO.readArray(MAX);

			System.out.println("Original Array : ");
			ArrayIO.printArray(arr);

			reverseArray(arr, 0, MAX - 1);
			System.out.println("\nArray after reversing : ");
			ArrayIO.printArray(arr);
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

// Time Complexity : O(n)

