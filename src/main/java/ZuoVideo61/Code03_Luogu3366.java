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

	public static boolean[] isExist = new boolean[MAX_N];
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
			}



		}
	}
	public static void build(int n){
		edgeId = 1;
		heapSize = 0;
		Arrays.fill(isExist,1,n+1,false);
		Arrays.fill(where,1,n+1,-1);
	}
	public static void addEdge(int fromNode,int toNode,int value){
		next[edgeId] = head[fromNode];
		to[edgeId] = toNode;
		weight[edgeId] = value;
		head[fromNode] = edgeId++;
	}
}
