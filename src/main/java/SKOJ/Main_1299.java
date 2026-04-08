package SKOJ;

import java.io.*;
import java.util.Arrays;


//测试链接:https://oj.saikr.com/problem-set/105/task?problem_id=1299
public class Main_1299 {
    public static int MAX_SIZE = 1100001;
    public static boolean[] isPrime = new boolean[MAX_SIZE];
    static {
        Arrays.fill(isPrime,true);
        isPrime[0] =false;
        isPrime[1] = false;
        for(int i=2;i*i<MAX_SIZE;i++){
            if(isPrime[i]){
                for(int j=i*i;j<MAX_SIZE;j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }
    public static int X,Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            X = (int)in.nval;in.nextToken();
            Y = (int)in.nval;in.nextToken();
            out.println(calculate());
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int calculate(){
        int ans = 0;
        for(int i=X;i<=Y;i++){
            if(isPrime[i])ans++;
        }
        return ans;
    }

}
