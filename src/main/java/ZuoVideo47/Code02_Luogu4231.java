package ZuoVideo47;

import java.io.*;
//测试链接:https://www.luogu.com.cn/problem/P4231
public class Code02_Luogu4231 {
    public static long[] arr= new long[10000000+3];
    public static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n = (int)in.nval;in.nextToken();
            int m = (int)in.nval;in.nextToken();
            int l,r,s,e;
            for(int i=0;i<m;i++){
                l = (int)in.nval;in.nextToken();
                r = (int)in.nval;in.nextToken();
                s = (int)in.nval;in.nextToken();
                e = (int)in.nval;in.nextToken();
                set(l,r,s,e,(e-s)/(r-l));
            }
            build();
            long ans=0,max=0;
            for(int i=1;i<=n;i++){
                max=Math.max(max,arr[i]);
                ans ^= arr[i];
            }
            out.println(ans+" "+max);
        }
        out.flush();
        out.close();
        br.close();

    }
    public static void set(int l,int r,int s,int e,int d){
        arr[l]+=s;
        arr[l+1]+=d-s;
        arr[r+1]-=d+e;
        arr[r+2]+=e;
    }
    public static void build(){
        for(int i=1;i<=n;i++){
            arr[i]+=arr[i-1];
        }
        for(int i=1;i<=n;i++){
            arr[i]+=arr[i-1];
        }
    }
}
