package LeetCodeDaily;

import java.util.Arrays;

public class Solution_762 {
    static boolean isPrim[];
    static {
        isPrim = new boolean[33];
        Arrays.fill(isPrim,true);
        //0和1不是质数
        isPrim[0]=false;isPrim[1]=false;
        for(int i=2;i<=32;i++){
            for(int j=i;i*j<=32;j++){
                isPrim[i*j]=false;
            }
        }
    }
    public int countPrimeSetBits(int left, int right) {
        int ans =0;
        for(int num=left;num<=right;num++){
            int count = 0;
            int t=num;
            while(t !=0){
                t = t&(t-1);
                count++;
            }
            if(isPrim[count]) ans++;
        }
        return ans;
    }
    public static void main(String[] args) {
        for (int i = 0; i < isPrim.length; i++) {
            System.out.println(i + " "+(isPrim[i] ?"质数":"不是质数"));
        }
    }
}
