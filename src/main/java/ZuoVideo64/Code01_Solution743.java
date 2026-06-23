package ZuoVideo64;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//测试链接:https://leetcode.cn/problems/network-delay-time/description/
public class Code01_Solution743 {

    /**
     * 普通堆实现
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime1(int[][] times, int n, int k) {
        //邻接表建图
        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }
        for (int[] time : times) {
            edges.get(time[0]).add(new int[]{time[1],time[2]});
        }
        int[] distance = new int[n+1];
        boolean[] visit = new boolean[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a1,a2)->a1[1]-a2[1]);
        minHeap.add(new int[]{k,0});
        while(!minHeap.isEmpty()){
            int[] pop = minHeap.poll();
            if(visit[pop[0]]){
                continue;
            }
            visit[pop[0]] = true;
            distance[pop[0]] = pop[1];
            //System.out.println(String.format("%d 当前节点已经确认,distance=%d",pop[0],pop[1]));
            for(int[] next:edges.get(pop[0])){
                int to = next[0];
                int value = next[1];
                if(!visit[to] && pop[1] + value < distance[to]){
                    minHeap.add(new int[]{to,value+pop[1]});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<distance.length;i++){
            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,distance[i]);
        }
        return ans;
    }


    /**
     * todo 有问题,需要后面再改
     * 反向索引堆(极致)
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime2(int[][] times, int n, int k) {
        build(n);
        for(int[] time:times){
            int from = time[0],to = time[1],value = time[2];
            addEdge(from,to,value);
        }
        addOrUpdateOrIgnore(k,0);
        while(!isEmpty()){
            int pollNode = poll();
            for(int pollEdge = head[pollNode];pollEdge!=0;pollEdge = next[pollEdge]){
                addOrUpdateOrIgnore(to[pollEdge],distance[pollNode] + weight[pollEdge]);
            }
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,distance[i]);
        }
        return ans;
    }

    public static int MAX_N = 101;
    public static int MAX_M = 6001;

    public static int[] head = new int[MAX_N];
    public static int[] next = new int[MAX_M];
    public static int[] to = new int[MAX_M];
    public static int[] weight = new int[MAX_M];
    public static int edgeId;

    public static int[] minHeap = new int[MAX_N];
    public static int[] where = new int[MAX_N];
    public static int heapSize;

    public static int[] distance = new int[MAX_N];
    public static void build(int n){
        edgeId = 1;
        Arrays.fill(head,1,n+1,0);
        Arrays.fill(where,1,n+1,-1);
        Arrays.fill(distance,1,n+1,Integer.MAX_VALUE);
        heapSize = 0;
    }
    public static void addEdge(int fromNode,int toNode,int value){
        next[edgeId] = head[fromNode];
        to[edgeId] = toNode;
        weight[edgeId] = value;
        head[fromNode] = edgeId++;
    }
    public static void addOrUpdateOrIgnore(int nodeId,int dis){
        if(where[nodeId] == -1){
            heapInsert(nodeId,dis);
        } else if (where[nodeId] >=0) {
            if(distance[nodeId] > dis){
                distance[nodeId] = dis;
                justifyToTop(where[nodeId]);
            }
        }
    }
    public static void heapInsert(int nodeId,int dis){
        int heapIndex = heapSize++;
        where[nodeId] = heapIndex;
        minHeap[heapIndex] = nodeId; //小根堆存放nodeId
        distance[nodeId] = dis;
        justifyToTop(heapIndex);
    }
    public static void justifyToTop(int heapIndex){
        int parent = (heapIndex-1)/2;
        while(distance[minHeap[parent]] < distance[minHeap[heapIndex]]){
            swap(parent,heapIndex);
            heapIndex = parent;
            parent = (heapIndex-1)/2;
        }
    }
    public static void heapify(int heapIndex){
        int left = 2*heapIndex+1;
        while(left<heapSize){
            int best = left+1 < heapSize && distance[minHeap[left]]> distance[minHeap[left+1]] ? left+1:left;
            if(distance[minHeap[best]] > distance[minHeap[heapIndex]]) break;
            swap(heapIndex,best);
            heapIndex = best;
            left = 2*heapIndex+1;
        }
    }
    public static void swap(int heapIndex1,int heapIndex2){
        where[minHeap[heapIndex1]] = heapIndex2;
        where[minHeap[heapIndex2]] = heapIndex1;
        int tmpNode = minHeap[heapIndex1];
        minHeap[heapIndex1] = minHeap[heapIndex2];
        minHeap[heapIndex2] = tmpNode;

    }
    public static boolean isEmpty(){
        return heapSize == 0;
    }
    public static int poll(){
        int pollNode = minHeap[0];
        where[pollNode] = -2;
        swap(0,--heapSize);
        heapify(0);
        return pollNode;
    }


}
