package ZuoVideo60;

//测试链接:https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/description/
public class Code04_Solution2127 {
    public int maximumInvitations(int[] favorite) {
        int len = favorite.length;
        int[] indegree = new int[len];
        for(int i=0;i<len;i++) {
        	indegree[favorite[i]]++;
        }
        int[] deque = new int[len];
        int l=0,r=0;
        for(int i=0;i<indegree.length;i++) {
        	if(indegree[i] == 0) {
        		deque[r++] = i;
        	}
        }
        int[] preCount = new int[len];
        int pop,toNode;
        while(l<r) {
        	pop = deque[l++];
        	toNode = favorite[pop];
        	preCount[toNode] = Math.max(preCount[toNode],preCount[pop]+1);
        	if(--indegree[toNode]==0) {
        		deque[r++] = toNode;
        	}
        }
        int numOfsamllRing = 0;
        int numOfBigRing = 0;
        for(int i=0;i<indegree.length;i++) {
        	if(indegree[i]>0) {
        		int ringSize = 1;
        		indegree[i] = 0;
        		for(int j=favorite[i];j!=i;j=favorite[j]) {
        			ringSize++;
        			indegree[j]=0;
        		}
        		if(ringSize == 2) {
        			numOfsamllRing += 2 + preCount[i] +  preCount[favorite[i]];
        		}else {
        			numOfBigRing = Math.max(numOfBigRing, ringSize);
        		}
        		
        	}
        }
        return numOfsamllRing>numOfBigRing ? numOfsamllRing:numOfBigRing;
    }
}
