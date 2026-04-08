package ZuoVideo53;

import java.io.*;

//测试链接:https://www.nowcoder.com/practice/77199defc4b74b24b8ebf6244e1793de
public class Code03_nowcoder {
    public static int MAX_SIZE = (int)1E5+1;
    public static int[] arr = new int[MAX_SIZE];
    public static int n;
    public static int[][] stack = new int[MAX_SIZE][2];
    public static int sLen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;in.nextToken();
            for(int i=0;i<n;i++){
                arr[i] = (int)in.nval;
                in.nextToken();
            }
            out.println(calculate());
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int calculate(){
        sLen = 0;
        for(int i=n-1,curTurn;i>=0;i--){
            curTurn = 0;
            while(sLen>0 && arr[i] > stack[sLen-1][0] ){
                //这里要出去
                curTurn = Math.max(curTurn+1,stack[sLen-1][1]);
                sLen--;
            }
            stack[sLen][0] = arr[i];
            stack[sLen][1] = curTurn;
            sLen++;
        }
        int ans = 0;
        for(int i=0;i<sLen;i++){
            ans = Math.max(ans,stack[i][1]);
        }
        return ans;
    }
}
