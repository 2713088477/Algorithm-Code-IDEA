package ZuoVideo57;

import java.util.HashMap;
import java.util.Map;

//测试链接:https://leetcode.cn/problems/most-stones-removed-with-same-row-or-column/description/
public class Code01_Solution947 {
    public static Map<Integer,Integer> firtRow = new HashMap();
    public static Map<Integer,Integer> firtCol = new HashMap();
    public static int MAX_SIZE = 1001;
    public static int[] father = new int[MAX_SIZE];
    public static int cnt = 0;
    public int removeStones(int[][] stones) {
        
        int total = stones.length;
        build(total);
        for(int i=0;i<stones.length;i++){
            for(int j=0;j<stones[0].length;j++){
                if(firtRow.get(stones[i][0])==null){
                    firtRow.put(stones[i][0], i);
                }else{
                    union(firtRow.get(stones[i][0]), i);
                }
                if(firtCol.get(stones[i][1])==null){
                    firtCol.put(stones[i][1], i);
                }else{
                    union(firtCol.get(stones[i][1]), i);
                }
            }
        }
        return total - cnt;
    }
    public static void build(int total){
        cnt = total;
        for(int i=0;i<total;i++){
            father[i]=i;
        }
        firtRow.clear();
        firtCol.clear();
    }
    public static int find(int a){
        if(father[a]==a){
            return a;
        }
        father[a] = find(father[a]);
        return father[a];
    }
    public static void union(int a,int b){
        int fa =find(a);
        int fb = find(b);
        if(fa!=fb){
            father[fa] = fb;
            cnt--;
        }
    }

}
