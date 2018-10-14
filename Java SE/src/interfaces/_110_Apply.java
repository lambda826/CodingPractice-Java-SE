package interfaces;

import static utils.Print.print;

public class _110_Apply {

    public static void process(_109_Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }

}
