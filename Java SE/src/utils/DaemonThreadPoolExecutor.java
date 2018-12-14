//: net/mindview/util/DaemonThreadPoolExecutor.java
package utils;

import java.util.concurrent.*;

public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
    }
} ///:~