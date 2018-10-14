package containers.collection.legacy;

import static utils.Print.print;
import static utils.Print.printnb;

import java.util.LinkedList;
import java.util.Stack;

import containers._113_Stack;

enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER
}

public class _02_Stacks {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (Month m : Month.values()) {
            stack.push(m.toString());
        }
        print("stack = " + stack);
        // Treating a stack as a Vector:
        stack.addElement("The last line");
        print("element 5 = " + stack.elementAt(5));
        print("popping elements:");
        while (!stack.empty()) {
            printnb(stack.pop() + " ");
        }
        // Using a LinkedList as a Stack:
        LinkedList<String> lstack = new LinkedList<String>();
        for (Month m : Month.values()) {
            lstack.addFirst(m.toString());
        }
        print("lstack = " + lstack);
        while (!lstack.isEmpty()) {
            printnb(lstack.removeFirst() + " ");
        }
        // Using the Stack class from the Holding Your Objects Chapter:
        _113_Stack<String> stack2 = new _113_Stack<String>();
        for (Month m : Month.values()) {
            stack2.push(m.toString());
        }
        print("stack2 = " + stack2);
        while (!stack2.empty()) {
            printnb(stack2.pop() + " ");
        }
    }
}