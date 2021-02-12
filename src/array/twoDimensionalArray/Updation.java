package array.twoDimensionalArray;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

public class Updation {

	// Reading the elements of a 2-D array from a user
	public static void readArray(int[][] arr) {

		for (int i = 0; i < arr.length; i++) { // for rows -> arr.length = no. of rows
			for (int j = 0; j < arr[i].length; j++) { // for columns -> arr[i].length = no. of columns
				System.out.print("Enter the element at row " + i + ", and at column " + j + " : ");
				arr[i][j] = UserIO.readInt();
			}
		}
		System.out.println();
	}

	// Traversing a 2-D array in a tabular or matrix form
	public static void traverse(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// Updating an array - element
	public static void update(int[][] arr, int ele) {
		arr[2][3] = ele;
	}

	public static void main(String[] args) {
		try {
			// declare and initialize a 2-D array 
			int[][] arr = new int[3][4]; // int[row][column] arr 

			// System.out.println(arr.length); // number of rows 
			// System.out.println(arr[0].length); // number of columns 

			readArray(arr);

			System.out.println("Original Array : ");
			traverse(arr);
			
			System.out.print("\nEnter the element to be update : ");
			int ele = UserIO.readInt();
			
			update(arr, ele);
			System.out.println("\nArray after updation : ");
			traverse(arr);
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

// Time Complexity : O(1)
// Space Complexity : O(1)

