/**
 *  @author  Yunxiang He
 *  @date    Feb 21, 2018 12:49:42 PM
 */

package generics.OTHERS;

public class Stats_Wildcard<T extends Number> {
    T[] nums;

    public Stats_Wildcard(T[] o) {
        nums = o;
    }

    public double average() {
        double sum = 0.0;

        for (int i = 0; i < nums.length; i++)
            sum += nums[i].doubleValue();

        return sum / nums.length;
    }

    public boolean sameAvg(Stats_Wildcard<?> ob) {
        if (average() == ob.average()) {
            return true;
        }
        return false;
    }
}