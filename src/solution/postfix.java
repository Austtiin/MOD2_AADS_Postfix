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
        Stack<Integer> stack = new Stack<Integer>();
        //Split string into stack and separate operators
            split(expression, stack);
        //combine the stack and operators to evaluate the expression

        //evaluate the expression

        //return the result
        return expression;
    }

   public void split(String expression, Stack<Integer> stack) {
    //Check if the expression contains spaces
    if (expression.contains(" ")) {
        //proceedd to split the expression
        String[] splitExpression = expression.split(" ");


        //for each element in the expression we will check if it is an operator or a number
        for (String element : splitExpression) {
            // If the element is an operator
            if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                //We need to pop the last two elements from the stack to apply the operator
                int num2 = stack.pop();
                int num1 = stack.pop();
                //Proceed to apply the operator to the two numbers and push the result back to the stack
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
                //Now we can push the element to the stack
                stack.push(Integer.parseInt(element));
            }
        }
        //Print the result of the expression to the console
        System.out.println("Result: " + stack.peek());
    }
}