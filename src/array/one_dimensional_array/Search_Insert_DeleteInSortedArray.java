package array.one_dimensional_array;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.ArrayIO;
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
		arr = new int[MAX + 1];

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

	// Searching an element
	public int binarySearch(int low, int high, int key) {

		if (low == high) {
			if (arr[low] == key) {
				return low;
			}
			else {
				return -1;
			}
		}

		else if (low < high) {
			int mid = (low + high) / 2;

			if (key == arr[mid]) {
				return mid;
			}

			else if (key < arr[mid]) {
				return binarySearch(low, mid - 1, key); 
			}

			else {
				return binarySearch(mid + 1, high, key);
			}
		}

		else {
			return -1;
		}
	}

	public void search() {
		System.out.print("\nEnter the element to be search : ");
		int key = UserIO.readInt();

		int index = binarySearch(0, MAX - 1, key);
		if (index == -1) {
			System.out.println("\n" + key + " is not present in a given array." + "\n");
		}
		else {
			System.out.printf("\n%d is present at position %d.\n", key, index + 1);
		}
	}

	// Inserting an element at specified position
	public int insertSorted(int key) {
		
		// If the array contains more elements than it's capacity then it will return MAX
		if (MAX >= arr.length) { // MAX = int[MAX], size of the input array and arr.length = int[MAX + 1]
			return MAX;
		}
		
		int i;
		for (i = MAX - 1; (i >= 0 && arr[i] > key); i--) {
			arr[i + 1] = arr[i];
		}
		arr[i + 1] = key;
		
		return (MAX + 1);
	}
	
	public void insert() {
		
		int i;
		System.out.println("\nOriginal Array : ");
		for (i = 0; i < MAX; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		System.out.print("\nEnter the element to be insert : ");
		int key = UserIO.readInt();
		
		int n = insertSorted(key);
		System.out.println("\nArray after inserting an element : ");
		for (i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}
	
	// Deleting an element from a given array
	public void delete() {
		int i;
		
		System.out.println("\nOriginal Array : ");
		for (i = 0; i < MAX; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		System.out.print("\nEnter the element to to be delete : ");
		int ele = UserIO.readInt();
		
		int index = binarySearch(0, MAX - 1, ele);

		for (i = index; i < MAX - 1; i++) {
			arr[i] = arr[i + 1];
		}
		
		System.out.println("\nArray after deleting an element : ");
		for (i = 0; i < MAX - 1; i++) {
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
				System.out.println("1. Add elements\n2. Display\n3. Search\n4. Insert an element in it's correct position"
						+ "\n5. Delete an element\n6. Exit");
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

				case 3 :
					op.search();
					break;
					
				case 4 :
					op.insert();
					break;
					
				case 5 :
					op.delete();
					break;

				case 6 :
					System.out.println("Great Job! - Finished Process!");
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

/*
 * Time Complexities :
 * 		1) Add elements : O(n)
 *      2) Display : O(n)
 *      3) Search : O(log n)
 *      4) Insert an element in it's correct position : O(n)
 *      5) Delete an element : O(n)
 */

