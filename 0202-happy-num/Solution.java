import java.util.HashSet;
import java.util.Set;

/**
 * 0202. 复写0
 * https://leetcode.cn/problems/move-zeroes
 * <p>
 * 思路：用一个hash表来存储这个这个快乐数的过程，用来循环判断这个集合中是否会再次出现这个数字
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNum(n);
        }
        return n==1;
    }

    private int getNum(int n) {
        int sum = 0;
        while (n > 0) {
            int ge = n%10;
            sum+= ge*ge;
            n = n /10;
        }
        return sum;
    }
}

