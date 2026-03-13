package ZuoVideo50;

//测试链接:https://leetcode.cn/problems/sort-array-by-parity-ii/description/
public class Code01_Solution922 {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1;//奇数的起始下标
        int even = 0;//偶数的起始下标
        int index = nums.length-1;
        while(odd<nums.length && even<nums.length){
            if((nums[index] & 1) != 0){
                swap(nums,odd,index);
                odd+=2;
            }else{
                swap(nums,even,index);
                even+=2;
            }
        }
        return nums;
    }
    public static void swap(int[] nums,int i,int j){
        if(i==j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
