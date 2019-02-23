/**
 *  @author Yunxiang He
 *  @date   02/18/2019
 */

package concurrency;

public class Practice implements Runnable {

    private int i = 10;
    private String name;

    public Practice(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (i > 0) {
            System.out.println(name + ": " + i--);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Practice("p1"));
        Thread t2 = new Thread(new Practice("p2"));
        t1.start();
        t2.start();
        Thread t3 = new T();
        t3.start();
    }

}


class T extends Thread {
    @Override
    public void run() {
        int i = 10;
        while (i > 0) {
            System.out.println( "p3: " + i--);
        }
    }
}