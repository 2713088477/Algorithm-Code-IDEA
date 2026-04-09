package LeetCodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_56 {
    //二维数组排序
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(arr1,arr2)->{
            return arr1[0]!=arr2[0]?arr1[0]-arr2[0]:arr1[1]-arr2[1];
        });
        List<int[]> ans = new ArrayList<>();
        int[] pre = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(pre[1]>=intervals[i][0]){
                pre[0] = Math.min(pre[0],intervals[i][0]);
                pre[1] = Math.max(pre[1],intervals[i][1]);
            }else{
                ans.add(pre);
                pre = intervals[i];
            }
        }
        ans.add(pre);
        int[][] answer = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            answer[i][0] = ans.get(i)[0];
            answer[i][1] = ans.get(i)[1];
        }
        return answer;
    }
}
