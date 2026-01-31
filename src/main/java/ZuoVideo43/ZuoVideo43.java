package ZuoVideo43;

public class ZuoVideo43 {
    public int superpalindromesInRange(String left, String right) {
        long lnum = Long.valueOf(left),rnum = Long.valueOf(right);
        long limit = (long) Math.sqrt(rnum);
        long seed = 1;
        long num =0;
        int ans = 0;
        do{
            num = createDouble(seed);
            if(check(num*num,lnum,rnum)){
                ans++;
            }
            num = createSingle(seed);
            if(check(num*num,lnum,rnum)){
                ans++;
            }
            seed ++;
        }while (num<=limit);
        return ans;
    }
    private boolean check(long num,long l,long r){
        return num>=l && num<=r && isPalindRome(num);
    }
    private long createSingle(long seed) {
        long ans = seed;
        seed /= 10;
        while(seed != 0){
            ans = ans*10 + seed %10;
            seed/=10;
        }
        return ans;
    }
    private long createDouble(long seed) {
        long ans = seed;
        while(seed != 0){
            ans = ans*10+seed%10;
            seed/=10;
        }
        return ans;
    }
    private boolean isPalindRome(long num) {
        long offset = 1;
        while (num/offset>=10) offset *= 10;
        while(num !=0){
            if(num/offset != num%10){
                return false;
            }
            num = (num%offset)/10;
            offset /= 100;
        }
        return true;
    }
}
