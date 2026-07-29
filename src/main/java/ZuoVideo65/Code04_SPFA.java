package ZuoVideo65;

import java.io.*;
import java.util.Arrays;

//测试链接: https://www.luogu.com.cn/problem/P3385

/**
 * Bellman_Ford + SPFA
 * 判断是否存在负环
 */
public class Code04_SPFA {
    public static int MAX_N = (int)2E3+1,MAX_M = (int)6E3;
    //链式前向星建图
    public static int[] head = new int[MAX_N];
    public static int[] next = new int[MAX_M];
    public static int[] to = new int[MAX_M];
    public static int[] value = new int[MAX_M];
    public static int edgeId = 1;

    //distance表
    public static int[] distance = new int[MAX_N];

    //SPFA优化所需要的队列
    public static int[] queue = new int[MAX_N*MAX_N];
    public static int l,r;
    //SPFA优化所需要的判断是否在队列中的数组
    public static boolean[] entry = new boolean[MAX_N];

    //判断负环所特需要的count数组
    public static int[] updateCount = new int[MAX_N];

    public static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            int t = (int)in.nval;
            while((t--)>0){
                in.nextToken(); n = (int) in.nval;
                in.nextToken(); m = (int) in.nval;
                build(n);
                for(int i=0,fromNode,toNode,weight;i<m;i++){
                    in.nextToken(); fromNode = (int) in.nval;
                    in.nextToken(); toNode = (int) in.nval;
                    in.nextToken(); weight = (int) in.nval;
                    if(weight>=0){
                        addEdge(fromNode,toNode,weight);
                        addEdge(toNode,fromNode,weight);
                    }else{
                        addEdge(fromNode,toNode,weight);
                    }
                }
                out.println(spfa()?"YES":"NO");
            }

        }
        out.flush();
        out.close();
        br.close();
    }
    //初始化
    public static void build(int n){
        edgeId = 1;
        Arrays.fill(head,1,n+1,0);
        Arrays.fill(distance,1,n+1,Integer.MAX_VALUE);
        l=r=0;
        Arrays.fill(entry,1,n+1,false);
        Arrays.fill(updateCount,1,n+1,0);
    }
    public static void addEdge(int fromNode,int toNode,int weight){
        next[edgeId] = head[fromNode];
        to[edgeId] = toNode;
        value[edgeId] = weight;
        head[fromNode] = edgeId++;
    }
    public static boolean spfa(){
        distance[1] = 0;
        entry[1] = true;
        queue[r++] = 1;
        while(l<r){
            int pollNode = queue[l++];
            entry[pollNode] = false;
            for(int edge = head[pollNode];edge!=0;edge = next[edge]){
                int toNode =to[edge],weight = value[edge];
                if(distance[pollNode] + weight < distance[toNode]){
                    if(!entry[toNode]){
                        if(++updateCount[toNode] >= n ){
                            return true;
                        }
                        queue[r++] =toNode;
                        entry[toNode] = true;
                    }
                    distance[toNode] = distance[pollNode] + weight;
                }

            }
        }
        return false;
    }
}
