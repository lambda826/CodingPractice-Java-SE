/**
 *  @author  Yunxiang He
 *  @date    Jan 28, 2018 2:48:56 AM
 */

package annotations;

public @interface MyAnno {
    String str();

    int val();
}

class Test {

    @MyAnno(str = "Annotation Example", val = 100)
    public static void myMeth() {

    }
}