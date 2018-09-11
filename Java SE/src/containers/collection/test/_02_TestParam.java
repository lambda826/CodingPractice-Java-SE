package containers.collection.test;

public class _02_TestParam {
    public final int size;
    public final int loops;

    public _02_TestParam(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    // Create an array of TestParam from a varargs sequence:
    public static _02_TestParam[] array(int... values) {
        int size = values.length / 2;
        _02_TestParam[] result = new _02_TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++) {
            result[i] = new _02_TestParam(values[n++], values[n++]);
        }
        return result;
    }

    // Convert a String array to a TestParam array:
    public static _02_TestParam[] array(String[] values) {
        int[] vals = new int[values.length];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
}