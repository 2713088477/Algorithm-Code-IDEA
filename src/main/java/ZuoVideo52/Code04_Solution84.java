package ZuoVideo52;

//测试链接:https://leetcode.cn/problems/largest-rectangle-in-histogram/description/
public class Code04_Solution84 {
    public static int MAX_SIZE = (int)1E5+1;
    public static int[] stack = new int[MAX_SIZE];//存储的是索引
    public static int sLen = 0;
    public static int[][] pos = new int[MAX_SIZE][2];

    public int largestRectangleArea(int[] heights) {
        int len = heights.length,curIndex;
        for(int i=0;i<len;i++){
            while(sLen>0 && heights[i] <= heights[stack[sLen-1]] ){
                curIndex = stack[sLen-1];
                pos[curIndex][1] = i;
                pos[curIndex][0] = sLen-1>0 ? stack[sLen-2]:-1;
                sLen--;
            }
            stack[sLen++] = i;
        }
        while(sLen>0){
            curIndex = stack[sLen-1];
            pos[curIndex][1] = len;
            pos[curIndex][0] = sLen-1>0 ? stack[sLen-2]:-1;
            sLen--;
        }
        int ans = 0;
        for(int i=0;i<len;i++){
            ans = Math.max(ans,(pos[i][1]-pos[i][0]-1)*heights[i]);
        }
        return ans;
    }
}
