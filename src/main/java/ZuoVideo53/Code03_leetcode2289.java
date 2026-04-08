package ZuoVideo53;

import java.io.*;

//测试链接:https://leetcode.cn/problems/steps-to-make-array-non-decreasing/
public class Code03_leetcode2289 {
    public static int MAX_SIZE = (int)1E5+1;
    public static int[][] stack = new int[MAX_SIZE][2];
    public static int sLen;
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int ans = 0;
        sLen = 0;
        //栈是小压大
        for(int i=n-1,curTurn;i>=0;i--){
            curTurn = 0;
            while(sLen>0 && nums[i] > stack[sLen-1][0]){
                curTurn = Math.max(curTurn+1,stack[sLen-1][1]);
                sLen--;
            }
            stack[sLen][0] = nums[i];
            stack[sLen][1] = curTurn;
            sLen++;
            ans = Math.max(ans,curTurn);
        }
        return ans;
    }
}
