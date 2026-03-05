package LeetCodeHot100;

public class Solution_1758 {
    public static int minOperations(String s) {
        int ans1 = count(s,true);
        int ans2 = count(s,false);
        return Math.min(ans1, ans2);
    }
    public static int count(String s , boolean startWithZero){
        char start = startWithZero?'0':'1';
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=start) ans ++;
            if(start=='0')start='1';
            else if(start=='1')start='0';
        }
        return ans;
    }

}
