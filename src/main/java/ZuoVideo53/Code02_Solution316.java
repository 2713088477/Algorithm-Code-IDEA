package ZuoVideo53;

import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/remove-duplicate-letters/
public class Code02_Solution316 {
    public static int MAX_SIZE = 26+1;
    public static int[] stack = new int[MAX_SIZE];
    public static int sLen = 0;
    public static int[] count = new int[MAX_SIZE];
    public static boolean[] isExist = new boolean[MAX_SIZE];

    public static String removeDuplicateLetters(String s) {
        sLen = 0;
        Arrays.fill(count,0);
        Arrays.fill(isExist,false);
        //统计词频
        char[] array = s.toCharArray();
        for(char c:array){
            count[c-'a']++;
        }

        for(char c:array){
            if(!isExist[c-'a']){
                while(sLen>0 && count[stack[sLen-1]]>0 && c-'a'< stack[sLen-1]){
                    isExist[ stack[sLen-1]] = false;
                    sLen--;
                }
                stack[sLen++] = c-'a';
                isExist[c-'a'] = true;
            }
            count[c-'a']--;
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<sLen;i++){
            builder.append((char)(stack[i]+'a'));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
    }
}
