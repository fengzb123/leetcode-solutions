import java.util.Arrays;
import java.util.HashMap;

/**
 * 0003.无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
 * 思路：用滑动窗口的方法，定义一个左指针和一个右指针，当右指针指向的元素不在集合中时，就继续往右边移，直到重复。其中用map存储每个字符的索引。
 * 然后更新最长的长度，最后返回最长的长度。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //key表示字符，value表示该字符的索引位置
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxlen = 0;
        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);
            if(map.containsKey(cur)&&map.get(cur)>=left){
                //剔除重复字符的索引位置
                left = map.get(cur) + 1;
            }
            //更新当前字符的最新索引位置
            map.put(cur,right);
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}