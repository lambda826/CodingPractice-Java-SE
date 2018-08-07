package containers.hash;

import static common.utils.Print.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _06_CountedString {

    private static List<String> created = new ArrayList<String>();
    private String s;
    private int id = 0;

    public _06_CountedString(String str) {
        s = str;
        created.add(s);
        // id is the total number of instances of this string in use by CountedString:
        for (String s2 : created) {
            if (s2.equals(s)) {
                id++;
            }
        }
    }

    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }

    @Override
    public int hashCode() {
        // The very simple approach:
        // return s.hashCode() * id; Using Joshua Bloch's recipe:
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    public boolean equals(Object o) {
        return o instanceof _06_CountedString && s.equals(((_06_CountedString) o).s) && id == ((_06_CountedString) o).id;
    }

    public static void main(String[] args) {
        Map<_06_CountedString, Integer> map = new HashMap<_06_CountedString, Integer>();
        _06_CountedString[] cs = new _06_CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new _06_CountedString("hi");
            map.put(cs[i], i);
        }
        print(map);
        for (_06_CountedString cstring : cs) {
            print("Looking up " + cstring);
            print(map.get(cstring));
        }
    }
}