package stackApplications;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Stack;

/*
 * Niraj Thagunna
 * Algorithm for evaluation of Postfix Expression using Stack
 * <operand><operand><operator>
 * The program can be extended for multiple digits by adding a separator like space between all elements 
 * (operators and operands) of given expression.
 */

public class PostfixEvaluation {

	// method to evaluate the value of a postfix expression
	public static int evaluatePostfix(String postfixExp) {

		// Creating an empty stack
		Stack<Integer> stack = new Stack<Integer>();

		// Scanning all the characters one by one from left to right
		for (int i = 0; i < postfixExp.length(); i++) {

			// featching all the characters
			char c = postfixExp.charAt(i);

			if (c == ' ') 
				continue;

			// If the scanned character is an operand 
			// (number here), extract the number
			// Push it to the stack.
			else if (Character.isDigit(c)) {

				int num = 0;

				// Extract the characters and store it in num
				while (Character.isDigit(c)) {
					num = num * 10 + (int)(c - 48); // (int)(c - 48) - converting the character into digit
					i++;
					c = postfixExp.charAt(i);
				}
				i--;

				// Push the multiple digits number into the stack
				stack.push(num);
			}

			// If the scanned character is an operator, pop two elements from the stack apply the operator
			else {
				int op1 = stack.pop(); // pop and print top of the stack
				int op2 = stack.pop(); // pop and print second element of the stack

				switch(c) {

				case '+':
					stack.push(op2 + op1);
					break;

				case '-':
					stack.push(op2 - op1);
					break;

				case '*':
					stack.push(op2 * op1);
					break;

				case '/':
					stack.push(op2 / op1);
					break;

				case '^':
					stack.push((int)(Math.pow(op2, op1)));
					break;

				default:
					System.out.println(c + " is not available!");
				}
			}
		}

		// result -> stored at the top of the stack
		return stack.pop();
	}


	// Driver program to test above functions
	public static void main(String[] args) {
		try {
			String postfixExp = "100 200 + 2 / 5 * 7 +";
			System.out.println("Postfix Expression : " + postfixExp);
			
			System.out.println("Evaluating the value ...\nResult : " + evaluatePostfix(postfixExp));
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

// Time complexity of evaluation of an algorithm is O(n) where n is number of characters in input expression.




