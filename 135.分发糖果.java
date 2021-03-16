import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len < 2) {
            return len;
        }
        int[] res = new int[len];
        Arrays.fill(res, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int i = len - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                res[i - 1] = Math.max(res[i - 1], res[i] + 1);
            }
        }
        return Arrays.stream(res).reduce(0, Integer::sum);
    }
}
// @lc code=end

