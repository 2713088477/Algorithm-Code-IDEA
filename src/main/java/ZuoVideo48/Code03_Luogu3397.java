package ZuoVideo48;

import java.io.*;
//测试链接:
public class Code03_Luogu3397 {
    public static int MAX_N = 1002;
    public static int[][] arr= new int[MAX_N][MAX_N];
    public static int n, tnum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != -1){
            n =(int)in.nval;in.nextToken();
            tnum =(int)in.nval;in.nextToken();
            for(int i = 0,lx,ly,rx,ry; i< tnum; i++){
                lx=(int)in.nval;in.nextToken();
                ly=(int)in.nval;in.nextToken();
                rx=(int)in.nval;in.nextToken();
                ry=(int)in.nval;in.nextToken();
                add(lx,ly,rx,ry,1);
            }
            build();
            for(int i = 1; i<= n; i++){
                for(int j = 1; j<= n; j++){
                    out.print(arr[i][j]+" ");
                }
                out.println();
            }
        }
        clear();
        out.close();
        br.close();

    }
    public static void add(int lx,int ly,int rx,int ry,int v){
        arr[lx][ly] += v;
        arr[rx+1][ly] -= v;
        arr[lx][ry+1] -= v;
        arr[rx+1][ry+1]+=v;
    }
    public static void build(){
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<= n; j++){
                arr[i][j] += arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
            }
        }
    }
    public static void clear(){
        for(int i = 0; i<= n+1; i++){
            for(int j = 0; j<= n+1; j++){
                arr[i][j]=0;
            }
        }
    }
}
