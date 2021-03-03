package linkedList.doublyLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Program to traverse from the tail of a linked list
public class TraversingFromTail {

	// Structure of a Node
	class Node {
		Node prev;
		int data;
		Node next;

		// to create a new node
		public Node(int data) {
			this.prev = null;
			this.data = data;
			this.next = null;
		}
	}

	// pointer variables
	private Node head = null;
	private Node tail = null;

	// Creating a doubly linked list
	public void create() {

		int choice = 1;

		System.out.println("***************Adding the Nodes***************");
		while (choice == 1) {
			System.out.print("Enter any number : ");
			int data = UserIO.readInt();

			Node newNode = new Node(data);

			if (head == null) {
				head = tail = newNode;
			}
			else {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
			System.out.println(data + " is added successfully!");

			System.out.print("Do you want to add new node?(1 - Add/ 0 - Exit) : ");
			choice = UserIO.readInt();
		}
	}

	// Displaying all the nodes of a doubly linked list
	public void display() {

		if (head == null) {
			System.out.println("\nList is empty!");
			return;
		}
		else {
			Node temp = head;

			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
	}

	// Traversing
	public void traverse() {
		if (head == null) {
			System.out.println("\nList is empty!");
			return;
		}
		else {
			Node temp = tail;

			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.prev;
			}
		}
	}

	// Main || Driver method
	public static void main(String[] args) {
		try {
			TraversingFromTail dList = new TraversingFromTail();

			// Adding the nodes
			dList.create();

			// Display
			System.out.println("\nNodes of the Doubly Linked List : ");
			dList.display();

			// reverse
			System.out.println("\n\nTraversed the doubly linked list from tail : ");
			dList.traverse();
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



