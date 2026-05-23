package Luogu;

import java.io.*;
import java.util.Arrays;

//测试链接: https://www.luogu.com.cn/problem/P1666
//TODO:这道题有问题
public class Main_p1666 {
	public static int MAX_LEN = 51;
	public static int[][] nodes = new int[MAX_LEN][26];
	public static int[] pass = new int[MAX_LEN];
	public static int cnt = 1;
	
	public static void main(String[] args) throws IOException {
		int n= 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while(in.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int)in.nval;
			int ans = (int)Math.pow(2, n);
			build();
			String cur;
			for(int i=0,sameCount;i<n;i++) {
				in.nextToken();
				cur = in.sval;
				sameCount = addTree(cur);
				//System.out.println(String.format("%s 有%d 个前缀相同的",cur,sameCount));

				ans -= Math.pow(2, n-2)*sameCount;
			}
			out.println(ans);
		}
		out.flush();
		out.close();
		br.close();
		
	}
	public static void build() {
		cnt = 1;
		for(int[] t:nodes) {
			Arrays.fill(t, 0);
		}
		Arrays.fill(pass, 0);
		
	}
	public static int addTree(String word) {
		int current = 0;
		pass[current]++;
		for(int i=0,next;i<word.length();i++) {
			next = word.charAt(i)-'a';
			if(nodes[current][next] == 0) {
				nodes[current][next] = cnt++;
			}
			current = nodes[current][next];
			pass[current]++;
		}
		return pass[current]-1;
		
	}

}
