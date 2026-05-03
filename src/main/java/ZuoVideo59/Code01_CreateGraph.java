package ZuoVideo59;

import java.util.ArrayList;
import java.util.Arrays;
public class Code01_CreateGraph {
    public static int MAX_NODE_NUM = 11;//实际点的数量+1

    //链式前向星的方式建图
    public static int MAX_EDGE_NUM = 22;
    public static int[] head = new int[MAX_NODE_NUM];
    public static int[] next = new int[MAX_EDGE_NUM];
    public static int[] to = new int[MAX_EDGE_NUM];
    public static int[] weight = new int[MAX_EDGE_NUM];
    public static int cnt;

    //邻接矩阵
    public static int[][] Graph1 = new int[MAX_NODE_NUM][MAX_NODE_NUM];
    //邻接表法
    public static ArrayList<ArrayList<int[]>> Graph2 = new ArrayList<>();

    public static void build(){
        for(int i=0;i<MAX_NODE_NUM;i++){
            Arrays.fill(Graph1[i],-1);
        }
        Graph2.clear();
        for(int i=0;i<MAX_NODE_NUM;i++){
            Graph2.add(new ArrayList<>());
        }
        cnt = 1;
        Arrays.fill(head,0);
        Arrays.fill(next,0);
        Arrays.fill(to, -1);
        Arrays.fill(weight, -1);
    }
    //有向带权图
    public static void createGraph(int[][] edges){
        build();
        for(int i=0;i<edges.length;i++){
            //邻接矩阵
            Graph1[edges[i][0]][edges[i][1]] = edges[i][2];
            //邻接表
            Graph2.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            //链式前向星
            next[cnt] = head[edges[i][0]];
            to[cnt] = edges[i][1];
            weight[cnt] = edges[i][2];
            head[edges[i][0]] = cnt++;
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
        System.out.println("链式前向星");
        for(int i=0;i<MAX_NODE_NUM;i++){
            if(head[i] !=0){
                for(int e = head[i];e>0;e=next[e]){
                    System.out.println(i+"->"+to[e]+"的权值为:"+weight[e]);
                }
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
