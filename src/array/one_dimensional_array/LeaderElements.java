package array.one_dimensional_array;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
import basicIO.UserIO;

// Write a program to print all the LEADERS in the array. 
// An element is leader if it is greater than all the elements to its right side. 
// And the rightmost element is always a leader. 
// For example in the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
public class LeaderElements {
	
	// function to print all the leader elements
	public static void printLeaders(int[] arr, int n) {
		
		// Rightmost element is always leader 
		int leaderElement = arr[n - 1];
		System.out.print(leaderElement + " ");
		
		for (int i = n - 2; i >= 0; i--) {
			
			// check, element >= leader (right most elements)
			if (arr[i] >= leaderElement) {
				leaderElement = arr[i];
				System.out.print(leaderElement + " ");
			}
		}
	}
	
	// Main || Driver function
	public static void main(String[] args) {
		
		int MAX;
		try {
			System.out.print("How many elements do you want to store? ");
			MAX = UserIO.readInt();
			
			int[] arr = ArrayIO.readArray(MAX);
			
			System.out.println("Original Array : ");
			ArrayIO.printArray(arr);
			
			System.out.println("\nLEADER elements are : ");
			printLeaders(arr, MAX);
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
// Space Complexity : O(1)


