package linkedList.doublyLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Program to delete a node from a specified position
public class DeleteFromGivenPos {

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

	// finding the length of a doubly linked list
	public int getLength() {

		int count = 0;

		if (head == null) {
			return 0;
		}
		else {
			Node temp = head;

			while (temp != null) {
				count++;
				temp = temp.next;
			}
		}

		return count;
	}
	
	// Delete a node from a specified position
	public void delete(int length) {
		
		System.out.print("\nEnter the position : ");
		int pos = UserIO.readInt();
		
		if (pos > length) {
			System.out.println("\nPlease enter the valid position!");
			return;
		}
		else {
			if (head == null) {
				System.out.println("\nList is empty!");
				return;
			}
			else {
				Node temp = head;
				
				for (int i = 1; i < pos; i++) {
					temp = temp.next;
				}
				
				// delete
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				temp.prev = null;
				temp.next = null;
			}
		}
	}

	// Main || Driver method
	public static void main(String[] args) {
		try {
			DeleteFromGivenPos dList = new DeleteFromGivenPos();

			// Adding the nodes
			dList.create();

			// Display
			System.out.println("\nNodes of the Doubly Linked List before deletion : ");
			dList.display();

			// Length
			int length;
			length = dList.getLength();
			System.out.println("\nLength before deletion : " + length);

			// push() - insert
			dList.delete(length);

			// After Insertion
			System.out.println("\nNodes of the Doubly Linked List after deletion : ");
			dList.display();

			// Length
			length = dList.getLength();
			System.out.println("\nLength after deletion : " + length);
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



