package ZuoVideo54;


import java.io.*;
import java.util.Arrays;

//TODO
public class Code03_luogup2698 {
    public static int MAX_SIZE = (int) 1e5+1;
    public static int n,d;
    public static int[][] arr = new int[MAX_SIZE][2];
    public static int[] maxDeque = new int[MAX_SIZE];
    public static int[] minDeque = new int[MAX_SIZE];
    public static int maxh,maxt,minh,mint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        maxh=maxt=minh=mint=0;
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n = (int)in.nval;in.nextToken();
            d = (int)in.nval;in.nextToken();
            for(int i=0;i<n;i++){
                arr[i][0] = (int)in.nval;in.nextToken();
                arr[i][1] = (int)in.nval;in.nextToken();
            }
            int ans = f();
            out.println(ans == Integer.MAX_VALUE?-1:ans);
        }
        out.flush();
        out.close();
        br.close();
    }
    public static int f(){
        Arrays.sort(arr,0,n,(arr1,arr2)->Integer.compare(arr1[0],arr2[0]));
        int ans = Integer.MAX_VALUE;
        for(int l=0,r=0;l<n;l++){
            //判断[l,r)是否合理
            while(r<n && !isOk()){
                push(r);
                r++;
            }
            if(isOk()){
                ans = Math.min(ans,arr[r-1][0]-arr[l][0]);
            }
            pop(l);
        }
        return ans;

    }
    public static boolean isOk(){
        int max = maxh<maxt? arr[maxDeque[maxh]][1]:0;
        int min = minh<mint? arr[minDeque[minh]][1]:0;
        return max-min>=d;
    }
    public static void push(int r){
        while(maxh<maxt && arr[r][1]>=arr[maxDeque[maxt]][1]){
            maxt--;
        }
        maxDeque[maxt++] = r;
        while(minh<mint && arr[r][1]<=arr[maxDeque[mint]][1]){
            mint--;
        }
        maxDeque[mint++] = r;
    }
    public static void pop(int l){
        if(maxDeque[maxh]==l){
            maxh++;
        }
        if(minDeque[minh]==l){
            minh++;
        }


    }
}
