package ZuoVideo64;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

//测试链接:https://www.luogu.com.cn/problem/P4568
public class Code06_file1_Solution4568 {
    public static int MAX_N = (int)1E4;
    public static int MAX_M = (int)5E5+1;
    public static int MAX_K = 11;
    //链式前向星
    public static int[] head = new int[MAX_N];
    public static int[] next = new int[MAX_M];
    public static int[] to = new int[MAX_M];
    public static int[] weight = new int[MAX_M];
    public static int edgeId = 1;
    //语言自带的堆
    public static PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);
    public static int n,m,k;
    public static int sNode, eNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;
            in.nextToken();
            m = (int)in.nval;
            in.nextToken();
            k = (int)in.nval;
            build(n);
            in.nextToken();sNode = (int)in.nval;
            in.nextToken();eNode = (int)in.nval;
            for(int i=0,from,to,w;i<m;i++){
                in.nextToken();from = (int)in.nval;
                in.nextToken();to = (int)in.nval;
                in.nextToken();w = (int)in.nval;
                addEdge(from,to,w);
                addEdge(to,from,w);
            }
            int[][] distance = new int[n][k+1];
            for(int[] dis:distance){
                Arrays.fill(dis,Integer.MAX_VALUE);
            }
            boolean[][] visit = new boolean[n][k+1];
            minHeap.add(new int[]{sNode,0,0});
            while(!minHeap.isEmpty()){
                int[] poll = minHeap.poll();
                int pollNode = poll[0],freeCnt = poll[1],curPrice = poll[2];
                if(visit[pollNode][freeCnt]){
                    continue;
                }
                distance[pollNode][freeCnt] = curPrice;
                visit[pollNode][freeCnt] = true;
                if(pollNode == eNode){
                    out.println(curPrice);
                    break;
                }
                for(int nextEdge = head[pollNode];nextEdge!=0;nextEdge = next[nextEdge]){
                    int toNode = to[nextEdge],wei = weight[nextEdge];
                    //决策1:使用免费
                    if(freeCnt<k && !visit[toNode][freeCnt+1] && distance[toNode][freeCnt+1]>curPrice){
                        minHeap.add(new int[]{toNode,freeCnt+1,curPrice});
                        distance[toNode][freeCnt+1] = curPrice;
                    }
                    //决策2:不使用免费
                    if(!visit[toNode][freeCnt] && distance[toNode][freeCnt] > curPrice+wei){
                        minHeap.add(new int[]{toNode,freeCnt,curPrice + wei});
                        distance[toNode][freeCnt] = curPrice+wei;
                    }
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void build(int n){
        Arrays.fill(head,0,n,0);
        edgeId = 1;
        minHeap.clear();
    }
    public static void addEdge(int from,int toNode,int w){
        next[edgeId] = head[from];
        to[edgeId] = toNode;
        weight[edgeId] = w;
        head[from] = edgeId++;
    }
}
