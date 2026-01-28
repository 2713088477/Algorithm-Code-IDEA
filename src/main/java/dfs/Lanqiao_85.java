package dfs;


import java.util.*;

// 1:无需package
// 2: 类名必须Main, 不可修改
public class Lanqiao_85 {
    public static int n;
    public static int[] xnum;
    public static int[] ynum;
    public static int[][] direct = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        xnum=new int[n];ynum=new int[n];
        for(int i=0;i<n;i++){
            xnum[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            ynum[i]=sc.nextInt();
        }
        List<Integer> path = new ArrayList<>();
        xnum[0]--;ynum[0]--;
        path.add(0);
        go(path,1,0,0);
        sc.close();
    }
    public static void go(List<Integer> path,int size,int lastX,int lastY){
        if(lastX == n-1 && lastY==n-1){
            for(int t:xnum){
                if(t!=0) return;
            }
            for(int t:ynum){
                if(t!=0) return;
            }
            StringJoiner sj = new StringJoiner(" ");
            for(int i=0;i<size;i++){
                sj.add(path.get(i).toString());
            }
            System.out.println(sj);
            return;
        }
        for(int i = 0;i<direct.length;i++){
            int nx = lastX + direct[i][0];
            int ny = lastY + direct[i][1];
            int pos = ny*n+nx;
            if(nx<0||ny<0||nx>=n||ny>=n||xnum[nx]<=0||ynum[ny]<=0||path.contains(pos)) continue;
            path.add(pos);xnum[nx]--;ynum[ny]--;
            go(path,size+1,nx,ny);
            path.remove(size);xnum[nx]++;ynum[ny]++;
        }

    }
}