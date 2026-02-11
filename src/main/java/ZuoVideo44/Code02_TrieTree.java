package ZuoVideo44;
import java.io.*;
import java.util.Arrays;

public class Code02_TrieTree {
    public static int MAX_Size = 1000000;
    public static int[][] node = new int[MAX_Size][26];
    public static int[] pass = new int[MAX_Size];
    public static int[] end = new int[MAX_Size];
    public static int cnt;
    public static void build(){
        cnt = 1;
    }
    public static void clear(){
        Arrays.fill(pass,1,cnt+1,0);
        Arrays.fill(end,1,cnt+1,0);
        for(int i=1;i<=cnt;i++){
            Arrays.fill(node[i],0);
        }
    }
    public static void insert(String word){
        char[] array = word.toCharArray();
        int cur = 1;
        pass[cur]++;
        for(char c:array){
            int index=c-'a';
            if(node[cur][index]==0){
                node[cur][index]=++cnt;
            }
            cur = node[cur][index];
            pass[cur]++;
        }
        end[cur]++;
    }
    public static void delete(String word){
        char[] array = word.toCharArray();
        int cur = 1;
        pass[cur]--;
        for(char c:array){
            int index=c-'a';
            if((--pass[node[cur][index]]) == 0){
                node[cur][index]=0;
                return;
            }
            cur = node[cur][index];
        }
        end[cur]--;
    }
    public static boolean search(String word){
        char[] array = word.toCharArray();
        int cur = 1;
        if(pass[cur]<=0) return false;
        for(char c:array){
            int index=c-'a';
            if(node[cur][index]==0){
                return false;
            }
            cur = node[cur][index];
            if(pass[cur]<=0) return false;
        }
        return end[cur]>0;
    }
    public static int prefixNumber(String pre){
        char[] array = pre.toCharArray();
        int cur = 1;
        if(pass[cur]<=0) return 0;
        for(char c:array){
            int index=c-'a';
            if(node[cur][index]==0){
                return 0;
            }
            cur = node[cur][index];
            if(pass[cur]<=0) return 0;
        }
        return pass[cur];
    }

    public static String line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        build();
        int tNum = Integer.valueOf(br.readLine());
        while(tNum-- > 0){
            line=br.readLine();
            String[] split = line.split(" ");
            switch(split[0]){
                case("1"):
                    insert(split[1]);
                    break;
                case("2"):
                    delete(split[1]);
                    break;
                case("3"):
                    out.println(search(split[1])==true?"YES":"NO");
                    break;
                case("4"):
                    out.println(prefixNumber(split[1]));
                    break;
            }
        }
        clear();
        out.flush();
        out.close();
        br.close();
    }
}
