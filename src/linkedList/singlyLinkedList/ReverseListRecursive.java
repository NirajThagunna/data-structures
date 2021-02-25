package linkedList.singlyLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Program to reverse a linked list Recursively
public class ReverseListRecursive {

	// Representing a node of the singly linked list
	// Node - User-defined data type
	class Node {
		int data; // data
		Node next; // pointer (or reference) to the next node

		// Constructor to create a new node
		// by default the next will initialized as null
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// Representing a head and tail of the linked list - initially
	private Node head = null;
	private Node tail = null;


	// Adding a new node to the list
	public void addNode() {

		int choice = 1, data;

		System.out.println("**********Adding the nodes************");
		while (choice == 1) {

			System.out.print("Enter any element : ");
			data = UserIO.readInt();

			// Creating a new node
			Node newNode = new Node(data);

			// Checks if the list is empty
			if (head == null) {
				// If the list is empty, then both the head and tail will point to the newNode
				head = newNode;
				tail = newNode;
			}
			else {
				// newNode will be added after tail such that tail's next will point to newNode
				tail.next = newNode;

				// newNode will become new tail of the list
				tail = newNode;
			}
			System.out.println(data + " is added successfully!");

			System.out.print("Do you want to add new node(1 - Yes/Add 0 - No/Exit) : ");
			choice = UserIO.readInt();
		}
	}

	// display all the nodes present in the linked list
	public void display() {

		// Accessing the start-initial node
		Node current = head; // it will represent the node which point by head pointer

		// Checks if the nodes present in the linked list or not
		if (head == null) {
			System.out.println("Linked list is empty!");
			return;
		}

//		System.out.println("\nNodes of singly linked list : ");
		while (current != null) {
			// Printing each node by incrementing pointer
			System.out.print(current.data + " ");
			current = current.next; // current will store a pointer or reference to the next node
		}

		System.out.println();
	}
	
	// function to reverse a linked list Recursively - divide and conquer technique is used
	public void reverse(Node node) { // Node node = head
		
		// Checks if the list is empty or not
		if (head == null) {
			System.out.println("\nList is empty!");
			return;
		}
		else {
			// if there is only one node is present, then print that node
			if (node.next == null) {
				System.out.print(node.data + " ");
				return;
			}
			
			// it will also called else block
			// call the reverse() function recursively
			reverse(node.next); // call the reverse() function for next node -> it will take pointer or reference
			System.out.print(node.data + " ");
		}
	}

	// Main||Driver method
	public static void main(String[] args) {
		try {
			ReverseListRecursive sList = new ReverseListRecursive();

			// Adding new nodes to the linked list
			sList.addNode();

			// Displays the nodes present in the list
			System.out.println("\nNodes of singly linked list are : ");
			sList.display();

			// reverse a linked list
			System.out.println("\nNodes of the singly linked list after reversing : ");
			sList.reverse(sList.head);
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


