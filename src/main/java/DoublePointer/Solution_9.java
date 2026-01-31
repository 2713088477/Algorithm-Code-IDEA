package DoublePointer;

public class Solution_9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x) {
        int offset = 1;
        while(x/offset>=10){
            offset *= 10;
        }
        while(x>0){
            if(x/offset != x %10){
                return false;
            }
            x%=offset;x/=10;
            offset /= 100;
        }
        return true;
    }
}
