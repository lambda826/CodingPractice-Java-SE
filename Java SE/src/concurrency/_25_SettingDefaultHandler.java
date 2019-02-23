package concurrency;

import java.util.concurrent.*;

public class _25_SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new _22_ExceptionThread());
    }
} /* Output:
  caught java.lang.RuntimeException
  *///:~
