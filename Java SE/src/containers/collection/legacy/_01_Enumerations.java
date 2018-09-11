package containers.collection.legacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import containers._144_Countries;

public class _01_Enumerations {
    public static void main(String[] args) {
        Vector<String> v = new Vector<String>(_144_Countries.names(10));
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements())
            System.out.print(e.nextElement() + ", ");
        // Produce an Enumeration from a Collection:
        e = Collections.enumeration(new ArrayList<String>());
    }
}