import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 22.括号生成
 * 难度：中
 * https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * 思路：必须要保证括号合法，即已选择的左括号数一定要比已选择的右括号数大才可以。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        //先用集合来保存答案
        List<String> res = new ArrayList<>();
        //方便进行在path中进行扩容
        StringBuilder path = new StringBuilder();
        //递归回溯
        backtrack(n,0,0,path,res);
        return res;
    }
    private void backtrack(int n,int left,int right,StringBuilder path,List<String> res){
        //保存结果并返回
        if(left==n&&right==n){
            res.add(path.toString());
            return;
        }
        //如果还有左括号，先添加已使用的左括号
        if(left<n){
            path.append("(");
            backtrack(n,left+1,right,path,res);
            path.deleteCharAt(path.length()-1);
        }
        //添加右括号
        if(right<left){
            path.append(")");
            backtrack(n,left,right+1,path,res);
            path.deleteCharAt(path.length()-1);
        }
    }
}