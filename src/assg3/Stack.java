package assg3;

import java.util.LinkedList;

/* CSCI 3343 Analysis of Algorithms Spring 2017
 * Assignment 3
 * German M. Candelaria
 * 02/11/2017
 */
public class Stack {
    private LinkedList llStack = new LinkedList();
    
    public Stack(){
        llStack.clear();
    }
    
    public void push(Double dblItem){
        llStack.add(dblItem);
    }
    
    public Double pop(){
        if (llStack.isEmpty()) {
            //System.err.println("Stack is empty!");
            return null;
        } else {
            Double dblPoppedItem;
            dblPoppedItem = (Double) llStack.getLast();
            llStack.removeLast();
            return dblPoppedItem;
        }
    }
    
    public void clearStack(){
        llStack.clear();
    }
}
