package queue;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

/*
 * @Author : Niraj Thagunna
 * Implementation of Queue using the Linked List
 */

public class QueueUsingLinkedList {

	// Structure of a Node 
	class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node front = null; // dequeue() -> peek() -> display()
	private Node rear = null; // enqueue()


	// Checks if the queue is empty or not
	public boolean isEmpty() {

		if (front == null && rear == null) 
			return true;
		else 
			return false;
	}

	// Insertion -> enqueue()
	public void enqueue() {

		System.out.print("Enter the element you want to add : ");
		int data = UserIO.readInt();

		Node newNode = new Node(data);

		if (isEmpty()) {
			front = rear = newNode;
		}
		else {
			// Increment the rear pointer
			rear.next = newNode;

			// make rear as newNode
			rear = newNode;
		}
		System.out.println(data + " is added into the queue successfully!");
	}

	// dequeue() -> deletion
	public void dequeue() {

		if (isEmpty()) {
			System.out.println("Queue Underflow");
			return;
		}
		else if (front == rear) {
			System.out.println("Dequed element is : " + front.data);
			
			// make the list empty by setting the values
			front = rear = null;
		}
		else {
			System.out.println("Dequed element is : " + front.data);

			// Point the node which is going to be deleted as temp
			Node temp = front; // temp -> node to be delete
			front = front.next; // Increment the front

			// freeing the temp node -> deleted
			temp.next = null;
		}
	}

	// peek() - return the data without deleting the data from the queue
	public void peek() {

		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		else {
			System.out.println("Peeked element is : " + front.data);
		}
	}

	// Displaying all the data elements from the queue
	public void display() {

		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		else {
			Node temp = front;

			System.out.println("Elements of the queue are : ");
			do {

				System.out.print(temp.data + " ");
				// Increment the temp pointer
				temp = temp.next;

			} while (temp != null);
			
			System.out.println();
		}
	}


	// Main - driver method
	public static void main(String[] args) {
		try {
			// Creating an object of QueueUsingLinkedList class so that we can access all the not static methods as well as data
			QueueUsingLinkedList list = new QueueUsingLinkedList();

			do {
				System.out.println("***************Implementation of Queue using Linked List******************");
				System.out.println("1. Enqueue()\n2. Dequeue()\n3. Peek()\n4. Display\n5. Exit");
				System.out.println("=====================================================================");

				System.out.print("Enter your choice : ");
				int choice = UserIO.readInt();

				switch( choice ) {

				case 1:
					list.enqueue();
					break;

				case 2:
					list.dequeue();
					break;

				case 3:
					list.peek();
					break;

				case 4:
					list.display();
					break;

				case 5:
					System.exit(0);
					break;

				default:
					System.out.println("Invalid Option!");
				}

			} while (true);

		}
		catch(Exception ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String error = sw.toString();
			System.out.println("Error : \n" + error);
		}
	}
}


/*
 * isEmpty() - O(1)
 * isFull() - O(1)
 * enqueue() - O(1)
 * dequeue() - O(1)
 * peek() - O(1)
 * display() - O(n)
 * 
 * Space Complexity : O(1)
 */






