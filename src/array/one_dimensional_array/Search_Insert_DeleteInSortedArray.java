package array.one_dimensional_array;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

class SearchInsertDeleteOperations {
	// local/instance variables
	public int MAX;
	public int[] arr;
	
	// Add Elements
	public void addElements() {
		System.out.print("How many elements do you want to store? ");
		MAX = UserIO.readInt();
		
		// Initializing an array
		arr = new int[MAX];
		
		// Adding the elements one by one in an array, arr[]
		for (int i = 0; i < MAX; i++) {
			System.out.print("Enter any number : ");
			arr[i] = UserIO.readInt();
		}
		System.out.println("Added elements successfully!");
		System.out.println();
	}
	
	// Display
	public void display() {
		for (int i = 0; i < MAX; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}
}

public class Search_Insert_DeleteInSortedArray {
	public static void main(String[] args) {
		try {
			int choice;
			SearchInsertDeleteOperations op = new SearchInsertDeleteOperations();
			while (true) {
				System.out.println("*********** Menu ***********");
				System.out.println("=============================");
				System.out.println("1. Add elements\n2. Display\n3. Search\n4. Insert at the end\n5. Delete an element by position"
						+ "\n6. Delete an element\n7. Exit");
				System.out.println("=============================");

				System.out.print("Enter your choice : ");
				choice = UserIO.readInt();

				switch (choice) {
				case 1 :
					op.addElements();
					break;

				case 2 :
					System.out.println("\nElements of an array are : ");
					op.display();
					break;

				case 7 :
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice!\n");
				}
			}
		}
		catch(Exception ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String error = sw.toString();
			System.out.println("Error : \n" + error);
		}
	}
}
