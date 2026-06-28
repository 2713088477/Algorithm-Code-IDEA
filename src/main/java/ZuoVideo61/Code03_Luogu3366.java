package ZuoVideo61;
import java.io.*;
import java.util.Arrays;

//测试链接:https://www.luogu.com.cn/problem/P3366
//p算法优化
//todo
public class Code03_Luogu3366 {
	public static int MAX_N = 5001;
	public static int MAX_M = (int)2E5+1;

	public static int[] head = new int[MAX_N];
	public static int[] next = new int[MAX_M];
	public static int[] to = new int[MAX_M];
	public static int[] weight = new int[MAX_M];
	public static int edgeId;

	public static int n,m;

	public static int[][] minHeap = new int[MAX_N][2];
	public static int heapSize;

	public static int[] where = new int[MAX_N];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (in.nextToken() != StreamTokenizer.TT_EOF){
			n = (int)in.nval;
			in.nextToken();
			m = (int)in.nval;
			build(n);
			for(int i=0,fromNode,toNode,value;i<m;i++){
				in.nextToken();
				fromNode = (int)in.nval;
				in.nextToken();
				toNode = (int)in.nval;
				in.nextToken();
				value = (int)in.nval;
				addEdge(fromNode,toNode,value);
				addEdge(toNode,fromNode,value);
			}
			addOrUpdateOrIgnore(1,0);
			int ans = 0;
			while(!isEmpty()){
				int[] poll = poll();
				int pollNode = poll[0] ,dis = poll[1];
				where[pollNode] = -2;
				ans += dis;
				for(int pollEdgeId = head[pollNode];pollEdgeId!=0;pollEdgeId = next[pollEdgeId]){
					int nextNode = to[pollEdgeId];
					int nextDis = weight[pollEdgeId];
					addOrUpdateOrIgnore(nextNode,nextDis);
				}
			}
			for(int i=1;i<=n;i++){
				if(where[i] != -2){
					out.println("orz");
					out.flush();
					out.close();
					br.close();
					return;
				}
			}
			out.println(ans);

		}
		out.flush();
		out.close();
		br.close();
	}
	public static void build(int n){
		edgeId = 1;
		heapSize = 0;
		Arrays.fill(head,1,n+1,0);
		Arrays.fill(where,1,n+1,-1);
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
		}else if(where[nodeId] >= 0){
			int curHeapIndex = where[nodeId];
			if(minHeap[curHeapIndex][1] > dis){
				minHeap[curHeapIndex][1] = dis;
				justifyToTop(curHeapIndex);
			}
		}
	}
	public static void heapInsert(int nodeId,int dis){
		int heapIndex = heapSize++;
		where[nodeId] = heapIndex;
		minHeap[heapIndex][0] = nodeId;
		minHeap[heapIndex][1] = dis;
		justifyToTop(heapIndex);
	}
	public static void justifyToTop(int heapIndex){
		int parent = (heapIndex-1)/2;
		while(minHeap[parent][1] > minHeap[heapIndex][1]){
			swap(parent,heapIndex);
			heapIndex = parent;
			parent = (heapIndex-1)/2;
		}

	}
	public static void swap(int heapIndex1,int heapIndex2){
		where[minHeap[heapIndex1][0]] = heapIndex2;
		where[minHeap[heapIndex2][0]] = heapIndex1;
		int[] tmp = minHeap[heapIndex1];
		minHeap[heapIndex1] = minHeap[heapIndex2];
		minHeap[heapIndex2] = tmp;
	}
	public static boolean isEmpty(){
		return heapSize==0;
	}
	public static int[] poll(){
		int[] pollArr = minHeap[0];
		swap(0,--heapSize);
		heapify(0);
		return pollArr;
	}
	public static void heapify(int heapIndex){
		int left = 2*heapIndex+1;
		while (left<heapSize){
			int best = left+1<heapSize && minHeap[left+1][1] < minHeap[left][1] ? left+1:left;
			if(minHeap[best][1] > minHeap[heapIndex][1]) break;
			swap(best,heapIndex);
			heapIndex = best;
			left = 2*heapIndex+1;
		}
	}


}
