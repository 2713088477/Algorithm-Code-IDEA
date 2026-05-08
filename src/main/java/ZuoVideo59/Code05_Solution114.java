package ZuoVideo59;

import java.util.ArrayList;
import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/Jf1JuT/
public class Code05_Solution114 {
    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        for(String word:words){
            for(int i=0;i<word.length();i++){
                indegree[word.charAt(i)-'a'] = 0;
            }
        } 
        int needCount = 0;
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)needCount++;
        }
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        for(int i=0;i<26;i++){
            edge.add(new ArrayList<>());
        }
        String curStr,nextStr;
        for(int i=0,curIndex,nextIndex,len;i+1<words.length;i++){
            curStr = words[i];
            nextStr = words[i+1];
            curIndex = 0;nextIndex=0;
            len = Math.min(curStr.length() , nextStr.length());
            while(curIndex<len){
                if(curStr.charAt(curIndex) != nextStr.charAt(nextIndex)){
                    edge.get(curStr.charAt(curIndex)-'a').add(nextStr.charAt(nextIndex)-'a');
                    indegree[nextStr.charAt(nextIndex)-'a']++;
                    break;
                }
                curIndex++;
                nextIndex++;

            }
            if(curIndex == len && curStr.length()>len) return "";
        }
        int[] deque = new int[26];
        int l=0,r=0;
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                deque[r++] = i;
            }
        }
        StringBuilder builder = new StringBuilder();
        int count = 0;
        while(l<r){
            for(int node:edge.get(deque[l])){
                if(--indegree[node]==0){
                    deque[r++] = node; 
                }
            }
            count++;
            builder.append((char)('a'+deque[l++]));
        }
        return needCount==count?builder.toString():"";
    }
}
