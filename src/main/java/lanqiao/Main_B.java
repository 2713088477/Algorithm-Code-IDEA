package lanqiao;

public class Main_B {
    public static long MAX_SIZE = 20269876543210L;
    public static long total = 2*MAX_SIZE;
    public static long mod = 998244353l;

    public static void main(String[] args) {
//        int count = 0;//6367083
//        for(long num = 1L;num*num<=total;num++){
//            count++;
//        }
//        System.out.println(count);
        long base = 2;
        long ans = 0;
        long cur;
        for(int i=0;i<6367083;i++){
            cur = (base%mod + (2*i)%mod+1)%mod;
            ans += cur;
            base = cur;
        }
        System.out.println(ans%mod);
    }


}
