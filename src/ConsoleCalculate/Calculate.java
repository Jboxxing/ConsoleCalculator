// For testing purposes:

// - Tested for invalid or missing operator inputs
//   --> Input of "1111", Output of "Error, missing a valid operator or operands."
//   --> Input of "1+", Output of "Error, missing a valid operator or operands."
//   --> Input of "+1", Output of "Error, missing a valid operator or operands."

// - Tested for invalid or missing operand inputs
//   --> Input of "w+1", Output of "Left operand is not a valid integer."
//   --> Input of "1+w", Output of "Right operand is not a valid integer."
//   --> Input of "w+w", Output of "Left operand is not a valid integer.\n" + "Right operand is not a valid integer."

package ConsoleCalculate;

import java.util.Scanner;
import java.util.ArrayList;

public class Calculate
{	
	public Calculate()
	{
		
	}
	
	// The String input from the Scanner will be sorted in this method, before being further processed in
	// performCalculations.
	public void sortInput(String userInput)
	{
		// Store the String input from the Scanner into a new char array.
		// Separate each character by left operands, operator, and right operands.
		char[] equation = new char[userInput.length()];
		userInput.getChars(0, userInput.length(), equation, 0);
		ArrayList<Character> left = new ArrayList<Character>();
		ArrayList<Character> right = new ArrayList<Character>();
		boolean isLeft = true;
		char operator = ' ';
		
		for (int i = 0; i < equation.length; i++)
		{
			if (equation[i] == '+' || equation[i] == '-' || equation[i] == '*' || equation[i] == '/')
			{
				operator = equation[i];
				isLeft = false;
			}
			else if (isLeft && (equation[i] != '+' || equation[i] != '-' || equation[i] != '*' || equation[i] != '/'))
				left.add(equation[i]);
			else if (!isLeft && (equation[i] != '+' || equation[i] != '-' || equation[i] != '*' || equation[i] != '/'))
				right.add(equation[i]);
		}
		
		// If the left operands, the operator, and the right operands are identified, perform the correct
		// calculations. Otherwise, notify user that something is missing (operator or operand) or invalid (operator).
		// Invalid operands will be checked later (in performCalculations).
		if (operator != ' ' && !left.isEmpty() && !right.isEmpty())
			performCalculations(userInput.concat(" = "), left, right, operator);
		else
			System.out.println("Error, missing a valid operator or operands.");
	}
	
	public void performCalculations(String input, ArrayList<Character> left, ArrayList<Character> right, char operator)
	{
		// Add each character in the left ArrayList (containing the left operands) to a StringBuilder, which is later
		// converted to a String, and then an integer.
		StringBuilder leftOperands = new StringBuilder(left.size());
		for (Character ch : left)
		{
			leftOperands.append(ch);
		}
		
		// Add each character in the right ArrayList (containing the right operands) to a StringBuilder, which is
		// later converted to a String, and then an integer.
		StringBuilder rightOperands = new StringBuilder(right.size());
		for (Character ch : right)
		{
			rightOperands.append(ch);
		}
		
		int leftO = 0;
		int rightO = 0;
		// Ensures that the left and right operands are valid integers before proceeding to make calculations.
		// **** Possibly better to check for integer validity of the operands before entering this method. ****
		try
		{
			leftO = Integer.parseInt(leftOperands.toString());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Left operand is not a valid integer.");
		}
		try
		{
			rightO = Integer.parseInt(rightOperands.toString());
		}
		catch (NumberFormatException e)
		{
			System.out.println("Right operand is not a valid integer.");
		}
		
		// The left and right operands are used in the calculation determined by the value of the operator.
		if (leftO != 0 && rightO != 0)
		{
			switch (operator)
			{
			case '+':
				System.out.println(input + (leftO + rightO));
				break;
			case '-':
				System.out.println(input + (leftO - rightO));
				break;
			case '*':
				System.out.println(input + (leftO * rightO));
				break;
			case '/':
				System.out.println(input + (leftO / rightO));
				break;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner keyboardInput = new Scanner(System.in);
		Calculate c = new Calculate();
		boolean opened = true;
		boolean validInput = true;
		
		// Welcome the user to the calculator program, state operations it can perform and how to add an input,
		// while adhering to certain rules.
		System.out.println("**Welcome to the console calculator!**");
		System.out.println("This calculator can perform addition, subtraction, multiplication, and division.");
		System.out.println("Operands must be integers.");
		while (opened)
		{
			// After the first run of this calculator, the user must explicitly decide to continue using (input YES)
			// or exit (input NO) the program.
			// If the input is YES, the input is valid and the user is prompted to enter an equation.
			// If the input is NO, the input is valid (unnecessary to state it), a closing message is printed to the
			// console, and the Scanner and program are closed.
			// If the input is neither YES or NO, it is invalid. The user is notified of this and is prompted to enter
			// a valid input.
			if (validInput)
			{
				System.out.println("Type in an equation (syntax example: 1+1) and press ENTER when done.");
				String userInput = keyboardInput.nextLine();
				c.sortInput(userInput);
			}
			System.out.println("Would you like to proceed with another calculation? (Enter YES or NO)");
			String proceed = keyboardInput.nextLine();
			if (proceed.contentEquals("NO"))
			{
				opened = false;
				keyboardInput.close();
				System.out.println("Thank you for using ConcoleCalculate.");
				System.exit(0);
			}
			else if (!proceed.contentEquals("YES"))
			{
				validInput = false;
				System.out.println("Invalid input, must be YES or NO.");
			}
			else
				validInput = true;
		}
	} // main

} // class
