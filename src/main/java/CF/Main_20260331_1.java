package CF;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

//测试连接:https://codeforces.com/contest/2201/problem/A2
//数据结构:单调栈
public class Main_20260331_1 {
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
        //枚举所有的子数组
        for(int l=0;l<n;l++){
            for(int r=l;r<n;r++){
                ans += count(l,r);
            }
        }
        return ans;

    }
    public static int count(int l,int r){
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(arr[l]);
        int top = arr[l];
        for(int i=l+1;i<=r;i++){
            if(arr[i] == top+1 || arr[i]>deque.peekFirst()&&arr[i]<=top){
                deque.addLast(arr[i]);
                top = arr[i];
            }else{
                ans++;
                while(!deque.isEmpty()){
                    deque.removeLast();
                }
                deque.add(arr[i]);
                top = arr[i];
            }
        }
        if(!deque.isEmpty()) ans +=1;
        return ans;

    }

}


