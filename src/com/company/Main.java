package com.company;

import java.util.Scanner;
//import java.math.BigInteger;  // To be able to hand large user input.

public class Main {

    /*
        This function is a function that prompts the user to input a value to be reveresed.
     */
    public static int getUserInput() {
        Scanner scnr = new Scanner(System.in);
        /* BigInteger number = 0;    <- Maybe modify later to accept very large numbers?
                                        But would have to modify return type. */
        int userInput = 0;


        System.out.print("Please enter a number:");
        userInput = scnr.nextInt();

        return userInput;
    }

    /*
        This is the method to flip the ordering of the numbers.
     */
    public static int flipOrder(int originalNum) {
        /* Declaration of variables */
        int reversedNum = 0;     // The final reveresed number
        int interimDigit = 0;    // Temporary storage for a digit to be reversed.
        int signOfOrig = 1;      // Positive/Negative multiplier for the sign of the original number.  Default positive.

        if (originalNum < 0) {
            signOfOrig = -1;     // Change the sign placeholder to negative.
            originalNum *= -1;   // Change to positive for algorithm.
        }

        while (originalNum > 0) {
            interimDigit = originalNum % 10;
            reversedNum = reversedNum * 10 + interimDigit;
            originalNum /= 10;  // This allows for the original number to discard the smallest digit per iteration
        }

        reversedNum *= signOfOrig;

        return reversedNum;
    }

    /*
        This is the main program.
     */
    public static void main(String[] args) {
	/* Declaration of variables */
        int userVal = 0;                        // The value that the user enters
        int flippedVal = 0;                     // The values where the digit orders are flipped.
        char contProg = 'y';                    // "Boolean" to determine whether the program should go on.
        Scanner scnr = new Scanner(System.in);  //

        /* Beginning of program and description */
        System.out.println("This program will reverse the digit orders for the integer number you enter.\n" +
                "Any leading zeroes will be ignored.\n" +
                "Large-number input (absolute value over two billion) may produce an error.");


        while (contProg != 'n') {
            /* Prompt user to input and assign to userVal */
            userVal = getUserInput();

            /* Take userVal, and call method to flip the order */
            flippedVal = flipOrder(userVal);

            System.out.println("You entered: " + userVal);
            System.out.println("The digits flipped is: " + flippedVal);
            System.out.println("");
            System.out.print("Would you like to continue? (y/n): ");
            contProg = scnr.next().trim().charAt(0);

            System.out.println("");
            /* TODO: Make the program more robust to the user inputs of 'y' or 'n'*/
        }
    }
}
