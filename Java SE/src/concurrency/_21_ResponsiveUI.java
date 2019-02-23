package concurrency;
// User interface responsiveness.

// {RunByHand}

class UnresponsiveUI {
    private volatile double d = 1;

    public UnresponsiveUI() throws Exception {
        while (d > 0)
            d = d + (Math.PI + Math.E) / d;
        System.in.read(); // Never gets here
    }
}

public class _21_ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public _21_ResponsiveUI() {
        setDaemon(true);
        start();
    }

    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
        //! new UnresponsiveUI(); // Must kill this process
        new _21_ResponsiveUI();
        System.in.read();
        System.out.println(d); // Shows progress
    }
} ///:~
