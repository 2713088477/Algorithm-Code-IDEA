package ZuoVideo67;

//测试链接: https://leetcode.cn/problems/longest-common-subsequence/
public class Code03_LongestCommonSubsequence {
    //最原始的暴力递归
    public int longestCommonSubsequence1(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        return f1(s1,s2,s1.length-1,s2.length-1);
    }
    public int f1(char[] s1,char[] s2,int index1,int index2){
        if(index1 <0 || index2 <0){
            return 0;
        }
        int ans1 = f1(s1,s2,index1-1,index2);
        int ans2 = f1(s1,s2,index1,index2-1);
        int ans3 = f1(s1,s2,index1-1,index2-1);
        int ans4 = s1[index1] == s2[index2] ? ans3 + 1 : 0;
        return Math.max(Math.max(ans1,ans2),Math.max(ans3,ans4));
    }

    //优化后的暴力递归
    //优化1：考虑到后面改从底到顶时候，下标的维护，用长度，而不是用下表
    //优化2：f(s1,s2,index1-1,index2-1) <= f(s1,s2,index1-1,index2)、f(s1,s2,index1-1,index2-1) <= f(s1,s2,index1,index2-1)，所以这个是个废答案
    //优化3：如果s1[index1] == s2[index2]，当前能构成+1的收益，直接构成是对答案最优的(自然智慧，长度变短，答案肯定更小)
    public int longestCommonSubsequence2(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        return f2(s1,s2,s1.length,s2.length);
    }
    public int f2(char[] s1,char[] s2,int len1,int len2){
        if(len1==0 || len2==0){
            return 0;
        }
        //优化3让这个s1[index1-1] == s2[index2-1]变为了互斥条件
        int ans = 0;
        if(s1[len1-1] == s2[len2-1]){
            ans = f2(s1,s2,len1-1,len2-1)+1;
        }else{
            ans = Math.max(f2(s1,s2,len1-1,len2),f2(s1,s2,len1,len2-1));
        }
        return ans;
    }
}
