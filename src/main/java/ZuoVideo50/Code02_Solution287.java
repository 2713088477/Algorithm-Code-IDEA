package ZuoVideo50;

//测试链接:https://leetcode.cn/problems/find-the-duplicate-number/description/
public class Code02_Solution287 {
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]],slow=nums[0];
        while (fast != slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast=0;
        while (fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
