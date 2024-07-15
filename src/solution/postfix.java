/*
 * postfix.java
 * This is the postfix class of the program.
 * It contains the postfix method that evaluates the postfix expression.
 *
 * Austin Stephens
 * Rasmussen University
 * 07/13/2024
 * Professor Kumar
 *
 *
 */

package solution;
import java.util.Stack;

public class postfix {

    //call the evaluate method in th epostfix method
    public String postfix(String expression) {
        //eval
        evaluate(expression);

        //return the expression
        return expression;
    }

    private void evaluate(String expression) {
        //This is where we will evaluate the postfix expression
        //Create a stack to hold the operands
        Stack<Integer> stack = new Stack<Integer>();

        //we need to go through each of our 'tokens' in the expression in order to see what is what
        //we will do this by looking at the length of the expression and looping through
        for (int i = 0; i < expression.length(); i++) {
            //get the current character
            char c = expression.charAt(i);

            //We need to look at the character and determine if it is a digit or an operator
            //if the character is a digit, we need to push it onto the stack
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                //if the character is an operator, we need to pop the last two operands off the stack
                int x = stack.pop();
                int y = stack.pop();

                //perform the operation
                switch (c) {
                    case '+':
                        stack.push(y + x);
                        break;
                    case '-':
                        stack.push(y - x);
                        break;
                    case '*':
                        stack.push(y * x);
                        break;
                    case '/':
                        stack.push(y / x);
                        break;
                }
            }
        }
    }
}