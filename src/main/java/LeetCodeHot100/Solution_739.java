package LeetCodeHot100;

public class Solution_739 {
    public static int MAX_SIZE = (int)1E5+1;
    public static int[] stack = new int[MAX_SIZE];
    public static int sLen = 0;
    public static int[] pos = new int[MAX_SIZE];
    public int[] dailyTemperatures(int[] temperatures) {
        sLen=0;
        for (int i = 0,curIndex; i < temperatures.length; i++) {
            while (sLen>0 && temperatures[i] > temperatures[stack[sLen-1]]){
                curIndex = stack[sLen-1];
                pos[curIndex] = i-curIndex;
                sLen--;
            }
            stack[sLen++] = i;
        }
        int curIndex = 0;
        while(sLen>0){
            curIndex = stack[sLen-1];
            pos[curIndex] = 0;
            sLen--;
        }
        int[] ans = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            ans[i] = pos[i];
        }
        return ans;
    }
}
