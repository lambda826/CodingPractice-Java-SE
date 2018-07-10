package array;

import static common.utils.Print.print;

import java.util.Arrays;
import java.util.Collections;

public class _140_Reverse {
    public static void main(String[] args) {
        _139_CompType[] a = _132_Generated.array(new _139_CompType[12], _139_CompType.generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        print("after sorting:");
        print(Arrays.toString(a));
    }
}