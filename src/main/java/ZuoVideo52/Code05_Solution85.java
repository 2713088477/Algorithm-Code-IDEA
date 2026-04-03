package ZuoVideo52;


//测试链接:https://leetcode.cn/problems/maximal-rectangle/
public class Code05_Solution85 {
    public static int rowLen,colLen;
    public static int MAX_SIZE = 201;
    public static int[] height = new int[MAX_SIZE];
    public int maximalRectangle(char[][] matrix) {
        rowLen = matrix.length;colLen = matrix[0].length;
        int ans = 0;
        for(int r = 0;r < rowLen;r++){
            for (int c = 0;c < colLen;c++){
                height[c] = matrix[r][c] == '1' ? height[c]+1 :0;
            }
            ans = Math.max(ans,f());
        }
        clear();
        return ans;
    }
    //这里利用单调栈去处理
    public static int[] stack = new int[MAX_SIZE];
    public static int sLen = 0;
    public static int[][] pos = new int[MAX_SIZE][2];
    public static int f(){
        int curIndex = 0;
        for(int c = 0;c<colLen;c++){
            while(sLen>0 && height[c] <= height[stack[sLen-1]]){
                curIndex = stack[sLen-1];
                pos[curIndex][0] = sLen-1>0?stack[sLen-2]:-1;
                pos[curIndex][1] = c;
                sLen--;
            }
            stack[sLen++] = c;
        }
        while(sLen>0){
            curIndex = stack[sLen-1];
            pos[curIndex][0] = sLen-1>0?stack[sLen-2]:-1;
            pos[curIndex][1] = colLen;
            sLen--;
        }
        int ans = 0;
        for(int i=0;i<colLen;i++){
            ans = Math.max(ans,(pos[i][1]-pos[i][0]-1)*height[i]);
        }
        return ans;
    }
    public static void clear(){
        for(int i=0;i<colLen;i++){
            height[i] = 0;
        }
    }
}
