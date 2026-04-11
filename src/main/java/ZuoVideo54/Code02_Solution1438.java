package ZuoVideo54;

//测试链接:https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class Code02_Solution1438 {
    public static int MAX_SIZE = (int)1e5+1;
    public static int[] maxDeque = new int[MAX_SIZE];
    public static int[] minDeque = new int[MAX_SIZE];
    public static int maxh,maxt,minh,mint;
    public static int longestSubarray(int[] nums, int limit) {
        maxh=maxt=minh=mint=0;
        int ans = 0;
        for(int l=0,r=0;l<nums.length;l++){
            //1.只要满足条件r不断右移
            while(r<nums.length && isSatisfy(nums, limit, r)){
                addNumToDeque(nums,limit,r);
                r++;
            }
            System.out.println("r的值为:"+r+" l的值为:"+l);
            //2.更新结果
            ans = Math.max(ans,r-l);
            //4.出队列
            if(maxDeque[maxh] <= l){
                maxh++;
            }
            if(minDeque[minh] <= l){
                minh++;
            }
        }
        return ans;
    }

    private static boolean isSatisfy(int[] nums, int limit, int r) {
        if(maxt==maxh &&mint==minh){
            return true;
        }
        int max = maxh<maxt ? Math.max(nums[maxDeque[maxh]],nums[r]) : nums[r];
        int min = minh<mint ? Math.min(nums[minDeque[minh]],nums[r]) : nums[r];
        return max-min<=limit;
    }

    public static void addNumToDeque(int[] nums,int limit,int index){
        //更新最大值
        while (maxh<maxt && nums[index]>=nums[maxDeque[maxt-1]]){
            maxt--;
        }
        maxDeque[maxt++] = index;
        //更新最小值
        while (minh<mint && nums[index]<=nums[minDeque[mint-1]]){
            mint--;
        }
        minDeque[mint++] = index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,2,4,7};
        System.out.println(longestSubarray(nums,4));
    }
}
