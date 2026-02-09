package LeetCodeDaily;

public class Solution_1653 {
    // aababbab
    // bbaaaaabb
    public int minimumDeletions(String s) {
        char[] array = s.toCharArray();
        int totalA =0;
        for (char c : array) {
            if (c == 'a') {
                totalA++;
            }
        }
        int ans = totalA;
        int countA=0,countB=0;
        for(int i=0;i< array.length;i++){
            if(array[i]=='b') countB++;
            else countA++;
            ans = Math.min(ans,countB+totalA-countA);
        }
        return ans;
    }
}
