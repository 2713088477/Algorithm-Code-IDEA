package ZuoVideo51;

//测试链接:https://leetcode.cn/problems/split-array-largest-sum/
public class Code02_Solution410 {
    public int splitArray(int[] nums, int k) {
        int l = 0,r=0;
        for(int num:nums){
            r += num;
        }
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            int nk = f(nums,mid);
            if(nk<=k){
                //满足
                ans = mid;
                r =mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public static int f(int[] nums,int v){
        int container = 0;
        int ans =1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>v) return Integer.MAX_VALUE;
            if(container + nums[i] <= v){
                container += nums[i];
            }else{
                container = nums[i];
                ans ++;
            }
        }
        return ans;
    }
}
