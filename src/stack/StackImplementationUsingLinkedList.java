package stack;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

// Stack Implementation - Linked List - Operations
// push()  -  O(1)
// pop()   -  O(1)
// peek()  -  O(1)
// display()	-	O(n)

public class StackImplementationUsingLinkedList {
	
	// Structure of a node
	class Node {
		int data;
		Node next;
		
		// Constructor to create a new node
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// Top pointer from where the push(), pop() and will perform
	private Node top = null;
	
	// isEmpty() - O(1)
	public boolean isEmpty() {
		
		// Checks if the list is empty.
		if (top == null)
			return true;
		else
			return false;
	}
	
	// push() - O(1)
	public void push() {
		
		System.out.print("Enter the element to be pushed : ");
		int data = UserIO.readInt();
		
		// Creating a newNode
		Node newNode = new Node(data);
		
		// Checks if the list is empty.
		if (isEmpty()) {
			top = newNode;
		}
		else {
			newNode.next = top;
			top = newNode;
		}
		
		// Printing the pushed element.
		System.out.println(data + " is pushed successfully.");
	}
	
	// pop() - O(1)
	public void pop() {
		
		// Checks if the list is empty.
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return;
		}
		else {
			// deleting the node
			Node temp = top;
			top = temp.next;
			temp.next = null; // free the link
			
			// Printing the popped element.
			System.out.println("Popped element : " + temp.data);
		}
	}
	
	// peek() - O(1)
	public void peek() {
		
		// Checks if the stack is empty.
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return;
		}
		else {
			System.out.println("Top element is : " + top.data + "(peeked element)");
		}
	}
	
	// display() - O(n)
	public void display() {
		
		// Checks if the stack is empty.
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return;
		}
		else {
			// Traverse through the whole list
			Node temp = top;
			
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			
			// Separate the lines
			System.out.println();
		}
	}
	
	// main method
	public static void main(String[] args) {
		
		System.out.println("**************Stack Implementation Using Linked List***************");
		// Creating an object of the class
		StackImplementationUsingLinkedList stackLinkedList = new StackImplementationUsingLinkedList();
		try {
			int choice;
			do {
				System.out.println("\n========================MENU==========================");
				System.out.println("1. push()\n2. pop()\n3. peek()\n4. display()");
				System.out.println("=======================================================");
				
				System.out.print("Enter your choice(0 - Exit) : ");
				choice = UserIO.readInt();
				
				switch (choice) {
				
				case 1 :
					stackLinkedList.push();
					break;
					
				case 2 :
					stackLinkedList.pop();
					break;
					
				case 3 :
					stackLinkedList.peek();
					break;
					
				case 4 :
					stackLinkedList.display();
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




