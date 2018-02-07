/**
 *  @author  Yunxiang He
 *  @date    Jan 11, 2018 4:35:18 PM
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcode.common.Interval;

/*

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

 */

public class _0056_Merge_Intervals {

    /**
     * Solution:
     * Sort the intervals by start
     * if the start of the current interval is less than the end of previous end, merge them
     * --------------------------------------------------------------
     *  Time complexity : O(n log n)
     * Space complexity : O(1)
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals.size() <= 1)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start)
                    return -1;
                else if (o1.start > o2.start)
                    return 1;
                else
                    return 0;
            }
        });

        int startPre = intervals.get(0).start;
        int endPre = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (endPre < interval.start) {
                res.add(new Interval(startPre, endPre));
                startPre = interval.start;
            }
            if (endPre < interval.end)
                endPre = interval.end;
        }
        res.add(new Interval(startPre, endPre));
        return res;
    }

    public static void main(String[] args) {
        _0056_Merge_Intervals test = new _0056_Merge_Intervals();
        Interval i1 = new Interval(1, 4);
        Interval i2 = new Interval(2, 3);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);
        ArrayList<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        List<Interval> list2 = test.merge(list);
        for (Interval interval : list2) {
            System.out.print(interval.start + "    ");
            System.out.println(interval.end);
        }
    }
}
