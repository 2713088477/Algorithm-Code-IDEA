package ZuoVideo51;

//测试链接:https://leetcode.cn/problems/koko-eating-bananas/
public class Code01_Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1,r=0;
        for(int pile:piles){
            r = Math.max(r,pile);
        }
        //r右侧都是达标的
        int mid;
        while(l<=r){
            mid = l + ((r-l)>>1);
            if(f(piles,mid)<=h){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return r+1;
    }
    public long f(int[] piles,int speed){
        long ans = 0;
        for (int pile : piles) {
            ans += (pile+speed-1)/speed;
        }
        return ans;
    }

}
