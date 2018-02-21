/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:51:15 AM
 */

package lambda;

/*



 */
interface MyFunc7<R, T> {
    R func(T n);
}

// A simple generic class. 
class MyClass7<T> {
    private T val;

    // A constructor that takes an argument. 
    MyClass7(T v) {
        val = v;
    }

    // The default constructor. This constructor 
    // is NOT used by this program. 
    MyClass7() {
        val = null;
    }
    // ... 

    T getVal() {
        return val;
    };
}

// A simple, non-generic class. 
class MyClass8 {
    String str;

    // A constructor that takes an argument. 
    MyClass8(String s) {
        str = s;
    }

    // The default constructor. This 
    // constructor is NOT used by this program. 
    MyClass8() {
        str = "";
    }

    // ... 

    String getVal() {
        return str;
    };
}

public class _117_ConstructorRefDemo3 {

    // A factory method for class objects. The class must 
    // have a constructor that takes one parameter of type T. 
    // R specifies the type of object being created. 
    static <R, T> R myClassFactory(MyFunc7<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String args[]) {
        // Create a reference to a MyClass7 constructor. 
        // In this case, new refers to the constructor that 
        // takes an argument. 
        MyFunc7<MyClass7<Double>, Double> myClassCons = MyClass7<Double>::new;

        // Create an instance of MyClass7 by use of the factory method. 
        MyClass7<Double> mc = myClassFactory(myClassCons, 100.1);

        // Use the instance of MyClass7 just created. 
        System.out.println("val in mc is " + mc.getVal());

        // Now, create a different class by use of myClassFactory(). 
        MyFunc7<MyClass8, String> myClassCons2 = MyClass8::new;

        // Create an instance of MyClass8 by use of the factory method. 
        MyClass8 mc2 = myClassFactory(myClassCons2, "Lambda");

        // Use the instance of MyClass7 just created. 
        System.out.println("str in mc2 is " + mc2.getVal());
    }
}