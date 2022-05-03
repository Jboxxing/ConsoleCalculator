# ConsoleCalculator

- This is a simple calculator program, which takes inputs from the console.  
- The calculator supports addition, subtraction, multiplication, and division operations.  
- When running the program, type an equation into the console when prompted. The equation must follow the syntax (1+1), containing 2 operands and an operator, with no spaces in between any characters.  
- Operands must be integers.  
- Upon inputting a valid equation following the above described syntax, the result of the calculation is outputted as an integer to the console in the form of (1+1 = 2).  
- The user can now choose to enter another equation or exit the program.

**Tested for invalid or missing operator inputs**
- Input of "1111", Output of "Error, missing a valid operator or operands."
- Input of "1+", Output of "Error, missing a valid operator or operands."
- Input of "+1", Output of "Error, missing a valid operator or operands."

**Tested for invalid or missing operand inputs**
- Input of "w+1", Output of "Left operand is not a valid integer."
- Input of "1+w", Output of "Right operand is not a valid integer."
- Input of "w+w", Output of "Left operand is not a valid integer.\n" + "Right operand is not a valid integer."
