import java.util.Arrays;
import java.util.Comparator;
/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len < 2) {
            return len;
        }
        //根据右边界升序排序
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        //第一个气球的右边界
        int pos = points[0][1];
        //至少有一支箭
        int ans = 1;
        for (int[] balloon : points) {
            //如果当前气球左边界大于缓存的右边界，则当前的箭无法引爆此气球
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
// @lc code=end

