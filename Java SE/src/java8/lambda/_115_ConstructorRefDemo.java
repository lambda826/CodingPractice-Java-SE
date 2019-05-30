/**
 *  @author  Yunxiang He
 *  @date    Feb 14, 2018 1:48:16 AM
 */

package java8.lambda;

interface MyFunc4 {
    MyClass4 func(int n);
}

class MyClass4 {
    private int val;

    // This constructor takes an argument
    MyClass4(int v) {
        val = v;
    }

    // This is the default constructor
    MyClass4() {
        val = 0;
    }

    // ... 

    int getVal() {
        return val;
    };
}

class _115_ConstructorRefDemo {
    public static void main(String args[]) {
        // Create a reference to the MyClass4 constructor
        // Because func() in MyFunc4 takes an argument, new refers to the parameterized constructor in MyClass4, not the default constructor 
        MyFunc4 myClassCons = MyClass4::new;

        // Create an instance of MyClass4 via that constructor reference
        MyClass4 mc = myClassCons.func(100);

        // Use the instance of MyClass4 just created
        System.out.println("val in mc is " + mc.getVal());
    }
}