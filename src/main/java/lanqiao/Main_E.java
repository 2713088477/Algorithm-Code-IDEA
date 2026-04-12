package lanqiao;

import java.io.*;
import java.util.Arrays;

public class Main_E {
    public static int MAX_SIZE = 5001;
    public static int[] narr = new int[MAX_SIZE];
    public static int[] marr = new int[MAX_SIZE];
    public static int n,m;
    public static boolean[] isUsed = new boolean[MAX_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;in.nextToken();
            m = (int)in.nval;in.nextToken();
            for(int i=0;i<n;i++){
                narr[i] = (int)in.nval;in.nextToken();
            }
            for(int i=0;i<m;i++){
                marr[i] = (int)in.nval;in.nextToken();
            }
            Arrays.sort(narr,0,n);
            Arrays.sort(marr,0,m);
            if(m==n){
                out.println(fsame());
            }else{
                out.println(f(n-1));
            }

        }
        out.flush();
        out.close();
        br.close();
    }
    public static long f(int nIndex){
        if(nIndex<0) return 0L;
        long ans = Long.MAX_VALUE;
        long cur = 0;
        for(int i=0;i<m;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                cur = Math.abs(narr[nIndex]-marr[i]);
                cur += f(nIndex-1);
                ans = Math.min(ans,cur);
                isUsed[i] = false;
            }
        }
        return ans;
    }
    public static long fsame(){
        long ans = 0;
        for(int i=0;i<n;i++){
            ans += Math.abs(narr[i]-marr[i]);
        }
        return ans;
    }
}
