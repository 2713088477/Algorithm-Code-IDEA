package ZuoVideo46;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//测试链接:https://www.nowcoder.com/practice/545544c060804eceaed0bb84fcd992fb
public class Code04_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() !=StreamTokenizer.TT_EOF){
            int n= (int)in.nval;in.nextToken();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=(int) in.nval;
                in.nextToken();
            }
            out.println(f(arr,0));
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int f(int[] arr,int aim){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int ans = Integer.MIN_VALUE;
        for(int i=0,sum=0;i<arr.length;i++){
            if(arr[i]!=0){
                sum += arr[i]>0?1:-1;
            }
            //sum-need=aim -> need = sum-aim
            if(map.containsKey(sum-aim)){
                ans = Math.max(ans,i-map.get(sum-aim));
            }
            map.putIfAbsent(sum,i);
        }
        return ans;
    }
}
