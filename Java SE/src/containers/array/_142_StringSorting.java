package containers.array;

import static common.utils.Print.print;

import java.util.Arrays;
import java.util.Collections;

public class _142_StringSorting {
    public static void main(String[] args) {
        String[] sa = _132_Generated.array(new String[20], new _130_RandomGenerator.String(5));
        print("Before sort: " + Arrays.toString(sa));
        Arrays.sort(sa);
        print("After sort: " + Arrays.toString(sa));
        Arrays.sort(sa, Collections.reverseOrder());
        print("Reverse sort: " + Arrays.toString(sa));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        print("Case-insensitive sort: " + Arrays.toString(sa));
    }
}