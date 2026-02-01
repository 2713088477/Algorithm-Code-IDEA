package LeetCodeHot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_22 {

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }
    public static List<String> generate(int n){
        List<String> ans = new ArrayList<>();
        if(n==0){
            ans.add("");
        }else{
            for(int k =0;k<n;k++){
                for (String a : generate(k)) {
                    for (String b : generate(n - k - 1)) {
                        ans.add("("+a+")"+b);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> strings = generate(4);
        System.out.println(strings);
    }
}
