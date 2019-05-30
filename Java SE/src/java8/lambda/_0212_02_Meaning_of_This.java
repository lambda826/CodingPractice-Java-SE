package java8.lambda;

interface ThisMethod {
    void apply(int i);
}

public class _0212_02_Meaning_of_This {

    public final int value = 4;
    int i = 0;

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

    public ThisMethod method() {
        return (i) -> {
            this.i = i;
        };
    }

    public static void main(String... args) {
        _0212_02_Meaning_of_This instance = new _0212_02_Meaning_of_This();
        instance.doIt();
        instance.method().apply(2);
        System.out.println(instance.i);
    }

}
