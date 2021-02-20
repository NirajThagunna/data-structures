package linkedList.singlyLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Inserting a node at beginning of a linked list
public class InsertionAtBeginning {

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

			System.out.print("Do you want to add new node(1 - Yes/Add/ 0 - No/Exit) : ");
			choice = UserIO.readInt();
		}
	}

	// Inserting a new node at beginning
	public void push() {

		System.out.print("\nEnter the element you want to insert : ");
		int data = UserIO.readInt();

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
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

	// Main||Driver method
	public static void main(String[] args) {
		try {
			InsertionAtBeginning insert = new InsertionAtBeginning();

			// Add new nodes in the list
			insert.addNode();
			System.out.println("\nOriginal nodes of the singly linked list are : ");
			insert.display();

			// Inserting a new node at beginning
			insert.push();
			System.out.println("\nNodes of singly linked list after inserting at beginning : ");
			insert.display();
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

// Time complexity of push() is O(1) as it does constant amount of work.


