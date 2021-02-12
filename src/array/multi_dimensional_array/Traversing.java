package array.multi_dimensional_array;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// 3-D array - implementation
// length of a 3-D array = array_index
public class Traversing {
	
	// Reading the elements of an array from a user
	public static void readArray(int[][][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int k = 0; k < arr[i][j].length; k++) {
					System.out.print("Array[" + i + "]" + "[" + j + "]" + "[" + k + "]" +" : ");
					arr[i][j][k] = UserIO.readInt();
				}
			}
		}
		System.out.println();
	}
	
	// Traversing a 3-D array
	public static void traverse(int[][][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int k = 0; k < arr[i][j].length; k++) {
					System.out.print(arr[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void print(int[][][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int k = 0; k < arr[i][j].length; k++) {
					System.out.println("Array[" + i + "]" + "[" + j + "]" + "[" + k + "]" +" : " + arr[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		try {
			int[][][] arr = new int[2][2][2]; // int[array_index][rows][cols] arr
			
			// System.out.println(arr.length); // length = array_index
			
			readArray(arr);
			
			System.out.println("3-D Array : ");
			traverse(arr);
			
			System.out.println("Array elements with thier location : ");
			print(arr);
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

// Time Complexity : O(array_index * rows * cols) in all the three cases
// Time Complexity : O(m * n * o) -> O(N)
// Space Complexity : O(1)


