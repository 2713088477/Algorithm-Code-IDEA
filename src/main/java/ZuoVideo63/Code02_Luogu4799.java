package ZuoVideo63;


import java.io.*;
import java.util.Arrays;
import java.util.StringJoiner;

//测试链接:https://www.luogu.com.cn/problem/P4799#ide
public class Code02_Luogu4799 {
    public static int MAXN = 40;
    public static long[] lRes = new long[1 << (MAXN / 2)];
    public static long[] rRes = new long[1<<(MAXN/2)];
    public static int n;
    public static long[] nArr = new long[MAXN];
    public static long m;

    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;
            in.nextToken();
            m = (long) in.nval;
            for(int i=0;i<n;i++){
                in.nextToken();
                nArr[i] = (long) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        out.close();
        br.close();
    }
    public static long compute(){
        int mid = n>>1;
        int lSize = f(0,mid,0L,m,lRes,0);
        int rSize = f(mid,n,0L,m,rRes,0);
        Arrays.sort(lRes,0,lSize);
        Arrays.sort(rRes,0,rSize);

        long ans = 0;
        int l = 0, r = n-1;
        while(l<lSize){
            while(r>=0 && lRes[l]+rRes[r]>m){
                r--;
            }
            ans += r+1;
            l++;
        }
        return ans;
    }
    public static int f(int s,int e,long sum,long total,long[] res,int j){
        if(sum > total) return j;
        if(s == e){
            res[j++] = sum;
        }else{
            j = f(s+1,e,sum,total,res,j);
            j = f(s+1,e,sum+nArr[s],total,res,j);
        }
        return j;

    }


}
