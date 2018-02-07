/**
 *  @author  Yunxiang He
 *  @date    Jan 23, 2018 9:39:18 AM
 */

package multithreadedProgramming;

/*



 */

class NewThread2 implements Runnable {

    String name;
    Thread t;

    public NewThread2(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " exiting.");
    }

}

public class JoinDemo {

    public static void main(String[] args) {
        NewThread2 nt1 = new NewThread2("One");
        NewThread2 nt2 = new NewThread2("Two");
        NewThread2 nt3 = new NewThread2("Three");

        nt1.t.start();
        nt2.t.start();
        nt3.t.start();

        System.out.println("One is alive: " + nt1.t.isAlive());
        System.out.println("Two is alive: " + nt2.t.isAlive());
        System.out.println("Three is alive: " + nt3.t.isAlive());

        try {
            System.out.println("Waiting for threads to finish.");
            nt1.t.join();
            nt2.t.join();
            nt3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println("One is alive: " + nt1.t.isAlive());
        System.out.println("Two is alive: " + nt2.t.isAlive());
        System.out.println("Three is alive: " + nt3.t.isAlive());

        System.out.println("Main thread exiting.");
    }
}
