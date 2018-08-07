package containers.array;

import java.util.Arrays;

public class _144_AlphabeticSearch {
    public static void main(String[] args) {
        String[] sa = _132_Generated.array(new String[30], new _130_RandomGenerator.String(5));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(sa));
        int index = Arrays.binarySearch(sa, sa[10], String.CASE_INSENSITIVE_ORDER);
        System.out.println("Index: " + index + "\n" + sa[index]);
    }
}