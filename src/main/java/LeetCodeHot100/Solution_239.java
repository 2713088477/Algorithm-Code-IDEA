package LeetCodeHot100;


import java.util.PriorityQueue;

//测试链接:https://leetcode.cn/problems/sliding-window-maximum/?envType=study-plan-v2&envId=top-100-liked
public class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len-k+1];
        int index=0;
        //heap中存储的数组,arr[0]表示数字的大小,arr[1]表示数字出现的最后一次下标
        PriorityQueue<int[]> heap = new PriorityQueue<>((arr1,arr2)->{
            return arr1[0]==arr2[0] ?Integer.compare(arr2[1],arr1[1]) : Integer.compare(arr2[0],arr1[0]);
        });
        for(int i=0;i<k;i++){
            heap.offer(new int[]{nums[i],i});
        }
        ans[index++] = heap.peek()[0];
        for(int i=k;i<len;i++){
            heap.offer(new int[]{nums[i],i});
            while(heap.peek()[1]<=i-k){
                heap.poll();
            }
            ans[index++] = heap.peek()[0];
        }
        return ans;

    }
}
