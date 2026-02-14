package ZuoVideo45;

import java.util.*;

//leetcode链接:https://leetcode.cn/problems/word-search-ii/submissions/698656777/
public class Code05_Solution {
    public char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        build();
        for (String word : words) {
            insert(word);
        }
        this.board = board;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                f(i,j,1,list);
            }
        }
        clear();
        return list;
    }
    public static int[][] dw = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int f(int x, int y, int cur, List<String> list) {
        if(x<0 || x>=board.length || y<0 || y>=board[0].length || board[x][y]==0){
            return 0;
        }
        int path = board[x][y]-'a';
        if(node[cur][path]==0) return 0;
        cur=node[cur][path];
        int fix = 0;
        if(end[cur]!=null){
            list.add(end[cur]);
            fix++;
            end[cur]=null;
        }
        char c = board[x][y];
        board[x][y]=0;
        for(int i=0;i<dw.length;i++){
            int nx = x+dw[i][0];
            int ny = y+dw[i][1];
            fix += f(nx,ny,cur,list);
        }
        board[x][y]=c;
        pass[cur] -= fix;
        return fix;
    }

    public static int MAX_SIZE = 300000;
    public static int[][] node = new int[MAX_SIZE][26];
    public static int[] pass = new int[MAX_SIZE];
    public static String[] end = new String[MAX_SIZE];
    public static int cnt;
    public static void build(){
        cnt=1;
    }
    public static void insert(String word){
        int cur = 1;
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
    public static void clear(){
        for(int i=1;i<=cnt;i++){
            Arrays.fill(node[i],0);
            end[i]=null;
            pass[i]=0;
        }
    }

}
