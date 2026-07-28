
/**
 * 0011. 成最多水 的容器
 * https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 思路：用双指针，左指针右指针的差值代表面积的宽度，两个指针的更小的那个代表容器的长度，遍历数组
 * 让更小的那个长度逐渐变大，使得其能满足尽可能多的存储的最大水量
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */


class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int s = 0;
        while (left < right) {
            int wide = right - left;//容器的宽度
            int len = Math.min(height[left], height[right]);//容器的长度
            s = Math.max(s,len * wide);//容器的s，代表当前的最大盛水量，后面的代表逐渐变化的面积

            if(height[left]<height[right]){
                //哪边的高度更小动哪边的指针即可
                left++;
            }else {
                right--;
            }
        }
        return s;
    }
}