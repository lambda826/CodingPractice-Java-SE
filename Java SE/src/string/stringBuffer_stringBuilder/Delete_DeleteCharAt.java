/**
 *  @author  Yunxiang He
 *  @date    Feb 2, 2018 1:20:22 PM
 */

package string.stringBuffer_stringBuilder;


public class Delete_DeleteCharAt {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("This is a test.");
        sb.delete(4, 7);
        System.out.println(sb);
        
        sb.deleteCharAt(0);
        System.out.println(sb);
    }
}
