package ZuoVideo59;

import java.util.ArrayList;
import java.util.Arrays;
public class Code01_CreateGraph {
    public static int MAX_NODE_NUM = 11;//实际点的数量+1
    public static int[][] Graph1 = new int[MAX_NODE_NUM][MAX_NODE_NUM];
    public static ArrayList<ArrayList<int[]>> Graph2 = new ArrayList<>();

    public static void build(){
        for(int i=0;i<MAX_NODE_NUM;i++){
            Arrays.fill(Graph1[i],-1);
        }
        Graph2.clear();
        for(int i=0;i<MAX_NODE_NUM;i++){
            Graph2.add(new ArrayList<>());
        }
    }
    //有向带权图
    public static void createGraph(int[][] edges){
        build();
        for(int i=0;i<edges.length;i++){
            //邻接矩阵
            Graph1[edges[i][0]][edges[i][1]] = edges[i][2];
            //邻接表
            Graph2.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
        }
    }
    public static void printGraph(){
        System.out.println("邻接矩阵");
        for(int i=1;i<MAX_NODE_NUM;i++){
            for(int j=1;j<MAX_NODE_NUM;j++){
                if(Graph1[i][j]!=-1){
                    System.out.println(i+"->"+j+"的权值为:"+Graph1[i][j]);
                }
            }
        }
        System.out.println("邻接表");
        for(int i=1;i<MAX_NODE_NUM;i++){
            for(int[] edge:Graph2.get(i)){
                System.out.println(i+"->"+edge[0]+"的权值为:"+edge[1]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
            {1,2,5},
            {2,4,7}
        };
        createGraph(edges);
        printGraph();
    }
}
