package concurrency;

public class _04_MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new _01_LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}