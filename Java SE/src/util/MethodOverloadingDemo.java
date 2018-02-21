package util;

/**
 *  @author  Yunxiang He
 *  @date    Jan 11, 2018 12:35:39 PM
 */

/*



 */

public class MethodOverloadingDemo {

    void test() {

    }

    void test(double d) {
        System.out.println(d);
    }

    void test(int i1, int i2) {
        System.out.println("" + i1 + " " + i2);
    }

    public static void main(String[] args) {
        MethodOverloadingDemo demo = new MethodOverloadingDemo();
        // 自动转型
        demo.test(1);

        String string = new String("3213");
        demo.changeStr(string);
        System.out.println(string);
    }

    public void changeStr(String s) {
        s = "abc";
    }
}
