package LeetCodeHot100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//测试链接:https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked
public class Solution_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        for(int i=1;i<numRows;i++){
            List<Integer> t = new ArrayList<>();
            t.add(1);
            for(int j=1;j<i;j++){
                t.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            t.add(1);
            list.add(t);
        }
        return list;
    }
}
