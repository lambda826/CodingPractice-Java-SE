package multithreadedProgramming.communication.deadLockDemo;

public class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();

        System.out.println((name + " entered B.bar"));

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("A Interrupted");
        }

        System.out.println(name + " trying to call a.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last");
    }
}
