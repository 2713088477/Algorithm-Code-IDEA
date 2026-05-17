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
	//已经确定的边的数量
	public static int edgeNum = 0;
	
	
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
				addEdge(toNode,fromNode,value);
			}
			int ans = minTree();
			out.println(edgeNum == n-1?ans:"orz");
		}
		out.flush();
		out.close();
		br.close();
	}
	public static void heapInsertOrUpdate(int toNode,int value) {
		System.out.println(String.format("调整堆:去向:%s的点，权值:%s",toNode,value));
		int curIndex=0;
		if(thePosOfNode[toNode] == -1) {
			curIndex = heapSize++;
			minHeap[curIndex][0] = toNode;
			minHeap[curIndex][1] = value;
			System.out.println(String.format("堆中下标为:%s,去向:%s,权值:%s",curIndex,minHeap[curIndex][0],minHeap[curIndex][1]));
			while(minHeap[curIndex][1] < minHeap[(curIndex-1)/2][1]) {
				swap(curIndex,(curIndex-1)/2);
				curIndex = (curIndex-1)/2;
				System.out.println(String.format("堆中下标为:%s,去向:%s,权值:%s",curIndex,minHeap[curIndex][0],minHeap[curIndex][1]));
			}
			System.out.println(String.format("去向:%s的边不存在，首次加入堆中,堆的下标:%s,权值:%s",minHeap[curIndex][0],curIndex,minHeap[curIndex][1]));
		}else if(thePosOfNode[toNode] > 0 ) {
			curIndex = thePosOfNode[toNode];
			System.out.println(String.format("去向:%s的边存在，更新堆之前的结果,堆的下标:%s,权值:%s",minHeap[curIndex][0],curIndex,minHeap[curIndex][1]));
			minHeap[curIndex][1] = Math.min(minHeap[curIndex][1], value);
			while(minHeap[curIndex][1] < minHeap[(curIndex-1)/2][1]) {
				swap(curIndex,(curIndex-1)/2);
				curIndex = (curIndex-1)/2;
			}
			System.out.println(String.format("去向:%s的边存在，更新堆之后的结果,堆的下标:%s,权值:%s",minHeap[curIndex][0],curIndex,minHeap[curIndex][1]));
		}
	}
	public static void heapify(int heapIndex) {
		int l = heapIndex*2+1;
		int best = 0;
		while(l<heapSize) {
			best = l+1<heapSize && minHeap[l+1][1] <minHeap[l][1] ? l+1:l;
			best = minHeap[best][1] < minHeap[heapIndex][1] ? best:heapIndex;
			if(best == heapIndex) break;
			swap(best,heapIndex);
			heapIndex = best;
			l = heapIndex*2+1;
		}
	}
//	public static void printHeap(int index) {
//		System.out.println(String.format("节点为:%s,去向:%s,权值：%s",index,minHeap[index][0],minHeap[index][1]));
//	}
	public static void swap(int h1,int h2) {
//		System.out.println(String.format(" %s和%s交换数据(交换前)",h1,h2));
//		printHeap(h1);
//		printHeap(h2);
		
		int tToNode = minHeap[h1][0];
		int tValue = minHeap[1][1];
		
		minHeap[h1][0] = minHeap[h2][0];
		minHeap[h1][1] = minHeap[h2][1];
		thePosOfNode[minHeap[h2][0]] = h1;
//		System.out.println(String.format(" %s和%s交换数据(%s完成更新)",h1,h2,h1));
//		printHeap(h1);
		
		minHeap[h2][0] = tToNode;
		minHeap[h2][1] = tValue;
		thePosOfNode[tToNode] = h2;
//		System.out.println(String.format(" %s和%s交换数据(%s完成更新)",h1,h2,h2));
//		printHeap(h2);
		
		
	}
	
	public static void build() {
		Arrays.fill(thePosOfNode,1,n+1 ,-1);
		Arrays.fill(head,1,n+1 ,0);
		Arrays.fill(next,1,m+1 ,0);
		Arrays.fill(weight,1,m+1 ,0);
		Arrays.fill(to,1,m+1 ,0);
		edgeId = 1;
		heapSize = 0;
		edgeNum = 0;
	}
	public static void justify(int nodeId) {
		System.out.println(String.format("更新编号为:%s的节点的边的信息", nodeId));
		for(int e=head[nodeId];e>0;e=next[e]) {
			heapInsertOrUpdate(to[e],weight[e]);
		}
	}
	public static int minTree() {
		int ans = 0;
		System.out.println(String.format("当前编号为:%s的节点已经处理完成", 1));
		thePosOfNode[1] = -2;
		justify(1);
		int popNode = 0;
		int popValue = 0;
		while(heapSize > 0) {
			popNode = minHeap[0][0];
			popValue = minHeap[0][1];
			swap(0,--heapSize);
			heapify(0);
			ans += popValue;
			edgeNum++;
			thePosOfNode[popNode] = -2;
			System.out.println(String.format("当前编号为:%s的节点已经处理完成", popNode));
			System.out.println(String.format("确定最小生成树的一条边!指向:%s,权值:%s", popNode,popValue));
			justify(popNode);
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
