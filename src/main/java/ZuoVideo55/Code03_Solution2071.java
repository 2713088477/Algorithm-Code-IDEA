package ZuoVideo55;

import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/maximum-number-of-tasks-you-can-assign/
public class Code03_Solution2071 {
    public static int MAX_SIZE = (int)5e4+1;
    public static int[] minDeque = new int[MAX_SIZE];
    public static int h,t;
    public static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int l = 0,r=Math.min(tasks.length,workers.length);
        int ans = 0;
        for(int mid;l<=r;){
            mid = l+((r-l)>>>1);
            if(f(tasks,workers,pills,strength,mid)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
    public static boolean f(int[] tasks,int[] workers,int pills,int strength,int m){
        h=t=0;
        int tl = 0,tr = m-1,wl = workers.length-m,wr=workers.length-1;
        int needPill = 0;
        for(int windex = wl,tindex=tl;windex<=wr;windex++){
            //看看不吃药能解锁多少任务
            while(tindex<=tr && workers[windex]>=tasks[tindex]){
                minDeque[t++] = tasks[tindex++];
            }
            //如果不吃药就能解决一个任务
            if( h<t && workers[windex]>=minDeque[h] ){
                h++;
            }else{
                //看看吃药能解锁多少个任务
                while (tindex<=tr && workers[windex]+strength>=tasks[tindex]){
                    minDeque[t++] = tasks[tindex];
                    tindex++;
                }
                if(h<t){
                    //解决最后一个任务
                    t--;
                    needPill++;
                }else{
                    return false;
                }
            }
        }
        return needPill<=pills;
    }

    public static void main(String[] args) {
        System.out.println(maxTaskAssign(new int[]{3,2,1}, new int[]{0,3,3},1,1));
    }
}
