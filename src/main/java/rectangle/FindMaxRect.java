package rectangle;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindMaxRect {
    public int largestRectangleArea1(int[] heights) {
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int height=heights[i];
            int left=i,right=i;
            //left指向最左边的矩形
            for(left=i;left>=0;){
                if(heights[left]>=height)left--;
                else break;
            }
            //if(left==-1)left++;
            //right指向最右边的矩形
            for(right=i;right<heights.length;){
                if(heights[right]>=height) right++;
                else break;
            }
            //if(right==heights.length)right--;
            ans=Math.max(ans,(right-left-1)*height);
            //System.out.println(ans+" "+left+" "+right);
        }
        return ans;
    }
    //单调栈实现
    public int largestRectangleArea2(int[] heights){
        Deque<Integer> stack = new ArrayDeque<>();//存储索引
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i <= heights.length;i++) {
            int curHeight= i==heights.length ? -1: heights[i];
            while (!stack.isEmpty() && curHeight < heights[stack.peekFirst()]){
                int height = heights[stack.removeFirst()];
                int left = stack.isEmpty()?-1:stack.peekFirst();
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
