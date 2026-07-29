import java.util.Arrays;

/**
 * 0008.长度最小的子数组
 * https://leetcode.cn/problems/2VG8Kg/description/
 * 思路：用滑动窗口的方法，首先注意本题不能进行排序，因为题目要求的是连续的数组，所以不能进行先排序。
 * 定义一个右指针，然后让右指针不断的往右移动，当右指针指向的元素的和大于等于目标值的时候开始对左指针进行移动。
 * 作while的循环判断，当左指针往右边移之后仍然大于等于目标值的时候，就继续往右边移，直到小于目标值。
 * 然后更新最小的长度，最后返回最小的长度。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int minlen = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                int curlen = right - left + 1;
                minlen = Math.min(minlen,curlen);
                sum -= nums[left];
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}