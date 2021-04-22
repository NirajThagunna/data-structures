package queue.circularQueue;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

/*
 * @Author: Niraj Thagunna
 * Algorithm for implementation of Circular Queue using an Array
 * Circular Queue - Array Implementation
 */

public class CircularQueueArrayImplementation {
	
	// Properties of a Circular Queue
	// MAX length of the queue
	public static int MAX;
		
	static int[] circularQueue; // declaring an array
	
	private static int front = -1, rear = -1;
	
	// Checks if the queue is empty
	public static boolean isEmpty() {
		
		if (front == -1 && rear == -1)
			return true;
		else
			return false;
	}
	
	// Checks if the Queue is full
	public static boolean isFull() {
		
		if (front == ((rear + 1) % MAX)) // front == rear
			return true;
		else
			return false;
	}
	
	// enqueue()
	public static void enqueue() {
		
		System.out.print("Enter any element to be enqueued : ");
		int data = UserIO.readInt();
		
		// Checks if the queue is full
		if (isFull()) {
			System.out.println("Queue Overflow");
			return;
		}
		else if (isEmpty()) {
			front = rear = 0;
			circularQueue[rear] = data;
		}
		else {
			// Increment the rear pointer
			rear = (rear + 1) % MAX;
			circularQueue[rear] = data;
		}
		
		// Printing the enqueued data
		System.out.println(data + " is enqueued successfully!");
	}
	
	// peek()
	public static void peek() {
		
		if (isEmpty()) {
			System.out.println("Circular Queue is Empty");
			return;
		}
		else {
			System.out.println("Peeked element is : " + circularQueue[front]);
		}
	}
	
	// dequeue()
	public static void dequeue() {
		
		if (isEmpty()) {
			System.out.println("Circular Queue is Underflow");
			return;
		}
		else if (front == rear) {
			System.out.println("Dequeued element is : " + circularQueue[front]);
			front = rear = -1;
		}
		else {
			System.out.println("Dequeued element is : " + circularQueue[front]);
			front = (front + 1) % MAX; // Incrementing the front pointer
		}
	}
	
	// display()
	public static void display() {
		
		if (isEmpty()) {
			System.out.println("Circular Queue is Empty!");
			return;
		}
		else {
			System.out.println("Elements of the Circular Queue are : ");
			
			for (int i = front; i <= rear; i++) {
				System.out.print(circularQueue[i] + " ");
			}
			
			// Line separator
			System.out.println();
		}
	}
	
	// Main or Driver method
	public static void main(String[] args) {
		
		try {
			System.out.print("Enter the size of the Circular Queue : ");
			MAX = UserIO.readInt();
			
			circularQueue = new int[MAX];
			
			do {
				System.out.println("********** Circular Queue - Array Implementation ***********");
				System.out.println("1. Adding the elements\n2. Deleting the elements\n3. Printing the front element of the queue"
						+ "\n4. Displaying the elements of the Circular Queue\n5. Exit.");
				System.out.println("=============================================================");
				System.out.print("Enter your choice : ");
				int choice = UserIO.readInt();
				
				switch ( choice ) {
				
				case 1:
					enqueue();
					break;
					
				case 2:
					dequeue();
					break;
					
				case 3:
					peek();
					break;
					
				case 4:
					display();
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
 * isFull() - O(1)
 * enqueue() - O(1)
 * dequeue() - O(1)
 * peek() - O(1)
 * display() - O(n)
 * 
 * Space Complexity : O(1)
 */








