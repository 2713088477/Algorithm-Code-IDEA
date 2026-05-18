package ZuoVideo61;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

//测试链接:https://www.luogu.com.cn/problem/P1194
public class Code04_Luogu1194 {
	public static int MAX_NODE = 500+2;
	public static ArrayList<int[]> edge = new ArrayList<>();
	public static int A,B;
	
	//并查集
	public static int[] father = new int[MAX_NODE];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while(in.nextToken() != StreamTokenizer.TT_EOF) {
			A = (int)in.nval;
			in.nextToken();
			B = (int)in.nval;
			build();
			for(int i=0;i<=B;i++) {
				edge.add(new int[] {0,i,A});
			}
			int value = 0;
			for(int i=1;i<=B;i++) {
				for(int j=1;j<=B;j++) {
					in.nextToken();
					value = (int)in.nval;
					if(value != 0) {
						edge.add(new int[] {i,j,value});
					}
					
				}
			}
			out.println(minTree());
		}
		out.flush();
		out.close();
		br.close();
	}
	public static int minTree() {
		edge.sort((a1,a2)->a1[2]-a2[2]);
		int ans = 0;
		for(int i=0;i<edge.size();i++) {
			if(union(edge.get(i)[0],edge.get(i)[1])) {
				ans += edge.get(i)[2];
			}
		}
		return ans;
		
	}
	public static void build() {
		edge.clear();
		for(int i=0;i<=B;i++) {
			father[i]=i;
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
		if(fx!=fy) {
			father[fx] = fy;
			return true;
		}
		return false;
	}
}
