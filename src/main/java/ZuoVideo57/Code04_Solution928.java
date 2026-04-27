package ZuoVideo57;

import java.util.Map;
import java.util.HashMap;


//测试链接：https://leetcode.cn/problems/minimize-malware-spread-ii/description/
//TODO:还是有问题
public class Code04_Solution928 {
    public static int MAX_SIZE = 301;
    public static int[] father = new int[MAX_SIZE];
    public static int[] size = new int[MAX_SIZE];
    public static int[] isInject = new int[MAX_SIZE];
    public static boolean[] isOrigin = new boolean[MAX_SIZE];
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int len = graph.length;
        build(len,initial);
        for(int i=0;i<len;i++){
            if(isOrigin[i]) continue;
            for(int j=0;j<len;j++){
                if(graph[i][j]==1 && !isOrigin[j]){
                    union(i,j);
                }
            }
        }
        for(int i=0;i<len;i++){
            if(!isOrigin[i]) continue;
            for(int j=0,fj;j<len;j++){
                if(graph[i][j]==1){
                    fj = find(j);
                    if(isInject[fj]==-1){
                        isInject[fj] = i;
                    }else if(isInject[fj] != i){
                        isInject[fj] = -2;
                    }
                }
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0,fi;i<len;i++){
            if(isOrigin[i]) continue;
            fi = find(i);
            if(isInject[fi]>=0){
                map.put(isInject[fi], size[fi] + map.getOrDefault(isInject[fi], 0));
            }
        }
        for(int i=0;i<len;i++){
            if(!isOrigin[i]) continue;
            for(int j=0;j<len;j++){
                if(graph[i][j]==1 && isOrigin[j]){
                    map.put(i, map.getOrDefault(j, 0) + map.getOrDefault(i, 0));
                    
                }
            }
        }
        int maxSize = 0;
        int maxIndex = 0;
    
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()>maxSize){
                maxSize = m.getValue();
                maxIndex = m.getKey();
            }
        }
        return maxIndex;
    }
    public void build(int len,int[] initial){
        for(int i=0;i<len;i++){
            father[i] = i;
            size[i] = 1;
            isInject[i] = -1;
            isOrigin[i] = false;
        }
        for(int i=0;i<initial.length;i++){
            isOrigin[initial[i]] = true;
        }
    }
    public int find(int a){
        if(a != father[a]){
            father[a] = find(father[a]);
        }
        return father[a];
    }
    public void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb){
            father[fb] = fa;
            size[fa] += size[fb];
        }
    }
}
