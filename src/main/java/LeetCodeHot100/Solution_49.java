package LeetCodeHot100;

import java.util.*;

//测试链接:https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
//TODO 这道题我写的有问题
public class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        for (Map.Entry<String, List<String>> entry : entries) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
