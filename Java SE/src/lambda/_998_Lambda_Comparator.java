/**
 *  @author Yunxiang He
 *    @date 11/22/2018
 */

package lambda;

import java.util.Comparator;
import java.util.Map;

public class _998_Lambda_Comparator {

    class Clazz {
        public String oString;
    }

    public static void main(String[] args) {
        Comparator<Clazz> cmp = (Clazz o1, Clazz o2) -> o1.oString.compareTo(o2.oString);
        Comparator<Map.Entry<String, Integer>> cmp2 = (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> o1.getValue() - o2.getValue();

    }
}
