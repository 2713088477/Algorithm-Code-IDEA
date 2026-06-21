package ZuoVideo61;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

//测试链接:https://www.luogu.com.cn/problem/P3366
//p算法
public class Code02_Luogu3366 {
	public static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		ArrayList<ArrayList<int[]>> edge = new ArrayList<>();
		while(in.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)in.nval;
			in.nextToken();
			m = (int)in.nval;
			build(edge,n);
			for(int i=0,fromNode,toNode,value;i<m;i++) {
				in.nextToken();
				fromNode = (int)in.nval;
				in.nextToken();
				toNode = (int)in.nval;
				in.nextToken();
				value = (int)in.nval;
				edge.get(fromNode).add(new int[]{toNode,value});
				edge.get(toNode).add(new int[]{fromNode,value});
			}
			int ans = 0;
			boolean[] set = new boolean[n+1];
			int edgeCount = 0;
			int curNode = 1;
			set[curNode] = true;
			PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[1]-b[1]);
			for(int[] e:edge.get(curNode)) {
				heap.add(e);
			}
			while(!heap.isEmpty()) {
				curNode = heap.peek()[0];
				if(!set[curNode]) {
					set[curNode] = true;
					edgeCount++;
					ans += heap.poll()[1];
					for(int[] e:edge.get(curNode)) {
						heap.add(e);
					}
				}else {
					heap.poll();
				}
			}
			out.println(edgeCount == n-1? ans : "orz");
			
		}
		out.flush();
		out.close();
		br.close();
	}
	public static void build(ArrayList<ArrayList<int[]>> edge,int n) {
		for(int i=0;i<=n;i++) {
			edge.add(new ArrayList<>());
		}
	}
}
