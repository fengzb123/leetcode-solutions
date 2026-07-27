import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0015. 三数之和
 * https://leetcode.cn/problems/move-zeroes
 * <p>
 * 思路：首先对数组元素进行排序。然后定义左右指针，往中间同时走，固定住第一个num【i】开始动左右指针
 * 如果相加小于0就让right向左移动，如果相加大于0就让left向右移动
 * key:对数组中的元素进行去重的操作，对第一个固定的数字i进行去重，对左右指针进行去重
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        //step1：先对数组进行排序
        Arrays.sort(nums);
        int len = nums.length;
        ;
        //step2：开始遍历数组，先固定第一个数
        for (int i = 0; i < len; i++) {
            //第一个数大于0后续就不用再计算了，全部都大0
            if (nums[i] > 0) {
                break;
            }
            //对第一个数字i进行去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //开始定义左右指针往中间走，左指针从第一个数字之后开始，右指针从数组的末端开始
            int left = i + 1;
            int right = len - 1;
            //开始循环换遍历这个数组剩下的数字
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //对左指针进行去重,不能直接用if因为if只能判断连续的两个数字，如果出现连续的三个数字就判断不了了
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //找到一组解之后同时收缩左右指针
                    right--;
                    left++;
                } else if (sum < 0) {
                    //和小于0往右找
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
}