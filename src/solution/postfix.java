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
        //return the expression as it is now evaluated / solved
        return expression;
    }

    private String evaluate(String expression) {
        //This is where we will evaluate the postfix expression
        //Create a stack to hold the operands
        Stack<Integer> stack = new Stack<>();

        //we need to go through each of our 'tokens' in the expression in order to see what is what
        //we will do this by looking at the length of the expression and looping through
        //we also need to watch for spaces, so we will use the length of the expression or get rid of spaces

        //look for spaces and remove them
        expression = expression.replaceAll("\\s", "");

        for (int i = 0; i < expression.length(); i++) {
            //get the current character, by looking at what is at that current location.
            char e = expression.charAt(i);

            //We need to look at the character and determine if it is a digit or an operator
            //if the character is a digit, we need to push it onto the stack
            if (Character.isDigit(e)) {
                stack.push(e - '0');
            } else {
                //Now, if the char we are looking at is an operator,
                // we need to 'pop' the last two digits off the stack because
                // we need to perform an operation on them
                int x = stack.pop();
                int y = stack.pop();

                //perform the operation, we will just use a switch statement to
                // determine what operation to perform.
                //This is where we will perform the operation aswell
                switch (e) {
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
        //return the stack as a string
        //We only need to return the stack as a string because the stack will only have one element
        //This element will be the solved expression
        return stack.toString();
    }
}