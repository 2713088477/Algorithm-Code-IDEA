package LeetCodeHot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//测试链接:
//TODO 有问题这道题
public class Solution_438 {
    private static Set<Character> set = new HashSet<>();
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        for(int r=0,l=0;r<s.length();r++){
            set.add(s.charAt(r));
            if(check(p)){
                ans.add(l);
                set.remove(s.charAt(l++));
            }
            boolean = p.contains("131
        }
        return ans;
    }
    public static boolean check(String p){
        for(int i=0;i<p.length();i++){
            if(!set.contains(p.charAt(i))) return false;
        }
        return true;

    }

}
