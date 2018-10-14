package interfaces;

import java.util.Arrays;

public abstract class _111_StringProcessor implements _109_Processor {

    public String name() {
        return getClass().getSimpleName();
    }

    public abstract String process(Object input);

    public static String s = "If she weighs the same as a duck, she's made of wood";

    public static void main(String[] args) {
        _110_Apply.process(new UpcaseProc(), s);
        _110_Apply.process(new DowncaseProc(), s);
        _110_Apply.process(new SplitterProc(), s);
    }
}

class UpcaseProc extends _111_StringProcessor {
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class DowncaseProc extends _111_StringProcessor {
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class SplitterProc extends _111_StringProcessor {
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}