/**
 *  @author  Yunxiang He
 *  @date    Feb 21, 2018 11:12:34 AM
 */

package generics._01_simpleGeneric;

public class Stats_BoundedType<T extends Number> {
    T[] nums;

    public Stats_BoundedType(T[] o) {
        nums = o;
    }

    // Return type double in all cases
    public double average() {
        double sum = 0.0;

        for (int i = 0; i < nums.length; i++)

            sum += nums[i].doubleValue();

        return sum / nums.length;
    }
}
