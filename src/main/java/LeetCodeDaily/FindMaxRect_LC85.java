package LeetCodeDaily;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindMaxRect_LC85 {
    public int maximalRectangle(char[][] matrix) {
        int ans = Integer.MIN_VALUE;
        int[] heights=new int[matrix[0].length];
        for(char[] mtx:matrix){
            for (int i = 0; i < mtx.length; i++) {
                if(mtx[i]=='1') heights[i]++;
                else heights[i]=0;
            }
            ans=Math.max(ans,f(heights));
        }
        return ans;
    }
    public int f(int[] heights){
        int ans=Integer.MIN_VALUE;
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<=heights.length;i++){
            int curHeight = i==heights.length?-1:heights[i];
            while(!stack.isEmpty() && curHeight < heights[stack.peekFirst()] ){
                int height=heights[stack.removeFirst()];
                int left=stack.isEmpty()?-1:stack.peekFirst();
                int right=i;
                ans=Math.max(ans,height*(right-left-1));
            }
            if(i<heights.length){
                stack.addFirst(i);
            }
        }
        return ans;
    }
}
