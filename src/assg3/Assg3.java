package assg3;

import java.util.Scanner;

/* CSCI 3343 Analysis of Algorithms Spring 2017
 * Assignment 3
 * German M. Candelaria
 * 02/11/2017
 */
public class Assg3 {

    public static void main(String[] args) {
        //Variable initialization
        boolean boolExit, boolValidOperation;
        Scanner myScan = new Scanner(System.in);
        Stack myStack = new Stack();
        String strEntry;
        String[] tmpStrArry;
        Double dblFirstOperand, dblSecondOperand;
        do{ //Main loop
            boolValidOperation = true;
            boolExit = false;
            //Prompting user for postfix expression
            System.out.println("Enter the postfix expression to be evaluated: (Enter 'q' to quit)");
            strEntry = myScan.nextLine();   //Retrieving entered expression
            if (strEntry.contains("q")) {   //Verifying is user wishes to exit the program
                boolExit = true;
            } else {    //If user did not enter exit command
                tmpStrArry = strEntry.split("\\s+");    //Split entered expression into a temporary array using the space delimiter
                outerloop:
                for (String s: tmpStrArry) {    //Iterating through the strings in the temporary array
                    if (s.matches("[0-9]+([\\.]?[0-9]+)?")){    //If the string is a number
                        myStack.push(Double.parseDouble(s));    //Push the number to the stack
                    } else {    //If the string is not a number
                        dblSecondOperand = myStack.pop();   //Pop operand 2
                        dblFirstOperand = myStack.pop();    //Pop operand 1
                        if (dblFirstOperand == null){   //Verifying if we have enough operands
                            //Showing error and exiting loop
                            System.err.println("Invalid Operation and/or Operand!");
                            boolValidOperation = false;
                            myStack.clearStack();
                            break;
                        } else {    //If we do have enough operands
                            switch (s) {    //Switch between possible operation types
                                case "+":   //Additon
                                    myStack.push(dblFirstOperand + dblSecondOperand);
                                    break;
                                case "-":   //Substraction
                                    myStack.push(dblFirstOperand - dblSecondOperand);
                                    break;
                                case "*":   //Multiplication
                                    myStack.push(dblFirstOperand * dblSecondOperand);
                                    break;
                                case "/":   //Division
                                    if(dblSecondOperand != 0){  //Check that we are not dividing by zero
                                        myStack.push(dblFirstOperand / dblSecondOperand);
                                    } else {    //If we are dividing by zero provide error and exit outerloop
                                        System.err.println("Cannot divide by ZERO!");
                                        boolValidOperation = false;
                                        break outerloop;
                                    }
                                    break;
                                default:    //Other characters were entered. Provide error
                                    boolValidOperation = false;
                                    System.err.println("Invalid Operation and/or Operand!");
                                    break outerloop;
                            }
                        }
                    }
                }
                if (boolValidOperation){    //If a valid operation was performed
                    //Provide user with result
                    System.out.println("Result is: " + myStack.pop());
                    myStack.clearStack();
                } else {    //Invalid operation detected
                    myStack.clearStack();
                }
            }
        } while(!boolExit);
        //Exit message
        System.out.println("Good bye!");
    }
}
