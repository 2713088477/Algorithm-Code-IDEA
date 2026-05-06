package ZuoVideo59;

import java.io.*;
import java.util.Arrays;
import java.util.StringJoiner;

//测试链接:https://www.luogu.com.cn/problem/U107394
//TODO：有问题这道题
public class Code04_TopoSortByOneSort {
    public static int MAX_SIZE = (int)1E5+1;
    //链式前向星的结构
    public static int[] head = new int[MAX_SIZE];
    public static int[] next = new int[MAX_SIZE];
    public static int[] to = new int[MAX_SIZE];
    public static int edgeId = 1;

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
    public static void clear(){
        Arrays.fill(head,0);
        Arrays.fill(next,0);
        Arrays.fill(to,0);
        edgeId = 1;
        Arrays.fill(indegree,0);
        Arrays.fill(minHeap,0);
        heapSize = 0;
    }
    //入度统计
    public static int[] indegree = new int[MAX_SIZE];
    public static void addEdge(int fromNode,int toNode){
        next[edgeId] = head[fromNode];
        to[edgeId] = toNode;
        head[fromNode] = edgeId++;
        indegree[toNode] ++;
        //System.out.println(fromNode+" -> "+toNode+"建立了一条边");
    }
    //小根堆
    public static int[] minHeap = new int[MAX_SIZE];
    public static int heapSize;
    public static void insert(int num){
        int index = heapSize;
        minHeap[index] = num;
        while(minHeap[index]<minHeap[index-1/2]){
            swap(minHeap, index, index-1/2);
            index = index-1/2;
        }
        heapSize++;
    }
    public static void justify(int index){
        int l = index*2+1;
        while(l<heapSize){
            int best = l+1<heapSize&&minHeap[l+1]<minHeap[l]? l+1:l;
            best = minHeap[best] < minHeap[index] ? best:index;
            if(best == index) break;
            else{
                swap(minHeap, index, best);
            }
            index = best;
            l = index*2+1;

        }
    }
    public static void swap(int[] arr,int i,int j){
        if(i==j) return;
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
    public static String topoSort(){
        StringJoiner joiner = new StringJoiner(" ");
        for(int i= 1;i<=n;i++){
            if(indegree[i] == 0){
                //System.out.println(i+"入队了");
                insert(i);
            }
        }
        int top = 0;
        while(heapSize>0){
            top = minHeap[0];
            joiner.add(String.valueOf(top));
            swap(minHeap, 0, --heapSize);
            justify(0);
            for(int e=head[top];e>0;e=next[e]){
                if(--indegree[to[e]]==0){
                    insert(to[e]);
                    //System.out.println(to[e]+"入队了");
                }
            }
            //System.out.println(minHeap[0]+"出队了");
            
        }
        return joiner.toString();

    }
}
