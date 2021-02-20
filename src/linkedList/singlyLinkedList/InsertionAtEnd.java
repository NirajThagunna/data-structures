package linkedList.singlyLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Inserting a node at end of the linked list
public class InsertionAtEnd {

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
	
	// Inserting a node at end of the linked list
	public void append() { // Time Complexity : O(n)
		
		System.out.print("\nEnter the element you want to insert : ");
		int data = UserIO.readInt();
		
		// Creating a new node
		// 1. Allocate the Node & 
	    // 2. Put in the data 
	    // 3. Set next as null
		Node newNode = new Node(data);
		
		// Checks if the list is empty
		// If the Linked List is empty, then make the new node as head
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			// Traversing the list to find the last node, so that it will make the link between last and new node
			// Else traverse till the last node
			Node temp = head;
			
			// Traversing through the whole list and storing the pointer/reference by incrementing the pointer
			while (temp.next != null) {
				temp = temp.next;
			}
			
			// make a link between the last node and new node to insert at end of list
			// Change the next of last node
			temp.next = newNode;
		}
	}
	
	// Optimized version to insert a node at end - O(1)
	public void insertAtEnd() { // Time Complexity : O(1)
		
		System.out.print("\nEnter the element to be insert : ");
		int data = UserIO.readInt();
		
		Node newNode = new Node(data);
		
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		
		// tail will point to that node whose next field is null i.e. tail.next = null -> last node
		tail.next = newNode; // make a link between tail i.e. last node with new node
		tail = newNode; // now, tail becomes the new node of the list
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
			InsertionAtEnd insert = new InsertionAtEnd();

			// Add new nodes in the list
			insert.addNode();
			System.out.println("\nOriginal nodes of the singly linked list are : ");
			insert.display();

			// Inserting a new node at beginning
//			insert.append(); // append() function will take O(n) time complexity
			insert.insertAtEnd(); // insertAtEnd() will take O(1) time complexity
			System.out.println("\nNodes of singly linked list after inserting a node at end : ");
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

// Time complexity of append is O(n) where n is the number of nodes in linked list. Since there is a loop from head to end,
// the function does O(n) work. 
// This method can also be optimized to work in O(1) by keeping an extra pointer to tail of linked list.
// append() : Time Complexity = O(n)
// insertAtEnd() : Time Complexity = O(1)


