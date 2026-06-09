package ZuoVideo63;

import java.io.*;
import java.util.Arrays;

//测试链接:https://www.luogu.com.cn/problem/P4799#ide
public class Code02_Luogu4799 {
    public static int MAXN = 40;
    public static long[] money = new long[MAXN];
    public static long[] left = new long[1<<(MAXN/2)];
    public static long[] right = new long[1<<(MAXN/2)];
    public static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;
            in.nextToken();
            m = (int)in.nval;
            for(int i=0;i<n;i++){
                in.nextToken();
                money[i] = (long) in.nval;
            }
        }

    }
    public static int dfs(int s,int e,int[] ans,int sum,int ansIndex){
//        if(s == e){
//            ans[ansIndex++] = sum;
//            return ansIndex;
//        }
//        int updateIndex = dfs(s + 1, e, ans, sum, ansIndex);
//        dfs(s+1,e,ans,sum + money[s],updateIndex);
        return 0;
    }

}
