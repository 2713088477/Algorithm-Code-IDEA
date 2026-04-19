package ZuoVideo56;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Code02_UnionFindLuogu {
    public static int MAX_SIZE = (int)2E5+1;
    public static int[] father = new int[MAX_SIZE];
    public static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n = (int)in.nval;
            in.nextToken();
            m = (int)in.nval;
            init();
            int op,x,y;
            for(int i=0;i<m;i++){
                in.nextToken();
                op= (int)in.nval;
                in.nextToken();
                x= (int)in.nval;
                in.nextToken();
                y= (int)in.nval;
                if(op ==1){
                    union(x, y);
                }else if(op ==2){
                    out.println(isSame(x, y)?"Y":"N");
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void init(){
        for(int i=1;i<=n;i++){
            father[i] = i;
        }
    }
    public static int find(int x){
        if(x == father[x]){
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
    public static boolean isSame(int x,int y){
        return find(x)==find(y);
    }
    public static void union(int x,int y){
        int fx = find(x);
        int fy = find(y);
        if(fx != fy){
            father[fx] = fy;
        }
    }
}
