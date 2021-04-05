package stackApplications;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Stack;

// Algorithm to convert an Infix expression into Postfix expression
public class InfixToPostfix {

	// finding the precedence of an operator
	// precedence(), it will return the precedence of a given operator
	public static int precedence(char ch) {
		
		switch( ch ) {
		
		case '+' : case '-' : // low
			return 1; 
			
		case '*' : case '/' : // high
			return 2;
			
		case '^' : // higher
			return 3; 
		}
		return -1;
	}
	
	// Infix to Postfix Conversion
	public static String infixToPostfix(String expression) {
		
		// Initializing the empty String for results
		String result = new String(" ");
		
		// Initializing the empty stack that holds the characters
		Stack<Character> stack = new Stack<Character>();
		
		// Scan the infix expression from left to right
		for (int i = 0; i < expression.length(); i++) {
			
			// CharAt(index), it will return the character at the particular index from the expression
			char c = expression.charAt(i);
			
			// If the scanned character is an operand, then add it to the output
			if (Character.isLetterOrDigit(c)) { // Checks if the character is letter or digit
				result += c; // Adding the character into the output of the result
			}
			
			// If the incoming symbol is "(", Then push it into the stack
			else if (c == '(') {
				stack.push(c);
			}
			
			// If the incoming symbol is ")", Then pop and print the stack operators
			else if (c == ')') {
				
				// pop the stack until the stack becomes empty and when top of the stack will be '(', until '(' will found
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop();
				}
				stack.pop(); // Popping the '('
			}
			
			// If the operator is encountered
			else {
				
				// Checking for the lower and equal precedence of an operator
				while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
					result += stack.pop();
				}
				
				// else if the precedence of the incoming symbol is higher than the precedence of the top of the stack
				// Then directly push the operator into the stack
				stack.push(c);
			}
		}
		
		// When you reach at the end of the expression, pop and print all the operators from the stack
		while (!stack.isEmpty()) {
			
			// If there is any '(' operator then, it means that the infix expression is wrong - Invalid
			if (stack.peek() == '(') {
				return "Invalid Expression";
			}
			
			// else, pop all the operators and print into the results
			result += stack.pop();
		}
		
		// At the end, return the output result
		return result; // Postfix Expression
	}
	
	// Main || Driver method
	public static void main(String[] args) {
		try {
			// Input -> Infix Expression
			//String expression = "K+L-M*N+(O^P)*W/U/V*T+Q^J^A";
			
			//String expression = "A-B+(M^N)*(O+P)-Q/R^S*T+Z";
			String expression = "a+b*(c^d-e)^(f+g*h)-i";
			System.out.println("Infix Expression : " + expression);
			
			// infix to postfix expression
			String result = infixToPostfix(expression);
			
			// Printing the result -> Postfix Expression
			System.out.println("Postfix Expression : " + result);
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
 * Time Complexity: O(n) 
 * Auxiliary Space: O(n)
 */


/*
 * 1. Time Complexity : O(n^2)
 * 
 * 		i. Worst Case : O(n^2)
 * 		ii. Average Case : Theta(n^2) or O(n^2)
 * 		iii. Best Case : O(n^2)
 * 
 * 2. Space Complexity : O(n) -> depends on how many operators/literals are there in the stack.
 *  
 * 		-> For storing the n literals of infix expression - O(n) and for stack to hold almost n literals - O(n)
 * 			Hence, Total Space Complexity = O(n + n) = O(2n) -> O(n)
 */




