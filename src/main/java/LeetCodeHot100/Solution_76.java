package LeetCodeHot100;

//测试链接:https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked
public class Solution_76 {
    public String minWindow1(String s, String t) {
        int debt = t.length();
        int[] cnt = new int[256];
        for(int i=0;i<t.length();i++){
            cnt[t.charAt(i)]--;
        }
        int startIndex=0;
        int ansLen=Integer.MAX_VALUE;
        for(int l=0,r=0;l<s.length();l++){
            //r指针所在的位置确保[l,r)是包含t的 || r走到头了还是没有找到
            while(r<s.length()&&debt>0){
                if(cnt[s.charAt(r)]<0){
                    debt--;
                }
                cnt[s.charAt(r)]++;
                r++;
            }
            if(debt==0){
                if(r-l+1<ansLen){
                    ansLen = r-l;
                    startIndex = l;
                }

            }
            if(cnt[s.charAt(l)]==0){
                debt++;
            }
            cnt[s.charAt(l)]--;
        }
        return ansLen==Integer.MAX_VALUE?"":s.substring(startIndex,startIndex+ansLen);
    }

}
