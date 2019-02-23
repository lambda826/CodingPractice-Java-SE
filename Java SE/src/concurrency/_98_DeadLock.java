/**
 *  @author Yunxiang He
 *  @date   02/23/2019
 */

package concurrency;

import java.util.concurrent.TimeUnit;

public class _98_DeadLock {

    public static void main(String[] args) {
        _98_DeadLock v1 = new _98_DeadLock();
        _98_DeadLock v2 = new _98_DeadLock();
        new T1(v1, v1);
        new T2(v1, v2);
    }

    public synchronized void name() {

    }
}

class T1 extends Thread {
    _98_DeadLock a;
    _98_DeadLock b;

    public T1(_98_DeadLock a, _98_DeadLock b) {
        this.a = a;
        this.b = b;
        start();
    }

    @Override
    public void run() {
        a.name();
        try {
            TimeUnit.SECONDS.sleep(30);
            b.name();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class T2 extends Thread {

    _98_DeadLock a;
    _98_DeadLock b;

    public T2(_98_DeadLock a, _98_DeadLock b) {
        this.a = a;
        this.b = b;
        start();
    }

    @Override
    public void run() {
        b.name();
        a.name();
    }
}
