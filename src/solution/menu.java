/*
 * menu.java
 * This is the menu class of the program. It contains the run method that runs the program.
 *
 * Austin Stephens
 * Rasmussen University
 * 07/13/2024
 * Professor Kumar
 *
 *
 */

package solution;

import java.util.Scanner;

public class menu {
    public void run() {
        System.out.println("Module 02 Project - Postfix Implementation in Java");
        System.out.println("Input a postfix expression to evaluate");
        System.out.println("Example: 2 3 5 6 + * -");
        System.out.println("Enter 'exit' to quit the program.");

        // Create a new postfix object
        postfix p = new postfix();
        // Create a new scanner object
        Scanner scan = new Scanner(System.in);

        //learn expression from user
        String expression = scan.nextLine();
        //while the user does not enter "exit"
        while (!expression.equals("exit")) {
            //evaluate the expression with the postfix method
            System.out.println("Result: " + p.postfix(expression));
            //learn expression from user
            expression = System.console().readLine();
        }

    }
}
