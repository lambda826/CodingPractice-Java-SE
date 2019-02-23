package concurrency;

public class _17_SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;

    public _17_SimpleThread() {
        // Store the thread name:
        super(Integer.toString(++threadCount));
        start();
    }

    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }

    public void run() {
        while (true) {
            System.out.print(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new _17_SimpleThread();
        }
    }
}