package containers.array;

import static common.utils.Print.print;

import java.util.Arrays;
import java.util.Random;

import generics._109_Generator;

public class _139_CompType implements Comparable<_139_CompType> {
    int i;
    int j;
    private static int count = 1;

    public _139_CompType(int n1, int n2) {
        i = n1;
        j = n2;
    }

    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }

    public int compareTo(_139_CompType rv) {
        return i - rv.i;
    }

    private static Random r = new Random(47);

    public static _109_Generator<_139_CompType> generator() {
        return new _109_Generator<_139_CompType>() {
            public _139_CompType next() {
                return new _139_CompType(r.nextInt(100), r.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        _139_CompType[] a = _132_Generated.array(new _139_CompType[12], generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a);
        print("after sorting:");
        print(Arrays.toString(a));
    }
}