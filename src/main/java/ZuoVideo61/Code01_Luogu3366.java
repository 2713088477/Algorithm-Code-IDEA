package ZuoVideo61;

import java.io.*;
import java.util.Arrays;

//测试链接:https://www.luogu.com.cn/problem/P3366
public class Code01_Luogu3366 {
	public static int n,m;
	public static int MAX_N = 5001,MAX_M=200001;
	public static int[][] edges = new int[MAX_M][3];
	public static int[] father = new int[MAX_N];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while(in.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)in.nval;
			in.nextToken();
			m = (int)in.nval;
			for(int i=0;i<m;i++) {
				in.nextToken();
				edges[i][0] = (int)in.nval;
				in.nextToken();
				edges[i][1] = (int)in.nval;
				in.nextToken();
				edges[i][2] = (int)in.nval;
			}
			build();
			Arrays.sort(edges,0,m,(a,b)->a[2]-b[2]);
			int edge_count = 0;
			int values=0;
			for(int i=0;i<m;i++) {
				if(union(edges[i][0],edges[i][1])) {
					edge_count++;
					values += edges[i][2];
				}
			}
			out.println(edge_count == n-1?values:"orz");
		}
		out.flush();
		out.close();
		br.close();
	}
	public static void build() {
		for(int i=1;i<=n;i++) {
			father[i] = i;
		}
	}
	public static int find(int a) {
		if(a != father[a]) {
			father[a] = find(father[a]);
		}
		return father[a];
	}
	public static boolean union(int a,int b) {
		int fa = find(a),fb=find(b);
		if(fa!=fb) {
			father[fb] = fa;
			return true;
		}else {
			return false;
		}
	}
}
