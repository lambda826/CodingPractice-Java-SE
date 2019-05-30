/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:50:35 AM
 */

package java8.lambda;

interface MyFunc5<T> {
    MyClass5<T> func(T n);
}

class MyClass5<T> {
    private T val;

    // A constructor that takes an argument 
    MyClass5(T v) {
        val = v;
    }

    // This is the default constructor
    MyClass5() {
        val = null;
    }

    // ... 

    T getVal() {
        return val;
    };
}

class _116_ConstructorRefDemo2 {

    public static void main(String args[]) {
        // Create a reference to the MyClass5<T> constructor
        MyFunc5<Integer> myClassCons = MyClass5<Integer>::new;

        // Create an instance of MyClass5<T> via that constructor reference
        MyClass5<Integer> mc = myClassCons.func(100);

        // Use the instance of MyClass5<T> just created
        System.out.println("val in mc is " + mc.getVal());
    }
}