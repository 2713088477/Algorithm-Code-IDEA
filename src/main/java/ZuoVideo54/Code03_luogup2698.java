package ZuoVideo54;

import java.io.*;

public class Code03_luogup2698 {
    public static int MAX_SIZE = (int)1e5+1;
    public static int[][] narr = new int[MAX_SIZE][2];
    public static int n;
    public static int d;
    //构建两个队列，方便地获取滑动窗口中的最大值和最小值
    public static int[] maxDeque = new int[MAX_SIZE];
    public static int[] minDeque = new int[MAX_SIZE];
    public static int maxh,maxt,minh,mint;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        maxh=maxt=minh=mint=0;
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;in.nextToken();
            d = (int)in.nval;in.nextToken();
            for(int i=0;i<n;i++){
                narr[i][0] = (int)in.nval;in.nextToken();
                narr[i][1] = (int)in.nval;in.nextToken();
            }
            out.println(f());
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int f(){
        for(int l=0,r=0;l<n;l++){
            while(r<n && ){
                r++;
            }
        }

    }
    public static boolean isOk(){

    }
}
