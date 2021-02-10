package array.one_dimensional_array;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

public class ReverseArray {
	
	// Reversing an array
	public static void reverseArray(int[] arr, int n) {
		
		int start = 0, end = n - 1;
		
		while (start < end) {
			
			// Swapping
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			// Increment/Decrement
			start++;
			end--;
		}
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
			
			reverseArray(arr, MAX);
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

