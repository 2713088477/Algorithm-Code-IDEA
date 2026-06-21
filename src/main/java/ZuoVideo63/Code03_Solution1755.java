package ZuoVideo63;

import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/closest-subsequence-sum/description/
public class Code03_Solution1755 {
    public static int MAX_LEN = 1<<20;
    public static int[] numsArr;
    public static int[] lRes = new int[MAX_LEN];
    public static int[] rRes = new int[MAX_LEN];
    public static int minAbsDifference(int[] nums, int goal) {
        numsArr = nums;
        int positive = 0,negative = 0;
        for(int num:nums){
            if(num>=0)positive+=num;
            else negative+=num;
        }
        if(positive<=goal){
            return Math.abs(goal-positive);
        }
        if(negative>=goal){
            return Math.abs(goal-negative);
        }
        Arrays.sort(nums);
        int mid = nums.length>>1;
        int lLen = f(lRes, 0, mid, 0, 0, 0);
        int rLen = f(rRes, mid, nums.length, 0, mid, 0);
        Arrays.sort(lRes,0,lLen);
        Arrays.sort(rRes,0,rLen);
        int ans = Integer.MAX_VALUE;
        int left =0,right = rLen-1;
        for(;left<lLen;left++){
            while(right>0 && Math.abs(goal-(lRes[left]+rRes[right])) >= Math.abs(goal-(lRes[left]+rRes[right-1])) ){
                right--;
            }
            ans = Math.min(ans,Math.abs(goal-(lRes[left]+rRes[right])));

        }
        return ans;

    }
    public static int f(int[] ansArr,int start,int end,int curSum,int curIndex,int ansLen){
        if(curIndex==end){
            ansArr[ansLen++] = curSum;
            return ansLen;
        }
        int nextIndex = curIndex+1;
        while (nextIndex<end && numsArr[nextIndex]==numsArr[curIndex]){
            nextIndex++;
        }
        for(int i=0;i<=nextIndex-curIndex;i++){
            ansLen = f(ansArr,start,end,curSum+i*numsArr[curIndex],nextIndex,ansLen);
        }
        return ansLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,-7,3,5};
        minAbsDifference(nums,6);

    }
}
