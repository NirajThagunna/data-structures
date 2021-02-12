package array.twoDimensionalArray;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// 2D Array - Implementation
// length of a 2D array = the number of rows it has
// The number of columns may vary row to row, which is why the number of rows is used as the length of the 2D array
public class Traversing {

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

	// Traversing a 2-D array
	public static void printArray(int[][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
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

	public static void main(String[] args) {
		try {
			// declare and initialize a 2-D array 
			int[][] arr = new int[3][4]; // int[row][column] arr 

			// System.out.println(arr.length); // number of rows 
			// System.out.println(arr[0].length); // number of columns 

			readArray(arr);
			
			System.out.println("2-D Array in a linear form : ");
			printArray(arr);
			
			System.out.println("\n2-D array in a tabular form : ");
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

// The time complexity will be O (n*m) in all three cases where n the number of arrays which is the 1st dimension and m the 
// max size of each internal array ie, the 2nd dimension. 
// The time complexity is O(N), which means its time complexity is linear.
// Time Complexity : O(m * n), where m = no. of rows and n = no. of columns
// e.g. m = 9, n = 9 so that m * n = 81, it will not execute more than 81 times, so time complexity = O(N) - linear time
// Space Complexity : O(1) i.e. constant space - in-place

