package lanqiao;

import java.io.*;

public class Main_D {
    public static int MAX_SIZE = 1001;
    public static int[] arr = new int[MAX_SIZE];
    public static int n,t,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        long ans = 0;
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;in.nextToken();
            t = (int)in.nval;in.nextToken();
            k = (int)in.nval;in.nextToken();
            for(int i=0;i<n;i++){
                for(int j=0;j<t;j++){
                    arr[j] = (int)in.nval;in.nextToken();
                }
                ans += f();
            }
            out.println(ans);
        }
        out.flush();
        out.close();
        br.close();
    }
    public static long f(){
        long ans = 0;
        int cur = 0;
        int more;
        for(int l=0,r=0;l<t;l++){
            while(r<t && cur<k){
                if(arr[r]==1)cur++;
                r++;
            }
            if(cur==k){
                ans++;
                more = k!=0?r:++r;
                while(more<t&&arr[more]==0){
                    ans++;
                    more++;
                }
            }

            if(arr[l]==1)cur--;
        }
        return ans;
    }
}
