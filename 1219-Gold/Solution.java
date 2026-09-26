import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1219.黄金矿工
 * 难度：中
 * https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * 思路：本道题目需要对整个表格进行遍历，故从最开始就需要判断如果这个表格的某个位置大于0才能开始走（递归遍历），如果==0就直接返回
 * 递归遍历的关键点--已经走过的格子不能重复走，越界，该格子中的黄金数量是否大于0，都判断完之后每走一个格子就累加一个格子上的黄金数
 * 然后取最大值即可，递归上下左右四个方向找到最大值，每次先标记再走，最后撤销。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    private int rows;
    private int cols;
    private int MaxGold;
    private boolean[][] visited;

    public int getMaximumGold(int[][] grid) {
        //先定义行和列
        rows = grid.length;
        cols = grid[0].length;
        //定义visited数组
        visited = new boolean[rows][cols];
        //定义最大黄金数量
        MaxGold = 0;
        //因为要从任意一个有黄金的格子开始，故要遍历整个表格
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //只能走有黄金的格子
                if (grid[row][col] > 0) {
                    backtrack(grid, row, col, 0);
                }
            }
        }
        return MaxGold;
    }

    private void backtrack(int[][] grid, int row, int col, int gold) {
        //先看是否越界
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }
        //再看这个格子中的黄金是否大于0
        if (grid[row][col] <= 0) {
            return;
        }
        //当前这个格子已经走过不能再进入
        if(visited[row][col]){
            return;
        }
        //黄金相加,取最大值
        gold += grid[row][col];
        MaxGold = Math.max(gold, MaxGold);
        //开始递归遍历整个表格
        //先标记走过的格子
        visited[row][col] = true;
        //然后从这个格子的上下左右依次遍历
        backtrack(grid, row - 1, col, gold);
        backtrack(grid, row + 1, col, gold);
        backtrack(grid, row, col - 1, gold);
        backtrack(grid, row, col + 1, gold);
        //撤销标记
        visited[row][col] = false;
    }
}