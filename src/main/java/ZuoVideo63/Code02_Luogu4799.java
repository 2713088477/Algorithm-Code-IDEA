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
        long lsize = dfs(0,n>>1,0,0,0);
        long rsize = dfs(n>>1,n,0,n>>1,0);
        System.out.println(Arrays.toString(left));

        System.out.println(Arrays.toString(right));
    }
    public static int dfs(int s,int e,long sum,int curIndex,int ansIndex){
        if(curIndex<s || curIndex>e) return ansIndex;
        if(curIndex == e){
            if(sum <= m){
                left[ansIndex++] = sum;
            }
            return ansIndex;
        }
        ansIndex = dfs(s,e,sum,curIndex+1,ansIndex);
        ansIndex = dfs(s,e,sum+money[curIndex],curIndex+1,ansIndex);
        return ansIndex;
    }

}
