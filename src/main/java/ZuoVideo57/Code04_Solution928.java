package ZuoVideo57;



//测试链接：https://leetcode.cn/problems/minimize-malware-spread-ii/description/
public class Code04_Solution928 {
    public static int MAX_SIZE = 301;
    public static int[] father = new int[MAX_SIZE];
    public static int[] isInject = new int[MAX_SIZE];
    public static boolean[] isOrigin = new boolean[MAX_SIZE];
    public static int[] size = new int[MAX_SIZE];
    public int minMalwareSpread(int[][] graph, int[] initial) {
        build(graph.length, initial);
        //将不是病毒的点先合并起来
        for(int i=0;i<graph.length;i++){
            if(isOrigin[i]) continue;
            for(int j=0;j<graph[0].length;j++){
                if(graph[i][j] ==0 || isOrigin[j]) continue;
                union(i, j);
            }
        }
        //模拟感染过程
        for(int i=0;i<graph.length;i++){
            if(!isOrigin[i]) continue;
            for(int j=0,fj;j<graph[0].length;j++){
                if(graph[i][j] ==0 || isOrigin[j]) continue;
                fj = find(j);
                if(isInject[fj]==-1){
                    isInject[fj] = i;
                }else if(isInject[fj]>=0){
                    if(isInject[fj] != i){
                        isInject[fj] = -2;//无法被清楚
                    }
                }
            }
        }
        //统计出最牛的感染病毒
        for(int i=0;i<graph.length;i++){
            if(isInject[i]>=0){
                size[isInject[i]] += size[i];
            }
        }
        //统计结果
        int maxSize = 0;
        int maxIndex = 0;
        for(int i=0;i<graph.length;i++){
            if(isOrigin[i]){
                if(size[i]>maxSize){
                    maxSize = size[i];
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
        
    }
    public static void build(int n,int[] initial){
        for(int i=0;i<n;i++){
            father[i] = i;
            isInject[i] = -1;
            size[i] = 1;
            isOrigin[i] = false;
        }
        for(int i=0;i<initial.length;i++){
            isOrigin[initial[i]] = true;
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
            father[fb] = fa;
            size[fa] += size[fb];
        }
    }
}
