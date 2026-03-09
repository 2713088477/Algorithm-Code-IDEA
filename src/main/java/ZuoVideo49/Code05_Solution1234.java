package ZuoVideo49;
//测试链接:https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
public class Code05_Solution1234 {
    public int balancedString(String s) {
        int[] cnt = new int[4];
        int dept =0;
        int n=s.length();
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            cnt[getIndex(s.charAt(i))]++;
        }
        for(int i=0;i<cnt.length;i++){
            cnt[i]=n/4-cnt[i];
            if(cnt[i]<0){
                dept += cnt[i];
            }
        }
        if(dept>=0){
            return 0;
        }
        for(int r=0,l=0;r<s.length();r++){
            if(cnt[getIndex(s.charAt(r))]++ <0){
                dept++;
            }
            if(dept==0){
                while(cnt[getIndex(s.charAt(l))] >0){
                    cnt[getIndex(s.charAt(l))]--;
                    l++;
                }
                if(r-l+1<ans){ans=r-l+1;}

            }
        }
        return ans == Integer.MAX_VALUE?0:ans;
    }
    public static int getIndex(char c){
        return switch (c) {
            case 'Q' -> 0;
            case 'W' -> 1;
            case 'E' -> 2;
            case 'R' -> 3;
            default -> -1;
        };
    }
}
