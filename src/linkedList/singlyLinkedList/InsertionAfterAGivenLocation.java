package linkedList.singlyLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Java Program to insert a node after a given location - O(n)
public class InsertionAfterAGivenLocation {

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

	// length Iteratively
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

	// Inserting a node after a given location
	public void insert(int length) {

		System.out.print("\nEnter the position : ");
		int pos = UserIO.readInt();

		if (pos > length) {
			System.out.println("\nPlease enter the valid position!");
			return;
		}
		else {
			Node temp = head;

			// It will find the position of a node after which you want to insert a node
			for (int i = 0; i < pos - 1; i++) {
				temp = temp.next;
			}

			System.out.print("\nEnter the element you want to insert : ");
			int data = UserIO.readInt();

			// Creating a new node
			Node newNode = new Node(data);

			// inserting a new node after a given position
			newNode.next = temp.next; // link between the new node and a node after the given position node
			temp.next = newNode; // link between the given position node and newNode
		}
	}

	// Main||Driver method
	public static void main(String[] args) {
		try {
			InsertionAfterAGivenLocation sList = new InsertionAfterAGivenLocation();

			// Adding new nodes to the linked list
			sList.addNode();

			// Displays the nodes present in the list
			System.out.println("\nNodes of singly linked list are : ");
			sList.display();

			// length
			int length;
			length = sList.getLength();
			System.out.println("\nLength of linked list before inserting a node : " + length);

			// inserting a new node after a given location
			sList.insert(length);
			System.out.println("\nNodes of a linked list after insertion : ");
			sList.display();

			// length
			length = sList.getLength();
			System.out.println("\nLength of linked list after inserting a node : " + length);
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


