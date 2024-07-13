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
    public String postfix(String expression) {

        //create stack
        Stack<Integer> stack = new Stack<>();
        //Split string into stack and separate operators
        split(expression, stack);
        //combine the stack and operators to evaluate the expression

        //evaluate the expression

        //return the result
        return expression;
    }

    public void split(String expression, Stack<Integer> stack) {
        if (expression.contains(" ")) {
            String[] splitExpression = expression.split(" ");

            for (String element : splitExpression) {
                if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    switch (element) {
                        case "+":
                            stack.push(num1 + num2);
                            break;
                        case "-":
                            stack.push(num1 - num2);
                            break;
                        case "*":
                            stack.push(num1 * num2);
                            break;
                        case "/":
                            stack.push(num1 / num2);
                            break;
                    }
                } else {
                    stack.push(Integer.parseInt(element));
                }
            }
            System.out.println("Result: " + stack.peek());
        }
    }
}