/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 1:59:06 AM
 */

package inheritance_Interface.ocp;

import java.io.EOFException;
import java.io.IOException;

/*
    If the overriden method of the subclass throws an exception 
    this exception must be a same or a subclass of the exception thrown by the method of the superclass
 */

public class Robot extends Machine {
    //  public boolean turnOn() throws IOException {
    public boolean turnOn() throws EOFException {
        return false;
    }

    public static void main(String[] args) throws Exception {
        Machine m = new Robot();
        System.out.println(m.turnOn()); // execute the version of subclass implementation
    }
}

class Machine {
    //    public boolean turnOn() throws EOFException {
    public boolean turnOn() throws IOException {
        return true;
    }
}