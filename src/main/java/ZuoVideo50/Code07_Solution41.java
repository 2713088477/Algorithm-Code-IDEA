package ZuoVideo50;

//测试链接:https://leetcode.cn/problems/first-missing-positive/
public class Code07_Solution41 {
    //时间复杂度O(n)
    public int firstMissingPositive(int[] nums) {
        //[r...]是垃圾区,r表示可以满足条件的个数
        int l=0,r=nums.length;
        while(l<r){
            if(nums[l]==l+1) l++;
            //这些将nums[l]的位置放到垃圾去中
            else if( nums[l]<l+1 || nums[l] >r || nums[nums[l]-1] == nums[l]){
                swap(nums,l,--r);
            }else{
                //放到其该在的位置上
                swap(nums,l,nums[l]-1);
            }
        }
        return l+1;
    }
    public static void swap(int[] nums,int l,int r){
        if(l==r)return;
        nums[l] = nums[l] ^ nums[r];
        nums[r] = nums[l] ^ nums[r];
        nums[l] = nums[l] ^ nums[r];
    }

}
