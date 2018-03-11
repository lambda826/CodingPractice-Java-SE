package collections.holding;

public class _273_TestParam {
    public final int size;
    public final int loops;

    public _273_TestParam(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    // Create an array of TestParam from a varargs sequence:
    public static _273_TestParam[] array(int... values) {
        int size = values.length / 2;
        _273_TestParam[] result = new _273_TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++)
            result[i] = new _273_TestParam(values[n++], values[n++]);
        return result;
    }

    // Convert a String array to a TestParam array:
    public static _273_TestParam[] array(String[] values) {
        int[] vals = new int[values.length];
        for (int i = 0; i < vals.length; i++)
            vals[i] = Integer.decode(values[i]);
        return array(vals);
    }
}