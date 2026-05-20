package ZuoVideo61;

import java.io.*;
import java.util.Arrays;

//测试链接:https://www.luogu.com.cn/problem/P2330
//最小生成树也是最小瓶颈树，最小瓶颈树不一定是最小生成树
public class Code06_Luogu2330 {
	public static int MAX_NODE = 301;
	public static int MAX_EDGE = 8001;
	
	//边的信息
	public static int[][] edge = new int[MAX_EDGE][3];
	
	//并查集
	public static int[] father = new int[MAX_NODE];
	
	
	public static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while(in.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)in.nval;
			in.nextToken();
			m = (int)in.nval;
			build(n);
			for(int i=0;i<m;i++) {
				in.nextToken();
				edge[i][0] = (int)in.nval;
				in.nextToken();
				edge[i][1] = (int)in.nval;
				in.nextToken();
				edge[i][2] = (int)in.nval;
			}
			Arrays.sort(edge,0,m,(e1,e2)->e1[2]-e2[2]);
			int ans = 0;
			for(int i=0;i<m;i++) {
				if(union(edge[i][0],edge[i][1])) {
					ans = Math.max(ans, edge[i][2]);
				}
			}
			out.println(n-1+" "+ ans);
		}
		out.flush();
		out.close();
		br.close();
	}
	public static void build(int n) {
		for(int i=1;i<=n;i++) {
			father[i] = i;
		}
	}
	public static int find(int x) {
		if(x != father[x]) {
			father[x] = find(father[x]);
		}
		return father[x];
	}
	public static boolean union(int x,int y) {
		int fx = find(x);
		int fy = find(y);
		if(fx != fy) {
			father[fy] = fx;
			return true;
		}
		return false;
	}

}
