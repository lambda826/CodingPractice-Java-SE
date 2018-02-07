package multithreadedProgramming.communication.demo2_right;

public class PC {

    public static void main(String[] args) {
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

        producer.t.start();
        consumer.t.start();

        System.out.println("Press Control-C to stop.");
    }
}
