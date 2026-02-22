package ZuoVideo46;

import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/
public class Code07_Solution1371 {
    public int findTheLongestSubstring(String s) {
        //aeiou 00000 -> 11111 共32种状态
        int[] map = new int[32];//map[status] = index //这种状态最早出现的索引
        Arrays.fill(map,-2);//代表这种状态不存在
        map[0]=-1;
        int ans = 0;
        for (int i = 0,status=0,offset; i < s.length(); i++) {
            offset = getOffset(s.charAt(i));
            if(offset!=-1) status ^= 1<<offset;
            if(map[status]!=-2){
                ans = Math.max(ans,i-map[status]);
            }else{
                map[status]=i;
            }
        }
        return ans;
    }
    public int getOffset(char c){
        switch (c){
            case 'a':return 0;
            case 'e':return 1;
            case 'i':return 2;
            case 'o':return 3;
            case 'u':return 4;
            default:return -1;
        }
    }
}
