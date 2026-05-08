package ZuoVideo59;

import java.io.*;
import java.util.Arrays;
import java.util.StringJoiner;

//测试链接:https://www.luogu.com.cn/problem/U107394
public class Code04_TopoSortByOneSort {
    public static int MAX_SIZE = (int)1e5+1;
    //链式前向星
    public static int[] head = new int[MAX_SIZE];
    public static int[] next = new int[MAX_SIZE];
    public static int[] to = new int[MAX_SIZE];
    public static int edgeId = 1;
    
    //入度统计
    public static int[] indegree = new int[MAX_SIZE];
    //最小堆实现字典序最小的拓扑排序
    public static int[] minHeap = new int[MAX_SIZE];
    public static int heapSize = 0;

    public static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;
            in.nextToken();
            m = (int)in.nval;
            int fromNode,toNode;
            for(int i=0;i<m;i++){
                in.nextToken();
                fromNode = (int)in.nval;
                in.nextToken();
                toNode = (int)in.nval;
                addEdge(fromNode, toNode);
            }
            out.println(topoSort());
        }
        clear();
        out.flush();
        out.close();
        br.close();
        
    }
    public static void addEdge(int fromNode,int toNode){
        next[edgeId] = head[fromNode];
        to[edgeId] = toNode;
        head[fromNode] = edgeId++;
        indegree[toNode]++;
    }
    public static String topoSort(){
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                heapInsert(i);
            }
        }
        StringJoiner joiner = new StringJoiner(" ");
        int nodeId  = 0;
        while(heapSize>0){
            nodeId = minHeap[0];
            swap(minHeap, 0, --heapSize);
            heapify(0);
            for(int e = head[nodeId];e>0;e=next[e]){
                if(--indegree[to[e]]==0){
                    heapInsert(to[e]);
                }
            }
            joiner.add(String.valueOf(nodeId));
        }
        return joiner.toString();

    }
    public static void heapInsert(int nodeId){
        int index = heapSize++;
        minHeap[index] = nodeId;
        while(minHeap[index] < minHeap[(index-1)/2]){
            swap(minHeap, index, (index-1)/2);
            index = (index-1)/2;
        }
    }
    public static void heapify(int index){
        int l = index*2+1;
        int best = 0;
        while(l<heapSize){
            best = l+1<heapSize && minHeap[l+1] < minHeap[l]? l+1:l;
            best = minHeap[best] < minHeap[index] ? best : index;
            if(best == index) break;
            swap(minHeap, index, best);
            index = best;
            l = index*2+1;
        }
    }
    public static void clear(){
        Arrays.fill(head,1,n+1,0);
        Arrays.fill(next,1,m+1,0);
        Arrays.fill(to,1,m+1,0);
        edgeId = 1 ; 
        Arrays.fill(indegree,1,n+1,0);
        heapSize = 0;
    }
    public static void swap(int[] arr,int a,int b){
        if(a==b) return;
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

}
