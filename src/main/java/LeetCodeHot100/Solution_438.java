package LeetCodeHot100;

import java.util.*;

//测试链接:
//TODO 有问题这道题
public class Solution_438 {
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        char[] array = p.toCharArray();
        Arrays.sort(array);

        for(int r=0,l=0;r<s.length();r++){
            if(r-l+1 != p.length()) continue;
            char[] comp = s.substring(l, r + 1).toCharArray();
            Arrays.sort(comp);
            if(Arrays.equals(comp, array)){
                ans.add(l);
            }
            l++;
        }
        return ans;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        int[] pcount = new int[26];
        int[] scount = new int[26];
        List<Integer> ans = new ArrayList<>();
        for (char c:p.toCharArray()){
            pcount[c-'a']++;
        }
        for(int r=0,l=0;r<s.length();r++){
            if(r-l+1<p.length()){
                scount[s.charAt(r)-'a']++;
                continue;
            }
            scount[s.charAt(r)-'a']++;
            if(Arrays.equals(scount,pcount)){
                ans.add(l);
            }
            scount[s.charAt(l)-'a']--;
            l++;

        }
        return ans;

    }


}
