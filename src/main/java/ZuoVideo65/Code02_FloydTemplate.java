package ZuoVideo65;

import java.io.*;

//测试链接: https://www.luogu.com.cn/problem/P2910
public class Code02_FloydTemplate {
    public static int MAX_N = 101;
    public static int MAX_M = (int)1E4+1;
    public static int[][] distance = new int[MAX_N][MAX_N];
    public static int[] direction = new int[MAX_M];

    public static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;
            in.nextToken(); m = (int)in.nval;
            for(int i=0;i<m;i++){
                in.nextToken(); direction[i] = (int)in.nval;
            }
            build();
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    in.nextToken(); distance[i][j]= (int)in.nval;
                }
            }
            floyd();
            int ans = 0;
            for(int i=1;i<=m;i++){
                ans += distance[direction[i-1]][direction[i]] ;
            }
            out.println(ans);
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void build(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
    }
    public static void floyd(){
        for(int step = 1;step<=n;step++){
            for(int i = 1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(distance[i][step] != Integer.MAX_VALUE && distance[step][j] != Integer.MAX_VALUE
                    && distance[i][j] > distance[i][step]+distance[step][j]){
                        distance[i][j] = distance[i][step] + distance[step][j];
                    }
                }
            }
        }
    }
}
