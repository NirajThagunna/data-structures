package stackApplications;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Stack;

/*
 * @Author : Niraj Thagunna
 * Algorithm for the evaluation of prefix expression
 * <operator><operand><operand>
 */

public class PrefixEvaluation {
	
	// Checks if the character is a digit - operand
	public static boolean isOperand(char c) {
		
		// All the digits are from 48 to 57
		if (c >= 48 && c <= 57) 
			return true;
		else 
			return false;
	}
	
	// evaluatePrefix() -> Evaluation of prefix expression
	public static double prefixEvaluation(String expression) {
		
		// Initializing an empty Stack
		Stack<Double> stack = new Stack<Double>();
		
		// Scanning the Prefix Expression from right to left
		for (int i = expression.length() - 1; i >= 0; i--) {
			
			// If the operand is encountered then, push it onto the stack
			// Push operand to Stack
            // To convert expression[i] to digit subtract
            // '0' (equivalent to 48 i.e. ASCII) from expression[i]
			if (isOperand(expression.charAt(i))) {
				stack.push((double) (expression.charAt(i) - 48)); // expression.charAt(i=0) gives 48 so to make 48 into 0 -> subtract 48 - 48
			}
			else { // If the operator is encountered
				double op1 = stack.pop(); // pop and print top of the stack
				double op2 = stack.pop(); // pop and print second element of the stack
				
				// Checks for the operator
				switch( expression.charAt(i) ) {
				
				case '+':
					double result = op1 + op2;
					stack.push(result);
					break;
					
				case '-':
					stack.push(op1 - op2);
					break;
					
				case '*':
					stack.push(op1 * op2);
					break;
					
				case '/':
					stack.push(op1 / op2);
					break;
					
				case '^':
					stack.push((double) Math.pow(op1, op2));
					break;
					
				default:
					System.out.println(expression.charAt(i) + " is not available!");
				}
			}
		}
		
		// return the top of the stack - result
		return stack.peek(); // top of the stack
	}
	
	
	// Main || Driver method
	public static void main(String[] args) {
		try {
			String prefixExp = "-+7*45+20";
			System.out.println("Prefix Expression : " + prefixExp);
			
			System.out.println("Evaluating...\nResult : " + prefixEvaluation(prefixExp));
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
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Linear time - Linear Complexity
 * 
 * Complexity :
 * 		-> The algorithm has linear complexity since we scan the expression once and perform at most O(N) push and pop 
 * 		operations which take constant time.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */




