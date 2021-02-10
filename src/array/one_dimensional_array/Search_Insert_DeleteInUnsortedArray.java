package array.one_dimensional_array;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

class UnsortedArrayOperation {

	// Global variables, Instance fields/variables
	public static int MAX;
	public static int[] arr;

	// Adding an elements in an array
	public static void addElement() {
		System.out.print("How many elements do you want to store? ");
		MAX = UserIO.readInt();

		arr = new int[MAX + 1];

		for (int i = 0; i < MAX; i++) {
			System.out.print("Enter any number : ");
			arr[i] = UserIO.readInt();
		}
		System.out.println();
	}

	// Displaying an elements of an array
	public static void display() {
		for (int i = 0; i < MAX; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	// Searching an element from an array
	public static int search(int key) {
		for (int i = 0; i < MAX; i++) {
			if (arr[i] == key) {
				return i; // If you use return statement then you can't use break statement to terminate the loop
				// return statement also terminate the loop if the condition becomes true
			}
		}
		return -1;
	}

	public static void searchElement() {
		System.out.print("Enter the element to be search : ");
		int key = UserIO.readInt();

		int result = search(key);
		if (result == -1) {
			System.out.println(key + " is not present in a given array.\n");
		}
		else {
			System.out.printf("%d is present at position %d.\n\n", key, result + 1);
		}
	}

	// Inserting an element
	public static void insert() {
		System.out.print("Enter the element to be insert : ");
		int num = UserIO.readInt();

		System.out.println("\nArray before inserting : ");
		display();

		arr[MAX] = num;

		System.out.println("Array after inserting an element : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		System.out.println("Length of an array is : " + arr.length + "\n");
	}

	// Deleting an element at specified position from a given array
	public static void deleteByPos() {
		System.out.println("\nArray before deleting an element : ");
		display();

		System.out.print("Enter the position of an element to be delete : ");
		int pos = UserIO.readInt();

		for (int i = pos - 1; i < MAX - 1; i++) {
			arr[i] = arr[i + 1];
		}

		System.out.println("Array after deleting an element : ");
		for (int i = 0; i < MAX - 1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	// Deletion
	// Searching an element to be delete by using Linear Searching algorithm, if found then return index of that element
	// otherwise return -1
	public static int searchElementToBeDelete(int num) {
		for (int i = 0; i < MAX; i++) {
			if (arr[i] == num) {
				return i;
			}
		}
		return -1;
	}

	public static int deleteElement(int num) {
		int pos = searchElementToBeDelete(num);

		if (pos == -1) {
			System.out.println(num + " is not found in a given array.\n");
			return MAX;
		}
		
		// Deleting an element
		for (int i = pos; i < MAX - 1; i++) {
			arr[i] = arr[i + 1];
		}
		
		return (MAX - 1);
	}
	
	public static void delete() {
		System.out.println("\nOriginal Array : ");
		display();

		System.out.print("Enter the element to be delete : ");
		int num = UserIO.readInt();

		int n = deleteElement(num);
		
		if (n == MAX) {
			return;
		}
		
		System.out.println("\nArray after deleting an element : ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}
}

public class Search_Insert_DeleteInUnsortedArray extends UnsortedArrayOperation {
	public static void main(String[] args) {
		try {
			int choice;
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
					addElement();
					break;

				case 2 :
					System.out.println("Elements of an array are : ");
					display();
					break;

				case 3 :
					searchElement();
					break;

				case 4 :
					insert();
					break;

				case 5 :
					deleteByPos();
					break;

				case 6 :
					delete();
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

// Time Complexities:
// Add: O(n)
// Search: O(n)
// Insert: O(1)
// Delete: O(n)
