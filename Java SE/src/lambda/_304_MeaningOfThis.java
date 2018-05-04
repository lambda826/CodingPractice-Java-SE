package lambda;

public class _304_MeaningOfThis {
    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            public void run() {
                int value = 10;
                // this referes to r,
                // this.value referes to 5
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String... args) {
        _304_MeaningOfThis m = new _304_MeaningOfThis();
        m.doIt();
    }
}