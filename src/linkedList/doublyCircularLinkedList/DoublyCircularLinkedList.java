package linkedList.doublyCircularLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Program to create and display a doubly circular linked list
public class DoublyCircularLinkedList {

	// Node
	class Node {
		Node prev;
		int data;
		Node next;

		// to create a node
		public Node(int data) {
			this.prev = null;
			this.data = data;
			this.next = null;
		}
	}

	// pointers to point to the node
	private Node head = null;
	private Node tail = null;

	// Creation 
	public void create() {

		int choice = 1;

		System.out.println("***************Adding Nodes***************");
		while (choice == 1) {
			System.out.print("Enter any number : ");
			int data = UserIO.readInt();

			Node newNode = new Node(data);

			if (head == null) {
				head = tail = newNode;
				tail.next = head;
				head.prev = tail;
			}
			else {
				tail.next = newNode;
				newNode.prev = tail;
				newNode.next = head;
				head.prev = newNode;
				tail = newNode;
			}
			System.out.println(data + " is added successfully!");

			System.out.print("Do you want to add new node?(1 - Add/ 0 - Exit) : ");
			choice = UserIO.readInt();
		}
	}

	// Display - Print
	public void print() {

		// Checks if the list is empty
		if (head == null) {
			System.out.println("\nList is empty!");
			return;
		}
		else {
			Node temp = head;

			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			} while (temp != tail.next);
		}
	}

	// Main || Driver method
	public static void main(String[] args) {
		try {
			DoublyCircularLinkedList dList = new DoublyCircularLinkedList();

			// Adding the new nodes
			dList.create();

			// Display
			System.out.println("\nNodes of Doubly Circular Linked List : ");
			dList.print();
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

// Time Complexity of create() : O(1)
// Time Complexity of print() : O(n)



