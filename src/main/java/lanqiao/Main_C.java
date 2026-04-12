package lanqiao;

import java.io.*;

public class Main_C {
    public static int MAX_SIZE = 2001;
    public static int[][] node = new int[MAX_SIZE][26];
    public static int[] pass = new int[MAX_SIZE];
    public static String[] theOnly = new String[MAX_SIZE];
    public static int n,m;
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        cnt = 1;
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n= (int)in.nval;in.nextToken();
            m= (int)in.nval;in.nextToken();
            for(int i=0;i<n;i++){
                add(in.sval);in.nextToken();
            }
            for(int i=0,count;i<m;i++){
                count = countPrefix(in.sval);
                if(count ==0){
                    out.println("unknown");
                }else if(count==1){
                    out.println(find(in.sval));
                }else if (count>1){
                    out.println("ambiguous");
                }
                in.nextToken();
            }
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void add(String word){
        int cur = 1;
        pass[cur]++;
        for(int i=0,index;i<word.length();i++){
            index = word.charAt(i)-'a';
            if(node[cur][index]==0){
                node[cur][index]=++cnt;
            }
            cur = node[cur][index];
            pass[cur]++;
            if(pass[cur]==1){
                theOnly[cur] = word;
            }
        }
    }
    public static int countPrefix(String prefix){
        int cur = 1;
        for(int i=0,index;i<prefix.length();i++){
            index = prefix.charAt(i)-'a';
            if(node[cur][index]==0){
                return 0;
            }
            cur = node[cur][index];
        }
        return pass[cur];
    }
    public static String find(String prefix){
        int cur = 1;
        for(int i=0,index;i<prefix.length();i++){
            index = prefix.charAt(i)-'a';
            cur = node[cur][index];
            if(pass[cur]==1) return theOnly[cur];
        }
        return theOnly[cur];

    }
}
