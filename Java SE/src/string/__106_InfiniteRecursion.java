package string;

import java.util.*;

public class __106_InfiniteRecursion {

    // The compiler sees a String followed by a’+’ and something that’s not a String, so it tries to convert this to a String. 
    // It does this conversion by calling toString( ), which produces a recursive call.
    public String toString() {
        return " InfiniteRecursion address: " + this + "\n";
    }

    // If you really do want to print the address of the object, the solution is to call the ObjecttoString( ) method, which does just that. 
    // So instead of saying this, you’d say super.toString( )
    public String _toString() {
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<__106_InfiniteRecursion> v = new ArrayList<__106_InfiniteRecursion>();
        for (int i = 0; i < 10; i++) {
            v.add(new __106_InfiniteRecursion());
        }
        System.out.println(v);
    }
    
}
