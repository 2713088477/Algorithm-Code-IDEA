package icpc.SiChuan2025;

import java.io.*;

public class MainI {
    public static int MAX_SIZE = 300005;
    public static int[][] node = new int[MAX_SIZE][26];
    public static int[] pass = new int[MAX_SIZE];
    public static int[] end = new int[MAX_SIZE];
    public static int cnt;
    public static void build(){
        cnt=1;
    }
    public static void insert(String word){
        int cur = 1;
        pass[cur]++;
        int index;
        for(int i=word.length()-1;i>=0;i--){
            index = word.charAt(i)-'a';
            if(node[cur][index]==0){
                node[cur][index]=++cnt;
            }
            cur = node[cur][index];
            pass[cur]++;
        }
        end[cur]++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String line = in.readLine();
        build();
        int num = Integer.valueOf(line);
        for(int i=0;i<num;i++){
            line=in.readLine();
            insert(line);
        }
        out.println(cnt-1);
        out.flush();
        out.close();
        in.close();
    }
}
