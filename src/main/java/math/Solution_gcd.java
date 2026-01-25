package math;

import java.math.BigInteger;

public class Solution_gcd {
    public int nthMagicalNumber(int n, int a, int b) {
        long lcm = lcm(a,b);
        long ans=0;
        for(long l=2,r=(long)n*Math.min(a,b);l<=r;){
            long m = l +(r-l)/2;
            if(m/a+m/b-m/lcm>=n){
                ans = m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return (int)(ans%1000000007);
    }
    public long gcd(long m,long n){return n==0 ? m:gcd(n,m%n);}
    public long lcm(long m,long n){return m/gcd(m,n)*n;}
}
