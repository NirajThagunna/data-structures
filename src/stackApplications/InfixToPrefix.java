package stackApplications;

import java.io.PrintWriter;
import java.io.StringWriter;

import basicIO.UserIO;

/*
 * @Author : Niraj Thagunna
 * Algorithm to convert an Infix expression into the Prefix expression
 * Infix ------> Prefix
 */
public class InfixToPrefix {

	// Reverse the expression or String 
	public static String reverse(char str[], int start, int end) {

		// temp variable to store each character
		char temp;

		// Swapping the each character of first index with last index
		while (start < end) {
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}

		return String.valueOf(str); // Convert a sequence of the characters into a String -> Character array into String
	}

	// Infix to Prefix Expression
	public static String infixToPrefix(char[] infix) {

		// length of an infix expression
		int l = infix.length;

		// Reverse the infix expression
		String reverseExp = reverse(infix, 0, l - 1);

		// Convert a String into the sequence of the characters
		// String into array of characters
		infix = reverseExp.toCharArray();

		// Replacing the '(' by ')' and ')' by '('
		for (int i = 0; i < l; i++) {

			if (infix[i] == '(') {
				infix[i] = ')';
				i++;
			}
			else if(infix[i] == ')') {
				infix[i] = '(';
				i++;
			}
		}

		// Apply the infix to postfix expression algorithm
		// static methods can be accessed through the name of class only if both the classes are in the same package
		String postfix = InfixToPostfix.infixToPostfix(String.valueOf(infix)); // It will return a postfix expression
		// String.valueOf(infix) -> Character array into String -> Conversion

		// Reversing the postfix expression 
		// postfix ----> reverse -----> prefix
		String prefixExp = reverse(postfix.toCharArray(), 0, postfix.length() - 1);

		// return the prefix expression
		return prefixExp;
	}

	// main method
	public static void main(String[] args) {
		try {
			System.out.print("Enter the Infix Expression : ");
			String infixExp = UserIO.readInput();
			
			// Printing the Infix Expression
			System.out.println("Infix Expression : " + infixExp);
			
			// Infix to Prefix Conversion
			String prefixExp = infixToPrefix(infixExp.toCharArray());
			System.out.println("Prefix Expression : " + prefixExp);
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






