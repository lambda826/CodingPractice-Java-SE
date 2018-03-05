/**
 *  @author  Yunxiang He
 *  @date    Mar 1, 2018 5:14:04 PM
 */

package generics;

class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getob() {
        return ob;
    }
}

class _111_RawDemo {
    public static void main(String args[]) {

        // Create a Gen object for Integers. 
        _101_Gen<Integer> iOb = new _101_Gen<Integer>(88);

        // Create a Gen object for Strings. 
        _101_Gen<String> strOb = new _101_Gen<String>("Generics Test");

        // Create a raw-type Gen object and give it  a Double value. 
        _101_Gen raw = new _101_Gen(Double.valueOf(98.6));

        // Cast here is necessary because type is unknown. 
        double d = (Double) raw.getob();
        System.out.println("value: " + d);

        // The use of a raw type can lead to run-time exceptions.  
        // Here are some examples. 

        // The following cast causes a run-time error! 
        int i = (Integer) raw.getob(); // run-time error 

        // This assigment overrides type safety. 
        strOb = raw; // OK, but potentially wrong 
        String str = strOb.getob(); // run-time error  

        // This assingment also overrides type safety. 
        raw = iOb; // OK, but potentially wrong 
        d = (Double) raw.getob(); // run-time error 
    }
}
