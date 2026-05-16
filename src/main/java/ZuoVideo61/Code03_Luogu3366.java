package ZuoVideo61;
import java.io.*;
import java.util.Arrays;

//测试链接:https://www.luogu.com.cn/problem/P3366
//p算法优化
public class Code03_Luogu3366 {
	public static int MAX_NODE = 5001;
	public static int MAX_EDGE = (int)4E5+2;
	
	//链式前向星
	public static int[] head = new int[MAX_NODE];
	public static int[] next = new int[MAX_EDGE];
	public static int[] weight = new int[MAX_EDGE];
	public static int[] to = new int[MAX_EDGE];
	public static int edgeId = 1;
	//小根堆
	public static int[][] minHeap = new int[MAX_NODE][2];
	public static int heapSize = 0;
	public static int[] thePosOfNode = new int[MAX_NODE];
	
	
	public static int n,m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new  StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while(in.nextToken() != StreamTokenizer.TT_EOF ) {
			n = (int)in.nval;
			in.nextToken();
			m = (int)in.nval;
			build();
			int fromNode,toNode,value;
			for(int i=0;i<m;i++) {
				in.nextToken();
				fromNode = (int)in.nval;
				in.nextToken();
				toNode = (int)in.nval;
				in.nextToken();
				value = (int)in.nval;
				addEdge(fromNode,toNode,value);
			}
		}
	}
	public static void heapInsertOrUpdate(int toNode,int value) {
		int curIndex=0;
		if(thePosOfNode[toNode] == -1) {
			curIndex = heapSize++;
			minHeap[curIndex][0] = toNode;
			minHeap[curIndex][1] = value;
			while(minHeap[curIndex][1] < minHeap[(curIndex-1)/2][1]) {
				swap(curIndex,(curIndex-1)/2);
				curIndex = (curIndex-1)/2;
			}
			thePosOfNode[toNode] = curIndex;
		}else if(thePosOfNode[toNode] > 0 ) {
			curIndex = thePosOfNode[toNode];
			minHeap[curIndex][1] = Math.min(minHeap[curIndex][1], value);
			while(minHeap[curIndex][1] < minHeap[(curIndex-1)/2][1]) {
				swap(curIndex,(curIndex-1)/2);
				curIndex = (curIndex-1)/2;
			}
		}
	}
	public static void heapify()
	public static void swap(int h1,int h2) {
		int[] tmp = minHeap[h1];
		minHeap[h1][0] = minHeap[h2][0];
		minHeap[h1][1] = minHeap[h2][1];
		thePosOfNode[minHeap[h2][0]] = h1;
		
		minHeap[h2][0] = tmp[0];
		minHeap[h2][1] = tmp[1];
		thePosOfNode[tmp[0]] = h2;
		
		
	}
	
	public static void build() {
		Arrays.fill(thePosOfNode,1,n+1 ,-1);
	}
	public static void justify(int nodeId) {
		for(int e=head[nodeId];e>0;e=next[e]) {
			heapInsertOrUpdate(to[e],weight[e]);
		}
	}
	public static int minTree() {
		int ans = 0;
		thePosOfNode[1] = -2;
		justify(1);
		int[] pop = null;
		while(heapSize > 0) {
			pop = minHeap[0];
			swap(0,--heapSize);
			heapify(0);
		}
		
		
		
		return ans;
	}
	public static void addEdge(int fromNode,int toNode,int value) {
		next[edgeId] = head[fromNode];
		weight[edgeId] = value;
		to[edgeId] = toNode;
		head[fromNode] = edgeId++;
	}
}
