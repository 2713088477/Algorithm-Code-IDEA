package ZuoVideo49;

//测试链接:https://leetcode.cn/problems/gas-station/
public class Code04_Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for(int l=0,r=0,sum;l<len;l=r+1,r=l){
            sum = 0;
            while (sum+gas[r%len]-cost[r%len]>=0){
                if(r-l+1 == gas.length) return l;
                sum += gas[r%len]-cost[r%len];
                r++;
            }
        }
        return -1;
    }
}
