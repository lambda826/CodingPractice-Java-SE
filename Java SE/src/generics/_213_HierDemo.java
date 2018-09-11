/**
 *  @author  Yunxiang He
 *  @date    Mar 1, 2018 5:37:05 PM
 */

package generics;

class Gen2<T, V> extends _201_Gen<T> {
    V ob2;

    Gen2(T o, V o2) {
        super(o);
        ob2 = o2;
    }

    V getob2() {
        return ob2;
    }
}

// Create an object of type Gen2. 
class _213_HierDemo {
    public static void main(String args[]) {

        // Create a Gen2 object for String and Integer. 
        Gen2<String, Integer> x = new Gen2<String, Integer>("Value is: ", 99);

        System.out.print(x.getob());
        System.out.println(x.getob2());
    }
}