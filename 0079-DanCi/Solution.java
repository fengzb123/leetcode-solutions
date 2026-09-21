import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 79.单词搜索
 * 难度：中
 * https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;//行
        int cols = board[0].length;//列
        if (rows * cols < word.length()) {
            return false;
        }
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, row, col, 0, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        //三种失败的情况
        //1.越界
        if (col < 0 || col >= board[0].length
                || row < 0 || row >=board.length) {
            return false;
        }
        //2.该格子中的字母已经使用了
        if (visited[row][col]) {
            return false;
        }
        //3.当前格子中的字符与这一步匹配的字符不同
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        //走到这里说明当前格子可用，而且字符匹配
        //如果当前匹配的是最后一个字符，说明已经全部匹配完成
        //成功的情况
        if (index == word.length() - 1) {
            return true;
        }
        //开始选择
        //标记当前位置已经选择过了
        visited[row][col] = true;
        //搜索上下左右四个位置
        boolean found = dfs(board, word, row - 1, col, index + 1, visited) ||
                dfs(board, word, row + 1, col, index + 1, visited) ||
                dfs(board, word, row, col - 1, index + 1, visited) ||
                dfs(board, word, row, col + 1, index + 1, visited);
        //撤销
        visited[row][col] = false;
        return found;
    }
}