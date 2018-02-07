/**
 *  @author  Yunxiang He
 *  @date    Feb 1, 2018 11:41:38 PM
 */

package basicAlgorithms.search;

public class BinarySearch {

    public int find_Target(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public int find_The_Smallest_Element_Greater_Than_Target(int nums[], int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo] > target ? lo : -1;
    }

    public int find_The_Smallest_Element_No_Less_Than_Target(int nums[], int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo] >= target ? lo : -1;
    }

    public int find_The_Largest_Element_Less_Than_Target(int nums[], int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }

    public int find_The_Largest_Element_No_Greater_Than_Target(int nums[], int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo == 0 ? (nums[lo] < target ? lo : -1) : lo - 1;
        //        nums[lo] <= target ? lo : lo - 1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 5 };
        int target = 5;
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.find_Target(nums, target));
        System.out.println(bs.find_The_Smallest_Element_Greater_Than_Target(nums, target));
        System.out.println(bs.find_The_Smallest_Element_No_Less_Than_Target(nums, target));
        System.out.println(bs.find_The_Largest_Element_Less_Than_Target(nums, target));
        System.out.println(bs.find_The_Largest_Element_No_Greater_Than_Target(nums, target));
    }
}
