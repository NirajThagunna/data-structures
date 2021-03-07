package linkedList.circularLinkedList;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Creation and display - Circular linked list - maintaining both the head and tail pointers
public class CircularLinkedList {

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head = null;
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
			if (head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}

			// link the last node with head node that forms a circle called circular linked list
			tail.next = head;
			System.out.println(data + " is added successfully!");

			System.out.print("Do you want to add new node(1 - Yes/ 0 - No) : ");
			choice = UserIO.readInt();
		}
	}

	// Display
	public void display() {
		if (head == null) {
			System.out.println("\nList is empty!");
			return;
		}
		else {
			Node temp = head;

			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			} while (temp != head);
			
//			System.out.println("\nSuccess : " + temp.data);
		}
	}

	// Main || Driver Method
	public static void main(String[] args) {
		try {
			CircularLinkedList cList = new CircularLinkedList();

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

// Time Complexities : 
// 		-> Creation - O(1)
//      -> Display - O(n)
// Space Complexity : O(1)



