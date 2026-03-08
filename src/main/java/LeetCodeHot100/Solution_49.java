package LeetCodeHot100;

import java.util.*;

//测试链接:https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
//TODO 这道题我写的有问题
public class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<char[],List<Integer>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            if(map.containsKey(array)){
                map.get(array).add(i);
            }else{
                map.put(array,new ArrayList<>());
                map.get(array).add(i);
            }
        }
        Set<Map.Entry<char[], List<Integer>>> entries = map.entrySet();
        List<List<String>> ans = new ArrayList<>();
        int index=0;
        for (Map.Entry<char[], List<Integer>> entry : entries) {
            ans.add(new ArrayList<>());
            for (int i = 0; i < entry.getValue().size(); i++) {
                ans.get(index).add(strs[i]);
            }
            index++;

        }
        return ans;
    }
}
