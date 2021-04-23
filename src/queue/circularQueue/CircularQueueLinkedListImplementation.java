package queue.circularQueue;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Algorithm for the implementation of the Circular Queue using Linked List - Circular Singly Linked List

public class CircularQueueLinkedListImplementation {
	
	// Creating a node - Structure of a node
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// Node pointers
	private Node front = null;
	private Node rear = null;
	
	// Checks if the queue is empty
	public boolean isEmpty() {
		
		if (front == null && rear == null) 
			return true;
		else
			return false;
	}
	
	// enqueue()
	public void enqueue() {
		System.out.print("Enter the number to be insert : ");
		int data = UserIO.readInt();
		Node newNode = new Node(data);
		
		if (isEmpty()) {
			front = rear = newNode;
			rear.next = newNode; // Making the circular linked list
		}
		else {
			rear.next = newNode; // enqueue is happened at rear end only that's why
			rear = newNode;
			rear.next = front;
		}
		
		System.out.println(data + " is enqueued successfully!");
	}
	
	// dequeue()
	public void dequeue() {
		
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			return;
		}
		else if (front == rear) {
			System.out.println("Dequeued element is : " + front.data);
			
			front = rear = null;
		}
		else {
			System.out.println("Dequeued element is : " + front.data);
			
			Node temp = front; // dequeue is happened at the front end only
			front = front.next;
			rear.next = front;
			temp.next = null; // free up the deleted node
		}
	}
	
	// peek()
	public void peek() {
		
		if (isEmpty()) {
			System.out.println("Queue is Empty!");
			return;
		}
		else {
			System.out.println("Peeked element is : " + front.data); // peek() - at the front end
		}
	}
	
	// display()
	public void display() {
		
		if (isEmpty()) {
			System.out.println("Queue is Empty!");
			return;
		}
		else {
			Node temp = front; // accessing the data is happened from the front end
			
			System.out.println("Elements of the Queue are : ");
			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			} while (temp != front);
			
			// Line separator
			System.out.println();
		}
	}

	// Main or Driver method
	public static void main(String[] args) {

		try {
			CircularQueueLinkedListImplementation queue = new CircularQueueLinkedListImplementation();
			
			do {
				System.out.println("********** Circular Queue - Linked List Implementation ***********");
				System.out.println("1. Adding the elements\n2. Deleting the elements\n3. Printing the front element of the queue"
						+ "\n4. Displaying the elements of the Circular Queue\n5. Exit.");
				System.out.println("=============================================================");
				System.out.print("Enter your choice : ");
				int choice = UserIO.readInt();

				switch ( choice ) {

				case 1:
					queue.enqueue();
					break;

				case 2:
					queue.dequeue();
					break;

				case 3:
					queue.peek();
					break;

				case 4:
					queue.display();
					break;

				case 5:
					System.exit(0);
					break;

				default :
					System.out.println("Invalid Choice!!!");
				}

			} while (true);
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


/*
 * isEmpty() - O(1)
 * enqueue() - O(1)
 * dequeue() - O(1)
 * peek() - O(1)
 * display() - O(n)
 * 
 * Space Complexity : O(1)
 */





