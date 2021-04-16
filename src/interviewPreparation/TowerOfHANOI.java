package interviewPreparation;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

/*
 * @Author: Niraj Thagunna
 * Algorithm for the Tower of Hanoi Problem - only for the 3 towers
 */

public class TowerOfHANOI {
	
	// function to solve the tower of hanoi mathematical puzzle
	public static void towerOfHanoi(int disk, char source, char dest, char temp) { // disk = total no. of the disks
		
		// if only one disk is present then move to the destination tower directly
		if (disk == 1) {
			System.out.println("Move disk " + disk + " from tower " + source + " to tower " + dest);
			return; // The return keyword finished the execution of a method.
		}
		else { // disk >= 2
			
			// divide the whole stack into to parts longest stack with n disks
			// and the other stack with (n - 1) disks
			towerOfHanoi(disk - 1, source, temp, dest); // moving (n - 1) disks from source to temp
			
			// Moving n-th disk from source to destination
			System.out.println("Move disk " + disk + " from tower " + source + " to tower " + dest);
			
			// Moving all the (n - 1) disks from temp to destination tower
			towerOfHanoi(disk - 1, temp, dest, source);
		}
	}
	
	// Main or driver method
	public static void main(String[] args) {
		try {
			System.out.print("Enter the number of disks : ");
			int disks = UserIO.readInt();
			
			towerOfHanoi(disks, 'A', 'B', 'C');
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

/*
 * Time Complexity : O(2^n)
 * Space Complexity : O(n)
 * 
 * For n number of disks, 
 * 		the total number of moves are : (2^n - 1)
 */






