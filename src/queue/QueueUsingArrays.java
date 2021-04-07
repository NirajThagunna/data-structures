package queue;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

/*
 * @Author : Niraj Thagunna
 * Implementation of Queue using an array
 */
public class QueueUsingArrays {

	// Size of an array
	public static int MAX;

	// Creating an array
	static int[] queue; // Fixed size of the queue

	// points of queue
	private static int front = -1, rear = -1; // front -> Access, Deletion - dequeue() && rear -> Insertion - enqueue()

	// Checks if the queue is empty -> Underflow
	public static boolean isEmpty() { // Underflow

		if (front == -1 && rear == -1)
			return true;
		else 
			return false;
	}

	// Checks if the queue is Full -> Overflow
	public static boolean isFull() { // Overflow

		if (rear == (MAX - 1)) 
			return true;
		else 
			return false;
	}

	// Inserting an element into the queue -> Enqueue()
	public static void enqueue() { // Insertion -> rear 

		// Checks if the queue is full
		if (isFull()) {
			System.out.println("Queue Overflow");
			return;
		}
		else if (front == -1 && rear == -1) {

			System.out.print("Enter the number to be insert/enqueue : ");
			int data = UserIO.readInt();

			front = rear = 0;
			queue[rear] = data;

			System.out.println(data + " is enqued successfully!");
		}
		else {

			System.out.print("Enter the number to be insert/enqueue : ");
			int data = UserIO.readInt();
			
			// Increment the rear pointer
			rear++;
			// Insert the data
			queue[rear] = data;
			
			System.out.println(data + " is enqued successfully!");
		}
	}
	
	// Deletion -> dequeue() -> front end
	public static void dequeue() {
		
		// Checks if the queue is empty
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			return;
		}
		else if (front == rear) { // Only one element is present
			System.out.println("Dequed element is : " + queue[front]);
			
			// Decrement both the pointers
			front = rear = -1;
		}
		else {
			System.out.println("Dequed element is : " + queue[front]);
			
			// Increment the front pointer
			front++;
		}
	}
	
	// Printing the front element of the queue -> peek() -> front element without removing the element
	public static void peek() {
		
		// Checks if the queue is empty
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		else {
			System.out.println("Peeked element is : " + queue[front]);
		}
	}
	
	// Display -> Printing all the elements of the queue -> from the front end
	public static void display() { // front end
		
		// Checks if the queue is empty
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		else if (front == rear) {
			System.out.println("Element of the queue is : " + queue[front]);
		}
		else {
			System.out.println("Elements of the queue are : ");
			
			for (int i = front; i <= rear; i++) {
				System.out.print(queue[i] + " ");
			}
			System.out.println();
		}
	}
	
	// Main driver method
	public static void main(String[] args) {
		try {
			System.out.print("Enter the size of queue : ");
			MAX = UserIO.readInt();
			
			// Instantiation of the queue
			queue = new int[MAX];
			
			do {
				System.out.println("***************Implementation of Queue using Arrays******************");
				System.out.println("1. Enqueue()\n2. Dequeue()\n3. Peek()\n4. Display\n5. Exit");
				System.out.println("=====================================================================");
				
				System.out.print("Enter your choice : ");
				int choice = UserIO.readInt();
				
				switch( choice ) {
				
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
 */







