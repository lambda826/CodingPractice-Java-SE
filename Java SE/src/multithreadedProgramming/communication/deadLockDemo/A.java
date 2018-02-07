package multithreadedProgramming.communication.deadLockDemo;

public class A {

    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();

        System.out.println((name + " entered A.foo"));

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("A Interrupted");
        }

        System.out.println(name + " trying to call b.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last");
    }
}
