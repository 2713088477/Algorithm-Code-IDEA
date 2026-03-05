package LeetCodeHot100;

import java.util.HashSet;
import java.util.Set;

//测试链接:https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked
public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 1;
        for(int r=0,l=0;r<s.length();r++){
            while (set.contains(s.charAt(r))){
                set.remove(s.charAt(l++));
            }
            //走到这里一定是不重复的
            set.add(s.charAt(r));
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }

}
