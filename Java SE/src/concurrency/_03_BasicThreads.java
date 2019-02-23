package concurrency;

public class _03_BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new _01_LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}