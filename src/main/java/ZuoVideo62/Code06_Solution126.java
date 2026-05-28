package ZuoVideo62;

import java.util.*;

//测试链接:https://leetcode.cn/problems/word-ladder-ii/
public class Code06_Solution126 {
    public static HashSet<String> word;
    public static HashSet<String> curLevel = new HashSet<>();
    public static HashSet<String> nextLevel = new HashSet<>();

    public static HashMap<String,HashSet<String>> edge = new HashMap<>();

    public static LinkedList<String> tmp = new LinkedList<>();
    public static List<List<String>> ans = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        build(wordList);
        if(bfs(beginWord,endWord)){
            dfs(endWord,beginWord);
        }
        return ans;
    }
    public static void build(List<String> wordList){
        word = new HashSet<>(wordList);
        curLevel.clear();
        nextLevel.clear();
        edge.clear();
        tmp.clear();
        ans.clear();
    }
    public static boolean bfs(String beginWord,String endWord){
        curLevel.add(beginWord);
        boolean isFind = false;
        while(!curLevel.isEmpty()){
            word.removeAll(curLevel);
            for(String str:curLevel){
                char[] chars = str.toCharArray();
                char old;
                for(int i=0;i<chars.length;i++){
                    old = chars[i];
                    for(char t='a';t<='z';t++){
                        chars[i] = t;
                        String tryStr = String.valueOf(chars);
                        if(word.contains(tryStr) && !tryStr.contains(str)){
                            nextLevel.add(tryStr);
                            edge.computeIfAbsent(tryStr,s->new HashSet<>()).add(str);
                        }
                        if(tryStr.equals(endWord)){
                            isFind = true;
                        }
                    }
                    chars[i] = old;
                }
            }
            if(isFind) return true;
            HashSet<String> temp = curLevel;
            curLevel = nextLevel;
            nextLevel = temp;
            nextLevel.clear();
        }
        return false;
    }
    public static void dfs(String curWord,String targetWord){
        tmp.addFirst(curWord);
        if(curWord.equals(targetWord)){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(Objects.isNull(edge.get(curWord))) return;
        for(String pre:edge.get(curWord)){
            dfs(pre,targetWord);
            tmp.removeFirst();
        }
    }

}
