package Luogu;

import java.io.*;
import java.util.Arrays;

//TODO:这道题有问题
public class Main_p1666 {
	public static int MAX_LEN = 51;
	public static int[][] nodes = new int[MAX_LEN][26];
	public static int[] end = new int[MAX_LEN];
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
			System.out.println("ans="+ans);
			String cur;
			for(int i=0,sameCount;i<n;i++) {
				in.nextToken();
				cur = in.sval;
				sameCount = addTree(cur);
				System.out.println(String.format("%s这个字符串重复的次数:%d", cur,sameCount));
				System.out.println(String.format("减少的答案数:%d", (int)Math.pow(2, n-2)*sameCount));
				ans -= Math.pow(2, n-2)*sameCount;
			}
			out.println(ans);
		}
		out.flush();
		out.close();
		br.close();
		
	}
	public static void build() {
		for(int[] t:nodes) {
			Arrays.fill(t, -1);
		}
		Arrays.fill(end, 0);
		
	}
	public static int addTree(String word) {
		int sameCount = 0;
		int current = 0;
		for(int i=0,next;i<word.length();i++) {
			next = word.charAt(i)-'a';
			if(nodes[current][next] == -1) {
				nodes[current][next] = cnt++;
			}
			current = nodes[current][next];
			if(end[current] != 0) {
				sameCount++;
			}
		}
		end[current]++;
		return sameCount;
		
	}

}
