package concurrency;

import static utils.Print.*;

public class _45_MultiLock {
    public synchronized void f1(int count) {
        if (count-- > 0) {
            print("f1() calling f2() with count " + count);
            f2(count);
        }
    }

    public synchronized void f2(int count) {
        if (count-- > 0) {
            print("f2() calling f1() with count " + count);
            f1(count);
        }
    }

    public static void main(String[] args) throws Exception {
        final _45_MultiLock multiLock = new _45_MultiLock();
        new Thread() {
            public void run() {
                multiLock.f1(10);
            }
        }.start();
    }
} /* Output:
  f1() calling f2() with count 9
  f2() calling f1() with count 8
  f1() calling f2() with count 7
  f2() calling f1() with count 6
  f1() calling f2() with count 5
  f2() calling f1() with count 4
  f1() calling f2() with count 3
  f2() calling f1() with count 2
  f1() calling f2() with count 1
  f2() calling f1() with count 0
  *///:~
