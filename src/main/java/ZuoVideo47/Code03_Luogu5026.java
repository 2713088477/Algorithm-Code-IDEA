package ZuoVideo47;

import java.io.*;

//测试链接:https://www.luogu.com.cn/problem/P5026
public class Code03_Luogu5026 {
    public static int OFFSET = 30000;
    public static int MAX_SIZE = OFFSET+1000000+OFFSET;
    public static int[] arr = new int[MAX_SIZE];
    public static int n,m,v,x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n=(int) in.nval; in.nextToken();
            m=(int) in.nval; in.nextToken();
            for (int i = 0; i < n; i++) {
                v=(int) in.nval; in.nextToken();
                x=(int) in.nval; in.nextToken();
                solve(v,x);
            }
        }
        build();
        for(int i=OFFSET+1;i<=OFFSET+m;i++){
            out.print(arr[i]+" ");
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void solve(int v,int x){
        set(x-3*v+1,x-2*v,1,v,1);
        set(x-2*v+1,x,v-1,-v,-1);
        set(x+1,x+2*v,-v+1,v,1);
        set(x+2*v+1,x+3*v,v-1,0,-1);
    }
    public static void set(int l,int r,int s,int e,int d){
        arr[l+OFFSET]+=s;
        arr[l+1+OFFSET]+=d-s;
        arr[r+1+OFFSET]-=d+e;
        arr[r+2+OFFSET]+=e;
    }
    public static void build(){
        for(int i=1;i<=OFFSET+m;i++){
            arr[i]+=arr[i-1];
        }
        for(int i=1;i<=OFFSET+m;i++){
            arr[i]+=arr[i-1];
        }
    }

}
