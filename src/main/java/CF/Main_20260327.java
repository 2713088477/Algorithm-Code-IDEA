package CF;

import java.io.*;
import java.util.*;

//测试连接:https://codeforces.com/contest/2201/problem/A1
//数据结构:单调栈
public class Main_20260327{
    public static int MAX_SIZE = (int)3e5+1;
    public static int n;
    public static int[] arr = new int[MAX_SIZE];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            int tnum = (int)in.nval;in.nextToken();
            while(tnum-->0){
                n = (int)in.nval;in.nextToken();
                for(int i=0;i<n;i++){
                    arr[i] = (int)in.nval;in.nextToken();
                }
                out.println(f());
            }
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int f(){
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(arr[0]);
        int top = arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]==top+1 || (arr[i]>deque.peekFirst()&&arr[i]<=top)){
                deque.addLast(arr[i]);
                top = arr[i];
            }else{
                ans ++;
                while(!deque.isEmpty()){
                    deque.removeLast();
                }
                deque.add(arr[i]);
                top = arr[i];
            }
        }
        if(!deque.isEmpty()) ans += 1;
        return ans;
    }

}


