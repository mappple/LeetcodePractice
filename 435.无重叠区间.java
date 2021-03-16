import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int prev = intervals[0][1];
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] < prev) {
                ++res;
            } else {
                prev = intervals[i][1];
            }
        }
        return res;
    }
}
// @lc code=end

