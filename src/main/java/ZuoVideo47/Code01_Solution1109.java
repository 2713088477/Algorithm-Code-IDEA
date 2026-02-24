package ZuoVideo47;

//测试链接:https://leetcode.cn/problems/corporate-flight-bookings/description/
public class Code01_Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+2];//下标从1开始，差分数组需要设置n+1
        for (int[] book : bookings) {
            diff[book[0]] += book[2];
            diff[book[1]+1] -= book[2];
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i]+=diff[i-1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=diff[i+1];
        }
        return ans;
    }
}
