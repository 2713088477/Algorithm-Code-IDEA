package ZuoVideo57;
import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/number-of-good-paths/description/
public class Code03_Solution2421 {
    public static int MAX_SIZE = (int)3E4+1;
    public static int[] father = new int[MAX_SIZE];
    public static int[] maxCnt = new int[MAX_SIZE];
    public static int ans;
    public static void build(int n){
        ans = n;
        for(int i=0;i<n;i++){
            father[i] = i;
            maxCnt[i] = 1;
        }
    }
    public static int find(int a){
        if(a == father[a]){
            return father[a];
        }
        father[a] = find(father[a]);
        return father[a];
    }
    public static void union(int a,int b,int[] vals){
        int fa = find(a);
        int fb = find(b);
        if(vals[fa] > vals[fb]){
            father[fb] = fa;
        }else if(vals[fa] < vals[fb]){
            father[fa] = fb;
        }else{
            ans += maxCnt[fa]*maxCnt[fb];
            father[fa] = fb;
            maxCnt[fb] += maxCnt[fa];
        }
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        build(vals.length);
        Arrays.sort(edges,(e1,e2)->Math.max(vals[e1[0]],vals[e1[1]])-Math.max(vals[e2[0]],vals[e2[1]]));
        for(int i=0;i<edges.length;i++){
            union(edges[i][0], edges[i][1], vals);
        }
        return ans;
    }
}
