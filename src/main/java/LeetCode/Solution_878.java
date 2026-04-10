package LeetCode;

public class Solution_878 {
    public int nthMagicalNumber(int n, int a, int b) {
        long lcmNum = lcm(a,b);
        long l = 2,r = (long)n*Math.min(a,b);
        long mid;
        long ans = 0;
        while(l<=r){
            mid = l + (r-l)/2;
            if(mid/a+mid/b-mid/lcmNum>=n){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return (int)(ans%((int)1e9+7));
    }
    public static long gcd(int m,int n){
        return n==0?m:gcd(n,m%n);
    }
    public static long lcm(int m,int n){
        return m/gcd(m,n)*n;
    }
}
