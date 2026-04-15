package ZuoVideo55;

//测试链接:https://leetcode.cn/problems/max-value-of-equation/description/
public class Code02_Solution1499 {
    public static int MAX_SIZE = (int)1E5+1;
    public static int[][] maxDeque = new int[MAX_SIZE][2];
    public static int h,t;
    public int findMaxValueOfEquation(int[][] points, int k) {
        h=t=0;
        int ans = Integer.MIN_VALUE;
        for(int r= 0;r<points.length;r++){
            //先淘汰掉出界的
            while(h<t && points[r][0] - maxDeque[h][0]>k){
                h++;
            }
            //如果还有答案更新答案
            if(h<t){
                ans = Math.max(ans,points[r][0]+points[r][1]+maxDeque[h][1]-maxDeque[h][0]);
            }
            while (h<t && maxDeque[t-1][1]-maxDeque[t-1][0] <= points[r][1]-points[r][0]){
                t--;
            }
            maxDeque[t][0] = points[r][0];
            maxDeque[t][1]= points[r][1];
            t++;
        }
        return ans;
    }
}
