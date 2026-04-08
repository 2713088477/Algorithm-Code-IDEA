package SKOJ;

import java.io.*;

//测试连接:https://oj.saikr.com/problem-set/105/task?problem_id=1300
public class Main_1300 {
    public static int p,q,r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            p = (int)in.nval;in.nextToken();
            q = (int)in.nval;in.nextToken();
            r = (int)in.nval;in.nextToken();
            out.println(f());
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int f(){
        int l = 2,r=16;
        for(int i=l;i<=r;i++){
            if(isOk(i)) return i;
        }
        return 0;
    }
    public static boolean isOk(int b){
        return convert(q,b)*convert(p,b)==convert(r,b);
    }
    public static int convert(int num,int b){
        //将一个b进制的num -> 十进制的num
        int ans = 0;
        int index = 0;
        while(num!=0){
            ans += (num%10) * myPow(b,index);
            index++;
            num /= 10;
        }
        return ans;

    }
    public static int myPow(int basis,int r){
        int ans = 1;
        for(int i=0;i<r;i++){
            ans *= basis;
        }
        return ans;
    }
}
