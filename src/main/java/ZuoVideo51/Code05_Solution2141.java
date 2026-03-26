package ZuoVideo51;

//测试链接:https://leetcode.cn/problems/maximum-running-time-of-n-computers/
public class Code05_Solution2141 {
    public long maxRunTime(int n, int[] batteries) {
        long l =0, r=0;//因为对batteries求和可能超出long范围
        for (int battery : batteries) {
            r += battery;
        }
        long mid =0;
        long ans = 0;
        while(l<r){
            mid = l+((r-l)>>2);
            if(f(n,batteries,mid)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
    public boolean f(int n, int[] batteries,long answer){
        long sum = 0 ;
        for (int battery : batteries) {
            if(battery >= answer){
                n--;
            }else{
                sum += battery;
            }
        }
        return sum >= n *answer;
    }
}
