package ZuoVideo61;

import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/checking-existence-of-edge-length-limited-paths/
public class Code05_LeetCode1697 {
	public static int MAX_NODE = (int)1E5+1;
	public static int[] father = new int[MAX_NODE];
	
	
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int qLen = queries.length;
        build(n);
        int[][] qArr = new int[qLen][4];
        for(int i=0;i<queries.length;i++) {
        	qArr[i][0] = queries[i][0];
        	qArr[i][1] = queries[i][1];
        	qArr[i][2] = queries[i][2];
        	qArr[i][3] = i;
        }
        boolean[] ans = new boolean[qLen];
        Arrays.sort(edgeList,(e1,e2)->e1[2]-e2[2]);
        Arrays.sort(qArr,(q1,q2)->q1[2]-q2[2]);
        for(int i=0,j=0;i<qLen;i++) {
            while(j<edgeList.length && qArr[i][2] > edgeList[j][2]){
                union(edgeList[j][0],edgeList[j][1]);
        		j++;
            }
        	ans[qArr[i][3]] = isSameSet(qArr[i][0],qArr[i][1]);
        }
        return ans;
        
    }
    public static void build(int n) {
    	for(int i=0;i<n;i++) {
    		father[i] = i;
    	}
    }
    public static int find(int x) {
    	if(x!=father[x]) {
    		father[x] = find(father[x]);
    	}
    	return father[x];
    }
    public static void union(int x,int y) {
    	int fx = find(x);
    	int fy = find(y);
    	if(fx != fy) {
    		father[fy] = fx;
    	}
    }
    public static boolean isSameSet(int x,int y) {
    	return find(x)==find(y);
    }
    
}
