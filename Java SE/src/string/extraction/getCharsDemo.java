/**
 *  @author  Yunxiang He
 *  @date    Feb 2, 2018 11:22:57 AM
 */

package string.extraction;

public class getCharsDemo {

    public static void main(String[] args) {
        String s = "This is a demo of the getChars method";
        int start = 10;
        int end = 14;
        char buf[] = new char[end - start];
        // void getChars(int sourceStart, int sourceEnd, char target[ ], int targetStart)
        s.getChars(start, end, buf, 0);
        System.out.println(buf);
    }
}
