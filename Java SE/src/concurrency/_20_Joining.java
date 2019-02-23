package concurrency;

import static utils.Print.print;

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            print(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
            return;
        }
        print(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run() {
        try {
            // Wait for the sleeper to complete before proceeding
            sleeper.join();
        } catch (InterruptedException e) {
            print("Interrupted");
        }
        print(getName() + " join completed");
    }
}

public class _20_Joining {
    public static void main(String[] args) {
        Sleeper grumpy = new Sleeper("Grumpy", 1500);
        Joiner doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
        
        Sleeper sleepy = new Sleeper("Sleepy", 2500);
        Joiner dopey = new Joiner("Dopey", sleepy);
        
    }
}