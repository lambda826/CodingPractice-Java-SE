/**
 *    Copyright 2017 Yunxiang He
 *
 *    All right reserved.
 * 
 *    Create on Oct 7, 2017 6:32:18 PM
 */
package design_pattern.creational.singleton;

/**
 * @author Yunxiang He
 * @date Oct 7, 2017 6:32:18 PM
 */
public class Singleton_0 {

    // 创建 SingleObject 的一个对象
    private static Singleton_0 instance = new Singleton_0();

    // 让构造函数为 private，这样该类就不会被实例化
    private Singleton_0() {
    }

    // 获取唯一可用的对象
    public static Singleton_0 getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        Singleton_0 object = Singleton_0.getInstance();
        object.showMessage();
    }
}
