package stack;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Implementation of the Stack using Arrays
// isEmpty() - O(1)
// isFull()  - O(1)
// push()    - O(1)
// pop()     - O(1)
// peek()    - O(1)
// display() - O(n)

public class StackImplementationUsingArrays {
	
	// Instance or member variables
	static int MAX;
	int top = -1; // top = -1 means the stack is empty
	
	// Initializing an array of the stack
	static int stack[]; // Only a reference of an array is created, memory is not allocated yet
	
	// isEmpty() -> true||false - It will return true if the stack is empty, else returns false
	public boolean isEmpty() {
		
		if (top == -1)
			return true;
		else
			return false;
	}
	
	// isFull() -> returns true if the stack is full, else returns false
	public boolean isFull() {
		
		if (top == (MAX - 1))
			return true;
		else
			return false;
	}
	
	// push() -> storing/inserting an element in the stack
	public void push() {
		
		// Checks if the stack is full.
		// If the stack is full, produces an error and exit.
		if (isFull()) {
			System.out.println("Stack Overflow");
			return;
		}
		else {
			System.out.print("Enter any element to be pushed : ");
			int data = UserIO.readInt();
			
			// If the stack is not full, increments top to point next empty space.
			top++;
			
			// Adds data element to the stack location, where top is pointing.
			stack[top] = data;
			
			// pushed success message
			System.out.println(data + " is pushed successfully!");
		}
	}
	
	// pop() -> returns the top most element of the stack by removing that element from the stack
	public void pop() {
		
		// Checks if the stack is empty.
		// If the stack is empty, produces an error and exit.
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return;
		}
		else {
			// If the stack is not empty, accesses the data element at which top is pointing.
			int data = stack[top];
			
			// Decreases the value of top by 1.
			top--;
			
			// print the value
			System.out.println("Popped element : " + data);
		}
	}
	
	// peek() -> get the top data element of the stack, without removing it.
	public void peek() {
		
		// Checks if the stack is empty.
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return;
		}
		else {
			System.out.println("Top element of the stack is : " + stack[top]); // get the top element of the stack
		}
	}
	
	// Traverse the stack in a reverse order
	public void traverseReverseOrder() {
		
		// Checks if the stack is empty.
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return;
		}
		else {
			System.out.println("Elements of the stack in a reverse order : ");
			for (int i = top; i >= 0; i--) {
				System.out.print(stack[i] + " ");
			}
			// Separate the lines
			System.out.println();
		}
	}
	
	// Traverse the stack in the order in which element are inserted.
	public void traverseInOrder() {
		
		// Checks if the stack is empty.
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return;
		}
		else {
			System.out.println("Elements of the stack are : ");
			for (int i = 0; i <= top; i++) {
				System.out.print(stack[i] + " ");
			}
			// Separate the lines
			System.out.println();
		}
	}
	
	// main method
	public static void main(String[] args) {
		
		System.out.println("**************Stack Implementation Using Arrays***************");
		// Creating an object of the class
		StackImplementationUsingArrays stackArray = new StackImplementationUsingArrays();
		try {
			System.out.print("Enter the size of the stack : ");
			MAX = UserIO.readInt();
			
			// Initializing and allocating a memory to the stack
			stack = new int[MAX];
			
			int choice;
			do {
				System.out.println("\n========================MENU==========================");
				System.out.println("1. push()\n2. pop()\n3. peek()\n4. traverseReverseOrder()\n5. traverseInOrder()");
				System.out.println("=======================================================");
				
				System.out.print("Enter your choice(0 - Exit) : ");
				choice = UserIO.readInt();
				
				switch (choice) {
				
				case 1 :
					stackArray.push();
					break;
					
				case 2 :
					stackArray.pop();
					break;
					
				case 3 :
					stackArray.peek();
					break;
					
				case 4 :
					stackArray.traverseReverseOrder();
					break;
					
				case 5 :
					stackArray.traverseInOrder();
					break;
					
				default :
					System.out.println("Please enter the valid choice!\nExiting ... ");
					
				}
			} while (choice != 0);
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


// All the stack operations will take O(1) time complexity.
// push(), pop() and peek() -> Time Complexity : O(1)




