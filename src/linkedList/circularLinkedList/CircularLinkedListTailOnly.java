package linkedList.circularLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Implementing the circular linked list by maintaining only a tail pointer only
public class CircularLinkedListTailOnly {

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

	// Main || Driver Method
	public static void main(String[] args) {
		try {
			CircularLinkedListTailOnly cList = new CircularLinkedListTailOnly();

			// Adding new nodes
			cList.create();

			// Display the nodes
			System.out.println("\nNodes of circular linked list are : ");
			cList.display();
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
