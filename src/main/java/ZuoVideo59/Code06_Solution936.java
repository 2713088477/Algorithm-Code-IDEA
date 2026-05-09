package ZuoVideo59;

import java.util.ArrayList;
import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/stamping-the-sequence/description/
public class Code06_Solution936 {
    public int[] movesToStamp(String stamp, String target) {
        char[] s =  stamp.toCharArray();
        char[] t = target.toCharArray();
        int slen = s.length,tlen = t.length;
        int[] indegree = new int[tlen-slen+1];
        Arrays.fill(indegree,slen);
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        for(int i=0;i<tlen;i++){
            edge.add(new ArrayList<>());
        }
        for(int i=0;i<tlen-slen+1;i++){
            for(int j=0;j<slen;j++){
                if(s[j]==t[i+j]){
                    indegree[i]--;
                }else{
                    edge.get(i+j).add(i);
                }
            }
        }
        int[] deque = new int[tlen-slen+1];
        int l=0,r=0;
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                deque[r++] = i;
            }
        }
        int base = 0;
        boolean[] isVisited = new boolean[tlen];
        while(l<r){
            base = deque[l++];
            for(int i=0;i<slen;i++){
                if(!isVisited[base+i]){
                    for(int tar:edge.get(base+i)){
                        if(--indegree[tar] == 0){
                            deque[r++] = tar;

                        }
                    }
                    isVisited[base+i] = true;
                   
                }
            }
        }
        if(r != deque.length){
            return new int[0];
        }else{
            reverse(deque);
            return deque;
        }
    }
    public static void reverse(int[] nums){
        int l=0,r=nums.length-1;
        while(l<r){
            swap(nums, l++, r--);
        }
    }
    public static void swap(int[] nums,int a,int b){
        if(a==b) return;
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
