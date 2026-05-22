package ZuoVideo62;

import java.util.*;

//测试链接:https://leetcode.cn/problems/stickers-to-spell-word/description/
public class Code02_Solution691 {
    public static int MAX_LEN = 500;
    public static String[] deque = new String[MAX_LEN];
    public static int l,r;
    public static List<List<String>> edge = new ArrayList<>(26);
    public static Set<String> visted = new HashSet<>();
    static {
        for(int i=0;i<26;i++){
            edge.add(new ArrayList<>());
        }
    }

    public int minStickers(String[] stickers, String target) {
        for(int i=0;i<26;i++){
            edge.get(i).clear();
        }
        visted.clear();
        l=0;r=0;
        String sortStr;
        for(String str:stickers){
            sortStr = sort(str);
            for(int i=0;i<sortStr.length();i++){
                if(i==0 || sortStr.charAt(i)!=sortStr.charAt(i-1)){
                    edge.get(sortStr.charAt(i)-'a').add(sortStr);
                }
            }
        }
        visted.add(target);
        target = sort(target);
        deque[r++] = target;
        int level = 0,size = 0;
        String pop;
        while(l<r){
            level++;
            size = r-l;
            for(int i=0;i<size;i++){
                pop = deque[l++];
                for(String str : edge.get(pop.charAt(0)-'a')){
                    String next = compute(pop,str);
                    if(next.equals("")){
                        return level;
                    }
                    if(!visted.contains(next)){
                        deque[r++] = next;
                        visted.add(next);
                    }

                }
            }

        }
        return -1;

    }
    public static String sort(String str){
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
    public static String compute(String origin,String word){
        int oi=0,wi=0;
        StringBuilder builder = new StringBuilder();
        while(oi<origin.length() && wi<word.length()){
            if(origin.charAt(oi)==word.charAt(wi)){
                oi++;
                wi++;
            }else if(origin.charAt(oi)<word.charAt(wi)){
                builder.append(origin.charAt(oi));
                oi++;
            }else{
                wi++;
            }
        }
        while (oi<origin.length()){
            builder.append(origin.charAt(oi++));
        }
        return builder.toString();
    }
}
