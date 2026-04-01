package CF;

import java.io.*;

//测试连接:https://codeforces.com/contest/2201/problem/A2
//数据结构:单调栈
//这个还超时,主播哭了😤
public class Main_20260331_2 {
    public static int MAX_SIZE = (int)3e5+1;
    public static int n;
    public static int[] arr = new int[MAX_SIZE];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            int tnum = (int)in.nval;in.nextToken();
            while(tnum-->0){
                n = (int)in.nval;in.nextToken();
                for(int i=0;i<n;i++){
                    arr[i] = (int)in.nval;in.nextToken();
                }
                out.println(f());
            }
        }
        out.flush();
        out.close();
        br.close();
    }
    //这里尝试一下用静态空间来替代这个Deque
    public static int[] stack = new int[MAX_SIZE];
    public static int sLen =0;
    public static long f(){
        long[] dp = new long[n];
        for(int i=n-1;i>=0;i--){
            //这个位置至少有的数字
            dp[i] = n-i;
            sLen = 0;
            //需要找到加哪个
            stack[sLen++] = arr[i];
            for(int j=i+1;j<n;){
                if(arr[j] == stack[sLen-1]+1 || arr[j] > arr[i] && arr[j]<=stack[sLen-1]){
                    stack[sLen++] = arr[j++];
                }else{
                    dp[i] += dp[j];
                    break;
                }
            }
        }
        long ans =0;
        for(int i=0;i<n;i++){
            ans += dp[i];
        }
        return ans;

    }

}


