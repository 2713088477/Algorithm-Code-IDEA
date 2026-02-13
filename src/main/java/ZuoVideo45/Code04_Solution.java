package ZuoVideo45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code04_Solution {
    public static char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        build();
        Code04_Solution.board =board;
        for (String word : words) {
            insert(word);
        }
        List<String> ans = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                f(i,j,1,ans);
            }
        }

        clear();
        return ans;
    }

    public static int[][] dw = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public void f(int i, int j, int cur, List<String> ans) {
        if(i<=0 || i>=board.length || j<=0 || j>=board[0].length || board[i][j]==0){
            return;
        }
        if(end[cur]!=null){
            ans.add(end[cur]);
            return;
        }
        int path = board[i][j]-'a';
        if(node[cur][path]==0){
            return;
        }
        char c =  board[i][j];
        board[i][j]=0;
        for(int k=0;k<dw.length;k++){
            int nx = i + dw[k][0];
            int ny = j + dw[k][1];
            f(nx,ny,cur,ans);
        }
        board[i][j]=c;


    }

    public static int MAX_SIZE = 300000;
    public static int[][] node = new int[MAX_SIZE][26];
    public static int[] pass = new int[MAX_SIZE];
    public static String[] end = new String[MAX_SIZE];
    public static int cnt;

    public static void build(){
        cnt=1;
    }
    public static void clear(){
        for(int i=1;i<=cnt;i++){
            Arrays.fill(node[i],0);
            pass[i]=0;
        }
    }
    public static void insert(String word){
        int cur=1;
        pass[cur]++;
        for(int i=0;i<word.length();i++){
            int path = word.charAt(i)-'a';
            if(node[cur][path]==0){
                node[cur][path]=++cnt;
            }
            cur = node[cur][path];
            pass[cur]++;
        }
        end[cur]=word;
    }
}
