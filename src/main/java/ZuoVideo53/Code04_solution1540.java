package ZuoVideo53;

import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/count-submatrices-with-all-ones/description/
public class Code04_solution1540 {
    public static int MAX_SIZE = 151;
    public static int[] stack = new int[MAX_SIZE];
    public static int sLen;
    public static int[] height = new int[MAX_SIZE];
    public static int row,col;
    public int numSubmat(int[][] mat) {
        row = mat.length;col=mat[0].length;
        Arrays.fill(height,0);
        int ans = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //二维转为一维
                height[j] = mat[i][j]==1?height[j]+1:0;
            }
            ans += countTheBottom();

        }
        return ans;
    }
    public static int countTheBottom(){
        int ans = 0;
        sLen = 0;
        int curIndex = 0,left,right,minH,maxH;
        for(int i=0;i<col;i++){
            while(sLen>0 && height[i] <= height[stack[sLen-1]]){
                curIndex = stack[sLen-1];
                if(height[i]<height[curIndex]){
                    right = i;
                    left = sLen-1>0?stack[sLen-2]:-1;
                    maxH = height[curIndex];
                    minH = Math.max(left==-1?0:height[left],right==col?0:height[right])+1;
                    ans += (maxH-minH+1)*((right-left-1)*(right-left)/2);
                }
                sLen--;
            }
            stack[sLen++] = i;
        }
        while(sLen>0){
            curIndex = stack[sLen-1];
            right = col;
            left = sLen-1>0?stack[sLen-2]:-1;
            maxH = height[curIndex];
            minH = Math.max(left==-1?0:height[left],right==col?0:height[right])+1;
            ans += (maxH-minH+1)*((right-left-1)*(right-left)/2);
            sLen--;
        }
        return ans;
    }
}
