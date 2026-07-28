import java.util.Arrays;

/**
 * 0011. 成最多水 的容器
 * https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 思路：用双指针，先对数组元素进行排序，然后对数组中最长的边进行固定，再让左指针在最左端
 * 右指针指向右端-1的位置，当左右指针之和大于最长边的时候即成立，此时count的值为right-left之间所有的集合。
 * 这是因为数组升序排序，最左边的指针都满足了条件，那么中间的数字比最左边的大一定也会满足条件。
 * 本题还有一个关键点就是要让数组进行一个倒序遍历，这样能更好的实现双指针的一个对冲过程时间最快
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */


class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for(int i = n-1;i>=2;i--){
            //这里i最小只能是2，因为左右指针还要占两个位置
            int right = i-1;
            int left =0;
            while (left<right){
                if(nums[left]+nums[right]>nums[i]){
                    count = count +right-left;
                    right--;
                }else {
                    left++;
                }
            }
        }
        return count;
    }
}