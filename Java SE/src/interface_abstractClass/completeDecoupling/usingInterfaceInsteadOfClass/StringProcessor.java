/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 9:26:19 PM
 */

package interface_abstractClass.completeDecoupling.usingInterfaceInsteadOfClass;

import java.util.Arrays;

public abstract class StringProcessor implements Processor {

    public static String s = "If she weighs the same as a duck, she’s made of wood";

    public String name() {
        return getClass().getSimpleName();
    }

    public abstract String process(Object input);

    public static void main(String[] args) {
        Apply.process(new Upcase(), s);
        Apply.process(new Downcase(), s);
        Apply.process(new Splitter(), s);
    }
}

class Upcase extends StringProcessor {
    public String process(Object input) { // Covariant return
        return ((String) input).toUpperCase();
    }
}

class Downcase extends StringProcessor {
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}