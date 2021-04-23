package queue;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

/*
 * @Author: Niraj Thagunna
 * Algorithm to implement the Queue using Stacks
 */

public class QueueUsingStacks {

	// Properties or member variables the queue
	public static int MAX;

	// Creating two stacks to implement the Queue
	static int[] stack1; // for enqueue()
	static int[] stack2; // for dequeue()

	// Pointer variables to the stacks
	static int top1 = -1, top2 = -1;

	// To count the elements to be enqueued into the queue 
	public static int count = 0;

	// enqueue() - O(1)
	// stack1 - push the elements into the stack1
	public static void pushStack1(int data) {

		if (top1 == (MAX - 1)) {
			System.out.print("Stack1 Overflow");
			return;
		}
		else {
			// Incrementing the top pointer
			top1++;
			stack1[top1] = data; // Pushing the data into the top of the stack1
		}
	}

	public static void enqueue() {

		if (top1 == (MAX - 1)) {
			System.out.println("Queue Overflow");
			return;
		}
		else {
			System.out.print("Enter the data element to be enqueued : ");
			int data = UserIO.readInt();

			// Calling the pushStack1()
			pushStack1(data);

			// Counting the how many elements to be inserted
			count++;
			
			// data print
			System.out.println(data + " is enqueued successfully!");
		}
	}

	// popStack1()
	public static int popStack1() {

		// Initializing the data variable with default value
		int data = 0;

		if (top1 == -1) {
			System.out.println("Queue Underflow");
		}
		else {
			data = stack1[top1]; // store the top element into the data variable

			// decrement the top1 pointer
			top1--;
		}

		// return the top element
		return data;
	}

	// pushStack2()
	public static void pushStack2(int data) {

		if (top2 == (MAX - 1)) {
			System.out.println("Stack2 is Overflow");
			return;
		}
		else {
			// Increment the top2 pointer
			top2++;

			// push the data element into the stack2
			stack2[top2] = data;
		}
	}

	// popStack2()
	public static int popStack2() {

		if (top2 == -1) {
			System.out.println("Queue Underflow");
		}

		// else return the top element of the stack2
		return stack2[top2--];
	}

	// dequeue() - O(n)
	// stack2
	public static void dequeue() {

		// Checks if there is any element in the stack1 then push these elements into the stack2
		if (top1 == -1 && top2 == -1) {
			System.out.println("Queue Underflow");
			return;
		}
		else {
			int i, temp;

			// pop() from stack1 and push() into the stack2
			for (i = 0; i < count; i++) {
				temp = popStack1(); // pop() the elements from the stack1
				pushStack2(temp); // push() the elements into the stack2
			}

			// dequeue()
			System.out.println("Dequeued element is : " + popStack2());
			count--; // Removing the one element from the stack2

			// pop() and push() all the remaining elements from the stack2 to stack1
			for (i = 0; i < count; i++) {
				temp = popStack2();
				pushStack1(temp);
			}
		}
	}

	// peek() - O(n)
	public static void peek() {

		if (top1 == -1 && top2 == -1) {
			System.out.println("Queue is Empty!");
			return;
		}
		else {
			int i, temp;

			// pop() from stack1 and push() into the stack2
			for (i = 0; i < count; i++) {
				temp = popStack1(); // pop() the elements from the stack1
				pushStack2(temp); // push() the elements into the stack2
			}

			// dequeue()
			System.out.println("Peeked element is : " + stack2[top2]); // return without removing the top element of the queue

			// pop() and push() all the remaining elements from the stack2 to stack1
			for (i = 0; i < count; i++) {
				temp = popStack2();
				pushStack1(temp);
			}
		}
	}
	
	// display() - stack1 - O(n)
	public static void display() {
		
		if (top1 == -1) {
			System.out.println("Queue is Empty!");
			return;
		}
		else {
			System.out.println("The elements of the Queue are : ");
			
			for (int i = 0; i <= top1; i++) {
				System.out.print(stack1[i] + " ");
			}
			
			// Line separator
			System.out.println();
		}
	}

	// Main or driver method
	public static void main(String[] args) {
		try {
			System.out.print("Enter the size of queue : ");
			MAX = UserIO.readInt();

			// Instantiation the stacks
			stack1 = new int[MAX];
			stack2 = new int[MAX];

			do {
				System.out.println("***************** Queue - Stack Implementation *********************");
				System.out.println("1. Enqueue()\n2. Dequeue()\n3. Peek()\n4. Display()\n5. Exit");
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
