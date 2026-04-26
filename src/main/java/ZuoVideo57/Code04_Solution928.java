package ZuoVideo57;
import java.util.Set;
import java.util.HashSet;

//测试链接：https://leetcode.cn/problems/minimize-malware-spread-ii/description/
//TODO:这道题有错误
public class Code04_Solution928 {
    public static int MAX_SIZE = 301;
    public static int[] father = new int[MAX_SIZE];
    public static int[] size = new int[MAX_SIZE];
    public static boolean[] isOrigin = new boolean[MAX_SIZE];
    public static int[] isInject = new int[MAX_SIZE]; //如果isInject[i]=-1,表示这个集合已经被多个病毒侵蚀了，无法清除了
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int len = graph.length;
        build(len,initial);
        //将所有不是病毒的点合并起来
        for(int i=0;i<len;i++){
            if(isOrigin[i]) continue;
            for(int j=0;j<len;j++){
                if(isOrigin[j] || graph[i][j]==0) continue;
                union(i, j);
            }
        }
        //现在开始将病毒加入到集合中
        for(int i=0;i<len;i++){
            if(!isOrigin[i]) continue;
            for(int j=0,fj;j<len;j++){
                fj = find(j);
                if(graph[i][j] == 1 && !isOrigin[fj]){
                    if(isInject[fj]==0){
                        isInject[fj] = i;
                    }else if(isInject[fj]!=i){
                        isInject[fj] = -1;
                    }
                }
            }
        }
        //统计答案
        int maxSize = 0;
        int maxIndex = 0;
        for(int i=0;i<len;i++){
            if(!isOrigin[i]) continue;
            Set<Integer> set = new HashSet<>();
            int curSize = 1;
            for(int j=0,fj;j<len;j++){
                fj = find(j);
                if(graph[i][j] == 1 && !isOrigin[fj] && isInject[fj]>0){
                    if(!set.contains(fj)){
                        curSize += size[fj];
                        set.add(fj);
                    }
                }
            }
            if(curSize>maxSize){
                maxSize = curSize;
                maxIndex = i;
            }
            
        }
        return maxIndex;
        
    }
    public static void build(int len,int[] initial){
        for(int i=0;i<len;i++){
            father[i] = i;
            isInject[i] = 0;//表示还没有被入侵
            size[i] = 1;
        }
        for(int i=0;i<initial.length;i++){
            isOrigin[initial[i]] = true ;
        }
    }
    public static int find(int a){
        if(a != father[a]){
            father[a] = find(father[a]);
        }
        return father[a];
    }
    public static void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb){
            father[fa] = fb;
            size[fb] += size[fa];
        }
    }
}
