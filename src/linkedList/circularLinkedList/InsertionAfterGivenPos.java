package linkedList.circularLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Program to insert a new node after a given position
public class InsertionAfterGivenPos {

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node tail = null;

	// Creation
	public void create() {

		int data, choice = 1;

		System.out.println("************Adding Nodes****************");
		while (choice == 1) {		
			System.out.print("Enter any number : ");
			data = UserIO.readInt();

			// Creating a new node
			Node newNode = new Node(data);

			// Checks if the list is empty
			if (tail == null) {
				tail = newNode;
				tail.next = newNode; // circular form
			}
			else {
				newNode.next = tail.next;
				tail.next = newNode;
				tail = newNode;
			}
			System.out.println(data + " is added successfully!");

			System.out.print("Do you want to add new node(1 - Yes/ 0 - No) : ");
			choice = UserIO.readInt();
		}
	}

	// Display
	public void display() {
		if (tail == null) {
			System.out.println("\nList is empty!");
			return;
		}
		else {
			Node temp = tail.next;

			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			} while (temp != tail.next);

			//			System.out.println("\nSuccess : " + temp.data);
		}
	}

	// Finding the length of a circular linked list
	public int getLength() {

		int count = 0;

		if (tail == null) {
			return 0;
		}
		else {
			Node temp = tail.next;

			do {
				count++;
				temp = temp.next;
			} while (temp != tail.next);
		}

		return count;
	}
	
	// Inserting a new node after a given position
	public void insert(int length) {
		System.out.print("\nEnter the position : ");
		int pos = UserIO.readInt();
		
		if (pos > length) {
			System.out.println("\nPlease enter the valid position!");
			return;
		}
		else {
			Node temp = tail.next;
			
			for (int i = 0; i < pos - 1; i++) {
				temp = temp.next;
			}
			
			System.out.print("\nEnter the element to be insert : ");
			int data = UserIO.readInt();
			
			// Creating a new node to be insert
			Node newNode = new Node(data);
			
			// placing the new node at specified position
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	// Main || Driver Method
	public static void main(String[] args) {
		try {
			InsertionAfterGivenPos cList = new InsertionAfterGivenPos();

			// Adding new nodes
			cList.create();

			// Display the nodes
			System.out.println("\nNodes of circular linked list before insertion are : ");
			cList.display();

			// Length
			int length;
			length = cList.getLength();
			System.out.println("\nLength of a circular linked list before insertion is : " + length);

			// Delete
			cList.insert(length);

			System.out.println("\nNodes of circular linked list after insertion are : ");
			cList.display();

			length = cList.getLength();
			System.out.println("\nLength of a circular linked list after insertion is : " + length);

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



