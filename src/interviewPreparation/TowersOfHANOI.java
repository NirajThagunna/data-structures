package interviewPreparation;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

/*
 * @Author: Niraj Thagunna
 * Algorithm for the Tower of Hanoi Problem - only for the 4 towers[A, B, C, D] with n number of disks in the tower A
 */

public class TowersOfHANOI {
	
	public static void towerOfHanoi(int n, char source, char dest, char temp1, char temp2) {
		
		if (n == 1) {
			System.out.println("Move disk " + n + " from tower " + source + " to tower " + dest);
		}
		else if (n == 2) {
			System.out.println("Move disk " + (n - 1) + " from tower " + source + " to tower " + temp1);
			System.out.println("Move disk " + n + " from tower " + source + " to tower " + dest);
			System.out.println("Move disk " + (n - 1) + " from tower " + temp1 + " to tower " + dest);
		}
		else { // n >= 3
			
			towerOfHanoi(n - 2, source, temp2, dest, temp1);
			
			// Moving the last two disks
			System.out.println("Move disk " + (n - 1) + " from tower " + source + " to tower " + temp1); // second largest disk in temp1 tower
			System.out.println("Move disk " + n + " from tower " + source + " to tower " + dest); // largest disk
			System.out.println("Move disk " + (n - 1) + " from tower " + temp1 + " to tower " + dest); // second largest disk from temp1 tower to destination
			
			towerOfHanoi(n - 2, temp2, dest, source, temp1);
		}
	}
	
	// Main or driver function
	public static void main(String[] args) {
		try {
			System.out.print("Enter the number of disks : ");
			int n = UserIO.readInt();
			
			towerOfHanoi(n, 'A', 'B', 'C', 'D');
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
 */














