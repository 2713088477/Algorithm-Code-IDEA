package ZuoVideo50;

//测试链接:https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
public class Code03_Solution42 {

    //原始的思路与想法
    //来到一个index,当前位置能接到的雨水为: Math.max(Math.min(左侧的最大高度,右侧的最大高度)-当前高度,0)
    public int trap1(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax= new int[len];
        leftMax[0] = 0;rightMax[len-1]=0;
        for(int i=1;i<len;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }
        for(int i=len-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }
        int ans = 0;
        for(int i=0;i<len;i++){
            ans += Math.max(Math.min(leftMax[i],rightMax[i])-height[i],0);
        }
        return ans;
    }

    //双指针优化版
    //l-r遍历: l=1,r=len-2(0位置和最后一个位置一定没有雨水)
    //lmax = height[0],rmax=height[len-1];
    //如果lmax<rmax >> l位置上的雨水就可以确定下来: Math.max(lmax-当前高度,0)
    //如果lmax>rmax >> r位置上的雨水就可以确定下来: Math.max(rmax-当前高度,0)
    //如果lmax=rmax >> l,r位置上的雨水都可以确定下来
    //不断更新,直到所有都遍历到
    public int trap2(int[] height) {
        int len = height.length;
        int l=1,r=len-2,lmax=height[0],rmax=height[len-1];
        int ans = 0;
        while(l<=r){
            if(lmax<=rmax){
                ans += Math.max(lmax-height[l],0);
                lmax = Math.max(lmax,height[l++]);
            }else{
                ans += Math.max(rmax-height[r],0);
                rmax = Math.max(rmax,height[r--]);
            }
        }
        return ans;
    }
}
