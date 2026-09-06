package ZuoVideo66;

//测试链接: https://leetcode.cn/problems/distinct-subsequences-ii/description/
public class Code08_DistinctSubsequences {
    public static long mod = (long)1e9+7L;
    public int distinctSubseqII(String s) {
        long[] cnt = new long[26];
        long all = 1L;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i)-'a';
            long add = (all-cnt[index] + mod)%mod;
            all =(all + add)%mod;
            cnt[index] = (cnt[index] + add)%mod;
        }
        return (int)((all-1+mod)%mod);
    }
}
