/**
 *  @author  Yunxiang He
 *  @date    Jan 29, 2018 9:44:17 PM
 */

package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*

On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.

Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

Return the smallest possible value of D.

Example:

Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000
Note:

stations.length will be an integer in range [10, 2000].
stations[i] will be an integer in range [0, 10^8].
K will be an integer in range [1, 10^6].
Answers within 10^-6 of the true value will be accepted as correct.


 */

public class _0774_Minimize_Max_Distance_to_Gas_Station {

    public double minmaxGasDist(int[] stations, int K) {

        PriorityQueue<Double> d = new PriorityQueue<Double>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o1 == o2) {
                    return 0;
                } else if (o1 > o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 1; i < stations.length; i++) {
            d.add((double) (stations[i] - stations[i - 1]));
        }

        while (K > 0) {
            double max = d.remove();
            int lo = 1;
            int hi = K + 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                double dis = max / mid;
                if (dis > d.peek()) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            for (int i = 0; i < lo; i++) {
                d.add(max / (lo + 1));
            }
            K = K - lo;
        }
        
        return d.peek();
    }

    public static void main(String[] args) {
        int[] stations = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int K = 9;
        _0774_Minimize_Max_Distance_to_Gas_Station test = new _0774_Minimize_Max_Distance_to_Gas_Station();
        System.out.println(test.minmaxGasDist(stations, K));
    }
}
