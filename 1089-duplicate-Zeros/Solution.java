/**
 * 1089. 复写0
 * https://leetcode.cn/problems/move-zeroes
 * <p>
 * 思路：使用读写指针来从后往前遍历数组，查找0元素，当read指针找到0元素的时候，write指针向左复制两个0
 * 初始时候read指针指向最右端，然后write指针指向真实数组的最右端，在这里，write指针实际是指向复写0之后的数组的最右端（这是一个虚拟数组）
 * 所以当wirte指向的数组下标小于真实数组下标的时候才可以进行写入真实数组中，否则就无意义。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

class Solution {
    public void duplicateZeros(int[] arr) {
        //step1: 统计数组中0的个数，方便看虚拟数组到底有多长
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0)
                zeroCount++;
        }
        int read = arr.length - 1;
        int write = arr.length + zeroCount - 1;
        //step2:从后往前遍历数组，先扫读指针，再扫写指针
        while (read >= 0 && write >= 0) {
            if (arr[read] != 0) {//遇到非0元素直接复制
                if (write < arr.length) {
                    arr[write] = arr[read];
                }
                write--;
                read--;
            } else {//遇到0需要复制0元素，且复制两次

                //复制第一个零，判断write是否指向真实的数组中
                if (write < arr.length){
                    arr[write] = 0;
                }
                write--;

                //复制第二个零，再次判断write是否指向真实的数组中
                if (write < arr.length){
                    arr[write] = 0;
                }
                write--;
                read--;
            }
        }
    }
