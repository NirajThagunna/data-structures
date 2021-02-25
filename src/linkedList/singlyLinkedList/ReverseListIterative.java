package linkedList.singlyLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Program to reverse a linked list Iteratively
public class ReverseListIterative {

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
	
	// function to reverse a linked list Iteratively
	public void reverse() {
		
		if (head == null) {
			System.out.println("\nList is empty!");
			return;
		}
		else {
			Node prevNode, currentNode, nextNode;
			prevNode = null; // initially there are no any node before the start or initial node so, prevNode = null
			currentNode = nextNode = head; // currentNode and nextNode will point to first node
			
			while (nextNode != null) { // loop till the last node or end
				nextNode = nextNode.next; // before destroy the link make a path to traverse new node
				currentNode.next = prevNode; // in current node store the pointer or reference of prevNode
				prevNode = currentNode; // increment prevNode pointer
				currentNode = nextNode; // increment currentNode pointer one node ahead
			}
			
			head = prevNode; // change the head pointer to point to the last node
		}
	}

	// Main||Driver method
	public static void main(String[] args) {
		try {
			ReverseListIterative sList = new ReverseListIterative();

			// Adding new nodes to the linked list
			sList.addNode();

			// Displays the nodes present in the list
			System.out.println("\nNodes of singly linked list : ");
			sList.display();
			
			// reverse a linked list
			sList.reverse();
			System.out.println("\nNodes of the linked list after reversing : ");
			sList.display();
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

