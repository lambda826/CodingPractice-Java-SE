/**
 *  @author  Yunxiang He
 *  @date    Jan 23, 2018 9:05:48 AM
 */

package multithreadedProgramming;

/*



 */

class NewThread extends Thread implements Runnable {

    Thread t;

    public NewThread() {
        t = new Thread(this, "Demo Thread");
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }

}

public class ThreadDemo {

    public static void main(String[] args) {
        NewThread nt = new NewThread();
        NewThread nt2 = new NewThread();
        nt.start();
        nt.t.start();
        nt2.t.start();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println("Main interrupted.");
        }
        System.out.println("Exiting main thread.");
    }
}
