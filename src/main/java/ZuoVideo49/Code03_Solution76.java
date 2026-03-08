package ZuoVideo49;

//测试链接:https://leetcode.cn/problems/minimum-window-substring/description/
public class Code03_Solution76 {
    public String minWindow(String s, String t) {
        int len  = Integer.MAX_VALUE;
        int start = -1;
        int[] cnt = new int[256];
        int dept = t.length();
        for(int i=0;i<t.length();i++){
            cnt[t.charAt(i)]--;
        }
        for(int r=0,l=0;r<s.length();r++){
            if(cnt[s.charAt(r)]++<0){
                dept--;
            }
            if(dept==0){
                while(cnt[s.charAt(l)]>0){
                    cnt[s.charAt(l)]--;
                    l++;
                }
                if(r-l+1<len){
                    len = r-l+1;
                    start=l;
                }
            }
        }
        return len == Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
