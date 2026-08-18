package LeetCode;

//测试链接:https://leetcode.cn/problems/nth-magical-number/description/
//todo: WA
public class Solution_878 {
    private static int mod = (int)1e9+7;
    public int nthMagicalNumber(int n, int a, int b) {
        int lcm = lcm(a, b);
        long l = Math.min(a, b),r = Math.min(a, b)*n;
        while(l<=r){
            long mid = l + (r-l)/2;
            if(mid/a+mid/b-mid/lcm >= n){
                r = mid - 1;
            }else{
                l = mid + 1;
            }

        }
        return (int)((r+1)%mod);
    }
    public int gcd(int a,int b){return b==0 ? a : gcd(b, a%b);}
    public int lcm(int a,int b){return a/gcd(a, b)*b;};

}
