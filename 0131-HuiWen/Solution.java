import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 131.分割回文串
 * 难度：中
 * https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {

    public List<List<String>> partition(String s) {

        // 保存所有合法的分割方案。
        // 例如：[["a", "a", "b"], ["aa", "b"]]
        List<List<String>> result = new ArrayList<>();

        // 保存当前已经切出的回文子串。
        // 例如：["a", "a"]
        List<String> path = new ArrayList<>();

        // 从字符串的第 0 个字符开始分割。
        backtrack(s, 0, path, result);

        return result;
    }

    /**
     * 从 start 开始，分割剩余字符串。
     *
     * @param s      原字符串
     * @param start  当前尚未分割部分的起始下标
     * @param path   当前已经选好的回文子串
     * @param result 保存所有合法分割方案
     */
    private void backtrack(
            String s,
            int start,
            List<String> path,
            List<List<String>> result) {

        // 结束条件：
        // start 到达字符串末尾之后，
        // 说明所有字符都已经被分割完毕。
        if (start == s.length()) {

            // 保存当前方案的副本。
            // 后续还会修改 path，所以不能直接 result.add(path)。
            result.add(new ArrayList<>(path));
            return;
        }

        // 枚举当前这一段的结束位置。
        // 当前准备切出的子串范围为 [start, end]，两端都包含。
        for (int end = start; end < s.length(); end++) {

            // 如果当前这一段不是回文串，就不能选择。
            // 继续增大 end，尝试更长的子串。
            if (!isPalindrome(s, start, end)) {
                continue;
            }

            // 1. 做出选择：
            // substring 的右边界不包含在结果中，
            // 所以要写 end + 1，才能包含下标 end 的字符。
            path.add(s.substring(start, end + 1));

            // 2. 递归探索：
            // 当前已经切到了 end，
            // 下一段必须从 end + 1 开始。
            backtrack(s, end + 1, path, result);

            // 3. 撤销选择：
            // 删除本层刚加入的子串，
            // 继续尝试当前这一段的其他结束位置。
            path.remove(path.size() - 1);
        }
    }

    /**
     * 判断 s[left ... right] 是否为回文串。
     * left 和 right 都包含在检查范围内。
     */
    private boolean isPalindrome(String s, int left, int right) {

        // 从两端向中间逐个比较字符。
        while (left < right) {

            // 只要有一对字符不同，就不是回文串。
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            // 左指针向右移动。
            left++;

            // 右指针向左移动。
            right--;
        }

        // 所有对应字符都相等，是回文串。
        return true;
    }
}