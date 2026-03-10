package ZuoVideo66;

import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/fibonacci-number/description/
public class Code01_Solution509 {
    //F(0)=0,F(1)=1
    //F(n)=F(n-1)+F(n-2)
    //0<=n<=20

    //step1:经典递归
    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    //step:2发现大量的重复计算，可以用缓存表记录对应的数值
    public static int MAX_SIZE = 31;
    //用一个缓存表记录
    public static int[] ans = new int[MAX_SIZE];
    static {
        //用一个不可能的值作为初始值,代表没有计算过
        Arrays.fill(ans,-1);
        ans[0]=0;ans[1]=1;
    }
    public int fib2(int n){
        if(ans[n]!=-1) return ans[n];
        ans[n]=fib2(n-1)+fib2(n-2);
        return ans[n];
    }

    //step1:存在大量的重复计算,step2:也是自定向下的,由于递归的存在所需要的栈空间也更多
    //step3:自下而上,减少递归的栈空间
    public int fib3(int n){
        int[] arr = new int[n+2];//这里也应该用静态空间,这里与step2以示区分
        arr[0]=0;arr[1]=1;
        for(int i=2;i<arr.length;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    //step4:step3需要的辅助空间太多,而每个arr[i]只依赖于arr[i-1]和arr[i-2],所以我们使用迭代减少空间消耗
    public int fib4(int n){
        int lastlast =0,last=1;
        if(n==0) return lastlast;
        if(n==1) return last;
        for(int i=2,curSum=0;i<=n;i++){
            curSum=lastlast+last;
            lastlast=last;
            last=curSum;
        }
        return last;
    }
}
