package ZuoVideo56;

//测试链接:https://leetcode.cn/problems/couples-holding-hands/description/
//这道题太难想了😢
public class Code03_Solution765 {
    public static int MAX_SIZE = 62;
    public static int[] father = new int[MAX_SIZE];
    public static int cnt;
    public int minSwapsCouples(int[] row) {
        cnt = row.length/2;
        build(cnt);
        for(int i=0;i<row.length;i+=2){
            union(row[i]/2, row[i+1]/2);
        }
        return row.length/2-cnt;
    }
    public static int find(int x){
        if(x==father[x]){
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
    public static void build(int len){
        for(int i=0;i<len;i++){
            father[i] = i;
        }
    }
    public static void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb){
            father[fa] = fb;
            cnt--;
        }
    }
}
