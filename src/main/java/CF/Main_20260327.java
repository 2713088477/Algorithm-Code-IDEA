package CF;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//TODO:连接:https://codeforces.com/contest/2201/problem/A1
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
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(arr,0,n);
        for(int i=0;i<n;i++){
            if(map.containsKey((arr[i]-1))){
                if(map.containsKey(arr[i]-2)){
                    if(map.get(arr[i]-1)==1) map.remove(arr[i]-1);
                    else map.put(arr[i]-1,map.get(arr[i]-1)-1);
                }

            }else{
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            ans += entry.getValue();
        }
        return ans;

    }

}


