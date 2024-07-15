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

    //this method will evaluate the postfix expression
    public String postfix(String expression) {
        //first we will evaluate the expression
        int result = evaluate(expression);
        //then return the result as a string
        return Integer.toString(result);
    }

    private int evaluate(String expression) {
        //this method will evaluate the postfix expression
        //Create a new stack object
        Stack<Integer> stack = new Stack<>();

        //we will move through the expression by splitting it into tickets or tockenizing it
        String[] tokens = expression.split(" ");

        //loop through the tokens, using a for loop and looking at each token in the expression
        //tickets are the individual parts of the expression
        for (String ticket : tokens) {
            //here we will look at the first character of the token
            //if it is a digit, we will push it onto the stack
            if (Character.isDigit(ticket.charAt(0))) {
                stack.push(Integer.parseInt(ticket));
            } else {
                //now, if the token is an operator, we will pop the last two numbers from the stack
                //because we are evaluating a postfix expression, the last two numbers are the ones we need to evaluate
                int x = stack.pop();
                int y = stack.pop();

                //switch case to evaluate the expression
                //live lecture reccomended using a switch case to evaluate the expression
                switch (ticket) {
                    case "+":
                        stack.push(y + x);
                        break;
                    case "-":
                        stack.push(y - x);
                        break;
                    case "*":
                        stack.push(y * x);
                        break;
                    case "/":
                        stack.push(y / x);
                        break;
                }
            }
        }
        //return the result
        //we return the last number in the stack because that is the result of the expression

        return stack.pop();
    }
}