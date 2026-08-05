import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 438.找到字符串中所有字母异位词
 * 难度：中
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * 思路：用滑动窗口的方法，先进行特判，如果s中的字符长度小于p中的字符长度，直接返回结果，结果用一个res集合来保存
 * 用两个长度为26的数组wincount和pcount来记录移动过程中字符的频次能否匹配上，只要能匹配上就说明存在异位词与p中的字符频次相同
 * 先统计最初状态时候s和p中每个字符的频次，然后进行直接比较，如果相同直接加入res集合中
 * 然后遍历s数组，窗口长度始终固定为p的长度，故当左移动时候，需要将左边的字符移除wincount中，并且将该字符--，然后将右边窗口的一个字符加入
 * 并且对该位置的字符进行++，然后进行比较是否符合题目条件，如果符合直接将此时左指针left对应的下标存入到集合res中即可，遍历完得到最终集合
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();
        if (slen < plen) {
            return res;
        }
        int[] pCount = new int[26];
        int[] winCount = new int[26];
        //统计p，s中的每个字符的频次
        for (int i = 0; i < plen; i++) {
            pCount[p.charAt(i) - 'a']++;
            winCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(winCount, pCount)) {
            res.add(0);
        }
        //移动窗口的左边边界
        for (int left = 1; left <= slen - plen; left++) {
            //先将左边窗口给移除,并且该字符的频次--
            char leftChar = s.charAt(left - 1);
            winCount[leftChar - 'a']--;
            //然后将右边窗口给加上，并且右边窗口字符的频次++
            char rightChar = s.charAt(left + plen - 1);
            winCount[rightChar - 'a']++;
            if (Arrays.equals(winCount, pCount)) {
                res.add(left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //System.out.println(sol.findAnagrams("cbaebabacd", "abc")); // [0,6]
        System.out.println(sol.findAnagrams("abab", "ab")); // [0,1,2]
    }
}