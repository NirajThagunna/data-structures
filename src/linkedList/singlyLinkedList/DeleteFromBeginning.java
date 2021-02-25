package linkedList.singlyLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Program to delete a node from beginning
public class DeleteFromBeginning {

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
	
	// length of the linked list
	public int getLength() {
		
		int count = 0;
		Node temp = head;
		
		if (temp == null) {
			return 0;
		}
		else {
			while (temp != null) {
				count++;
				temp = temp.next;
			}
		}
		
		return count;
	}

	// Function to delete a node from the beginning of a linked list
	public void deleteAtBeg() {
		
		// Checks if the list is empty or not
		if (head == null) {
			System.out.println("\nList is empty!");
			return;
		}
		else {
			// store the head pointer in some temp variable
			Node temp = head; // storing the head node in temp variable
			head = temp.next; // now head will points the second node by temp.next
			temp.next = null; // free up the space -> distroy the link between temp node with second node by temp.next = null
		}
	}
	
	// Main||Driver method
	public static void main(String[] args) {
		try {
			DeleteFromBeginning sList = new DeleteFromBeginning();
			
			// Adding nodes
			sList.addNode();
			
			// display all the nodes
			System.out.println("\nNodes of linked list before deletion : ");
			sList.display();
			
			// length
			int length;
			length = sList.getLength();
			System.out.println("Length of linked list before deletion : " + length);
			
			// deleting a node from beginning
			sList.deleteAtBeg();
			System.out.println("\nNodes of linked list after deletion : ");
			sList.display();
			
			// length
			length = sList.getLength();
			System.out.println("Length of linked list after deletion : " + length);
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

