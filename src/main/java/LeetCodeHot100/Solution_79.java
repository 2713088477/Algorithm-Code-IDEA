package LeetCodeHot100;

import java.util.Arrays;

public class Solution_79 {
    private char[][] board;
    private char[] word;
    private int[][] go = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        char[] array = word.toCharArray();
        this.board=board;
        this.word=array;
        boolean[][] visit = new boolean[board[0].length][board.length];
        for (boolean[] v : visit) {
            Arrays.fill(v,false);
        }
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                visit[i][j]=true;
                if(f(visit,i,j,0)) return true;
                visit[i][j]=false;
            }
        }
        return false;

    }
    public boolean f(boolean[][] visit,int x,int y,int index){
        if(board[y][x]!=word[index]) return false;
        if(index==word.length-1) return true;
        for(int i=0;i<go.length;i++){
            int nx = x+go[i][0];
            int ny = y+go[i][1];
            if(nx<0||ny<0||nx>=board[0].length||ny>=board.length||visit[nx][ny])continue;
            visit[nx][ny]=true;
            if(f(visit,nx,ny,index+1)) return true;
            visit[nx][ny]=false;
        }
        return false;
    }
}
