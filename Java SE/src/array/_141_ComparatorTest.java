package array;

import static common.utils.Print.print;

import java.util.Arrays;
import java.util.Comparator;

class CompTypeComparator implements Comparator<_139_CompType> {
    public int compare(_139_CompType o1, _139_CompType o2) {
        return o1.j - o2.j;
    }
}

public class _141_ComparatorTest {
    public static void main(String[] args) {
        _139_CompType[] a = _132_Generated.array(new _139_CompType[12], _139_CompType.generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a, new CompTypeComparator());
        print("after sorting:");
        print(Arrays.toString(a));
    }
}