/**
 * 0283. 移动0
 * https://leetcode.cn/problems/move-zeroes
 *
 * 思路：使用快慢指针来遍历数组，查找0元素，每当快指针找到一个非0元素，就交换快慢指针
 *
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums [fast];
                nums[fast] = temp;
                slow++;
            }
        }
    }
}