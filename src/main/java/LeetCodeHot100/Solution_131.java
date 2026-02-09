package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_131 {
    private List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        char[] arr = s.toCharArray();
        List<String> list = new ArrayList<>();
        f(list,0,arr);
        return ans;
    }
    public void f(List<String> list,int cur,char[] arr){
        if(cur==arr.length){
            List<String> copy = List.copyOf(list);
            ans.add(copy);
            return;
        }
        int start = cur;int end = start;
        while(end<arr.length){
            if(arr[start] != arr[end]){
                end++;
                continue;
            }
            if(!isStr(arr,start,end)){
                end++;
                continue;
            }
            String t = String.valueOf(arr,start,end-start+1);
            list.add(t);
            f(list,end+1,arr);
            list.remove(list.size()-1);
            end++;
        }
    }
    public boolean isStr(char[] arr,int start,int end){
        while(start<=end){
            if(arr[start]!=arr[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}
