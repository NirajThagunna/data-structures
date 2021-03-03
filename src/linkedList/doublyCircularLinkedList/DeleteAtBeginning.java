package linkedList.doublyCircularLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Program to delete a node from beginning of a linked list
public class DeleteAtBeginning {

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

	// length
	public int getLength() {

		int count = 0;

		if (head == null) {
			return 0;
		}
		else {
			Node temp = head;

			do {
				count++;
				temp = temp.next;
			} while (temp != tail.next);
		}

		return count;
	}
	
	// delete at beginning
	public void delete() {
		if (head == null) {
			System.out.println("\nList is empty!");
			return;
		}
		else {
			tail.next = head.next;
			head.next.prev = tail;
			head.next = null;
			head = tail.next;
		}
	}

	// Main || Driver method
	public static void main(String[] args) {
		try {
			DeleteAtBeginning dList = new DeleteAtBeginning();

			// Adding the nodes
			dList.create();

			// Display
			System.out.println("\nNodes of the Doubly Circular Linked List before deletion : ");
			dList.print();

			// Length
			int length;
			length = dList.getLength();
			System.out.println("\nLength before deletion : " + length);

			// push() - insert
			dList.delete();

			// After Insertion
			System.out.println("\nNodes of the Doubly Circular Linked List after deletion : ");
			dList.print();

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

// Time Complexity : O(1)



