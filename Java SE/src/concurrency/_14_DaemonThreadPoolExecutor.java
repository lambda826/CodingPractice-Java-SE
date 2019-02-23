package concurrency;

import java.util.concurrent.*;

public class _14_DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public _14_DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new _12_DaemonThreadFactory());
    }
}
