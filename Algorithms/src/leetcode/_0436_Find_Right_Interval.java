/**
 *  @author  Yunxiang He
 *  @date    Jan 19, 2018 5:14:53 PM
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import leetcode.common.Interval;

/*

Given a set of intervals, 
for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, 
which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, 
which means that the interval j has the minimum start point to build the "right" relationship for interval i. 

If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.

Example 1:
Input: [ [1,2] ]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.

Example 2:
Input: [ [3,4], [2,3], [1,2] ]
Output: [-1, 0, 1]
Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.

Example 3:
Input: [ [1,4], [2,3], [3,4] ]
Output: [-1, 2, -1]
Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.

 */

public class _0436_Find_Right_Interval {

    /**
     * Optimal Solution:
     * Bucket sorting
     * --------------------------------------------------------------
     *  Time complexity : O(n)
     * Space complexity : O(1)
     */
    public int[] findRightInterval(Interval[] intervals) {
        int[] res = new int[intervals.length];
        int maxStartPoint = Integer.MIN_VALUE;
        int minStartPoint = Integer.MAX_VALUE;
        // Find the maximum of the starts to determine how long the bucket should be
        // Since the start and end could be negative, we need to record both the max and min value;
        for (Interval interval : intervals) {
            maxStartPoint = Math.max(interval.start, maxStartPoint);
            minStartPoint = Math.min(interval.start, minStartPoint);
        }
        int[] bucket = new int[maxStartPoint - minStartPoint + 1];
        // Put all the startpoints int the bucket
        // Record the index of every startpoint
        bucket[intervals[0].start - minStartPoint] = -1;
        for (int i = 1; i < intervals.length; i++) {
            bucket[intervals[i].start - minStartPoint] = i;
        }
        // Find the nearest start of every end;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].end > maxStartPoint) {
                res[i] = -1;
            } else {
                int k = intervals[i].end - minStartPoint;
                while (bucket[k] == 0) {
                    k++;
                }
                if (bucket[k] == -1) {
                    res[i] = 0;
                } else {
                    res[i] = bucket[k];
                }
            }
        }
        return res;
    }

    /**
     * Solution:
     * Binary Search
     * --------------------------------------------------------------
     *  Time complexity : O(n log n)
     * Space complexity : O(1)
     */
    public int[] solution2(Interval[] intervals) {
        int[] res = new int[intervals.length];
        HashMap<Integer, Integer> startPointMap = new HashMap<>();
        List<Integer> startPointList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            startPointList.add(intervals[i].start);
            startPointMap.put(intervals[i].start, i);
        }
        Collections.sort(startPointList);
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].end > startPointList.get(startPointList.size() - 1)) {
                res[i] = -1;
            } else {
                res[i] = startPointMap.get(findRightAux(startPointList, intervals[i].end));
            }
        }
        return res;
    }

    private int findRightAux(List<Integer> startPointList, int endPoint) {
        int lo = 0;
        int hi = startPointList.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (startPointList.get(mid) == endPoint) {
                return startPointList.get(mid);
            } else if (startPointList.get(mid) < endPoint) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return startPointList.get(lo);
    }

    public static void main(String[] args) {
        _0436_Find_Right_Interval test = new _0436_Find_Right_Interval();
        Interval i1 = new Interval(1, 12);
        Interval i2 = new Interval(2, 9);
        Interval i3 = new Interval(3, 10);
        Interval i4 = new Interval(13, 14);
        Interval i5 = new Interval(15, 16);
        Interval i6 = new Interval(16, 17);
        Interval[] i = { i1, i2, i3, i4, i5, i6 };
        int[] res = test.findRightInterval(i);
        int[] res2 = test.solution2(i);
    }
}
