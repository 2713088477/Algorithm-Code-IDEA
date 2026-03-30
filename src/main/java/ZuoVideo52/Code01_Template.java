package ZuoVideo52;

import java.io.*;

//单调栈模板题
//测试链接:https://www.nowcoder.com/practice/2a2c00e7a88a498693568cef63a4b7bb
public class Code01_Template {
    public static int MAX_SIZE = (int) 1E6+1;
    public static int[] arr = new int[MAX_SIZE];
    public static int[] stack = new int[MAX_SIZE];
    public static int[][] ans = new int[MAX_SIZE][2];
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;in.nextToken();
            for(int i=0;i<n;i++){
                arr[i] = (int)in.nval;in.nextToken();
            }
            f();
            for(int i=0;i<n;i++){
                System.out.println(ans[i][0]+" "+ans[i][1]);
            }
        }
        out.close();
        br.close();
    }
    public static void f(){
        int top = 0,index;
        //所有元素入栈,大压小
        for(int i=0;i<n;i++){
            //如果不满足大压小
            while(top>0 && arr[i]<=arr[stack[top-1]]){
                index = stack[--top];
                ans[index][0] = top==0?-1:stack[top-1];
                ans[index][1] = i;
            }
            stack[top++] = i;
        }
        //清算
        while(top>0){
            index = stack[--top];
            ans[index][0] = top==0?-1:stack[top-1];
            ans[index][1] = -1;
        }
        //更新重复值的答案
        for(int i=n-1;i>=0;i--){
            if(ans[i][1]!=-1 && arr[ans[i][1]] == arr[i]){
                ans[i][1] = ans[ans[i][1]][1];
            }
        }
    }
}
