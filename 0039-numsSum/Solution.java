import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438.找到字符串中所有字母异位词
 * 难度：中
 * https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * 思路：尝试选择，失败就退回来
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //先做准备工作
        List<List<Integer>> res = new ArrayList<>();//保存最后结果的集合
        List<Integer> path = new ArrayList<>();//保存过程中的答案集合
        // 复制一份数组再排序，避免修改调用者传入的原数组。
        int[] nums = Arrays.copyOf(candidates, candidates.length);

        // 排序后，如果当前数字大于剩余目标值，
        // 后面的数字也一定大于剩余目标值，可以直接停止循环。
        Arrays.sort(nums);
        //开始递归调用，从第一个数字开始
        backtrack(nums, 0, target, path, res);
        return res;
    }
    private void backtrack(int []nums,int start,int remain,List<Integer> path,List<List<Integer>> res ){
        //返回结果
        if(remain==0){
            res.add(new ArrayList<>(path));
            return;
        }
        //开始枚举
        for(int i=start;i<nums.length;i++){
            //如果此时的数字大于目标剩余价值就直接跳出，结束本层循环
            if(nums[i]>remain)
                break;;
            //先选择第一个数字
            path.add(nums[i]);
            //递归调用继续选剩下的
            backtrack(nums,i,remain-nums[i],path,res);
            //递归返回后撤销刚才的选择
            path.remove(path.size()-1);
        }
    }
}