/**
 *  @author  Yunxiang He
 *  @date    Feb 2, 2018 11:17:39 AM
 */

package string.constructors;

public class constructorsDemo {

    public static void main(String[] args) {
        char[] chars = {'a','b','c'};
        byte[] chrs = {65, 66, 67};
        String s1 = new String();
        
//      String s2 = new String(char chars[]);
        String s2 = new String(chars);

//      String s3 = new String(char chars[], int startIndex, int numChars)
        String s3 = new String(chars, 0, 3);

//      String s4 = new String(String strObj);
        String s4 = new String(s1);
        
//      String s5 = new String(byte chrs[ ]);
        String s5 = new String(chrs);

//      String s6 = new String(byte chrs[], int startIndex, int numChars)
        String s6 = new String(chrs, 0, 3);
        
//      String s7 = new String(StringBuffer strBufObj)
        String s7 = new String(new StringBuffer());
        
//      String s8 = new String(StringBuilder strBuildObj)
        String s8 = new String(new StringBuilder());
        
//      String s9 = new String(int codePoints[ ], int startIndex, int numChars)

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
        System.out.println(s8);
        
    }
}
