package linkedList.circularLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Program to reverse a circular linked list
public class Reverse {

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
	
	// Reversing a circular linked list
	public void reverse() {
		
		// Checks if the list is empty
		if (tail == null) {
			System.out.println("List is empty!");
			return;
		}
		else {
			Node prevNode, currentNode, nextNode;
			prevNode = null;
			currentNode = tail.next;
			nextNode = currentNode.next;
			
			while (currentNode != tail) {
				prevNode = currentNode;
				currentNode = nextNode;
				nextNode = currentNode.next;
				currentNode.next = prevNode;
			}
			
			nextNode.next = tail;
			tail = nextNode;
		}
	}

	// Main || Driver Method
	public static void main(String[] args) {
		try {
			Reverse cList = new Reverse();

			// Adding new nodes
			cList.create();

			// Display the nodes
			System.out.println("\nOriginal linked list : ");
			cList.display();
			
			// Reverse
			cList.reverse();
			
			System.out.println("\n\nReversed linked list : ");
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

// Time Complexity : O(n)


