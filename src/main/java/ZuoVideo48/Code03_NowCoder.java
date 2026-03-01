package ZuoVideo48;

import java.io.*;

//测试链接:https://www.nowcoder.com/practice/50e1a93989df42efb0b1dec386fb4ccc
public class Code03_NowCoder {
    public static int row,col,q;
    public static int MAX_ROW = 1000+2;
    public static int MAX_COL = 1000+2;
    public static long[][] arr = new long[MAX_ROW][MAX_COL];
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out  = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != -1){
            row=(int)in.nval;in.nextToken();
            col=(int)in.nval;in.nextToken();
            q=(int)in.nval;in.nextToken();
            for(int i=1;i<=row;i++){
                for(int j=1;j<=col;j++){
                    in.nextToken();
                    add(i,j,i,j,(int)in.nval);
                }
            }
            for(int i=0,lx,ly,rx,ry,v;i<q;i++){
                lx=(int)in.nval;in.nextToken();
                ly=(int)in.nval;in.nextToken();
                rx=(int)in.nval;in.nextToken();
                ry=(int)in.nval;in.nextToken();
                v =(int)in.nval;in.nextToken();
                add(lx,ly,rx,ry,v);
            }
            build();
            for(int i=1;i<=row;i++){
                for(int j=1;j<=col;j++){
                    out.print(arr[i][j]+" ");
                }
                out.println();
            }
            clear();
        }
        out.flush();
        out.close();
        br.close();

    }
    public static void add(int lx,int ly,int rx,int ry,int v){
        arr[lx][ly] += v;
        arr[rx+1][ly] -= v;
        arr[lx][ry+1] -= v;
        arr[rx+1][ry+1] += v;
    }
    public static void build(){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                arr[i][j] += arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
            }
        }
    }
    public static void clear(){
        for(int i=1;i<=row+1;i++){
            for(int j=1;j<=col+1;j++){
                arr[i][j]=0;
            }
        }
    }
}
