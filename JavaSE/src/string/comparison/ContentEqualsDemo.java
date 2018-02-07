/**
 *  @author  Yunxiang He
 *  @date    Feb 2, 2018 12:58:19 PM
 */

package string.comparison;

public class ContentEqualsDemo {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("YXH");
        String st = "YXH";
        System.out.println(st.contentEquals(sb));
    }
}
