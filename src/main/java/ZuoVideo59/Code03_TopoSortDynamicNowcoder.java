package ZuoVideo59;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

//测试链接:https://www.nowcoder.com/practice/88f7e156ca7d43a1a535f619cd3f495c
public class Code03_TopoSortDynamicNowcoder {
    public static int MAX_NODE = (int)2e5+1;
    public static int MAX_EDGE = (int)2e5+1;
    //图的结构
    public static int[] head = new int[MAX_NODE];
    public static int[] next = new int[MAX_EDGE];
    public static int[] to = new int[MAX_EDGE];
    public static int edgeId = 1;

    public static int[] indegree = new int[MAX_NODE];
    public static int[] deque = new int[MAX_NODE];
    public static int l,r;
    public static int deque_cnt;
    public static int n,m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;
            in.nextToken();
            m = (int)in.nval;
            int fromNode,toNode;
            //建图
            for(int i=0;i<m;i++){
                in.nextToken();
                fromNode = (int)in.nval;
                in.nextToken();
                toNode = (int)in.nval;
                addEdge(fromNode, toNode);
            }
            //入度消除法实现拓扑排序
            for (int i = 1; i <= n; i++) {
                if(indegree[i]==0){
                    deque[r++] = i;
                }
            }
            while(l<r){
                for(int e = head[deque[l]];e >0;e = next[e]){
                    if(--indegree[to[e]]==0){
                        deque[r++] = to[e];
                    }
                }
                deque_cnt++;
                l++;
            }
            if(deque_cnt != n){
                out.println(-1);
            }else{
                for(int i=0;i<n;i++){
                    out.print(deque[i]);
                    if(i!=n-1){
                        out.print(" ");
                    }
                }
            }
        }
        clear();
        out.flush();
        out.close();
        br.close();

    }
    public static void clear(){
        Arrays.fill(head,0,n+1,0);
        Arrays.fill(next,0,m+1,0);
        Arrays.fill(to,0,m+1,0);
        l=r=0;
        deque_cnt = 0;
        Arrays.fill(indegree,1,n+1,0);
    }
    public static void addEdge(int fromNode,int toNode){
        indegree[toNode]++;
        next[edgeId] = head[fromNode];
        to[edgeId] = toNode;
        head[fromNode] = edgeId++;
    }
}
