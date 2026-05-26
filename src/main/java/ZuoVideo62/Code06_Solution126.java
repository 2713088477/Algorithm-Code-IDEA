package ZuoVideo62;

import java.util.*;

//测试链接:https://leetcode.cn/problems/word-ladder-ii/
public class Code06_Solution126 {
    public static HashSet<String> word;
    public static HashSet<String> visit = new HashSet<>();
    public static Deque<String> deque = new ArrayDeque<>();

    public static Map<String,HashSet<String>> edge = new HashMap<>();

    public static List<List<String>> ans = new ArrayList<>();
    public static List<String> tmp = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        build(wordList);
        deque.addLast(beginWord);
        if(bfs(endWord)){
            edge.forEach((k,v)-> {
                System.out.println(k+"可以由前面的这些字符串到达");
                v.stream().forEach(System.out::println);
            });
            visit.add(endWord);
            tmp.add(endWord);
            dfs(beginWord,endWord);
        }
//        edge.forEach((k,v)-> {
//            System.out.println(k+"可以由前面的这些字符串到达");
//            v.stream().forEach(System.out::println);
//        });
        return ans;

    }
    public static boolean bfs(String endWord){
        boolean isFind = false;
        while(!deque.isEmpty() && !isFind){
            int len = deque.size();
            for(int t=0;t<len;t++){
                String str = deque.removeFirst();
                char[] chars = str.toCharArray();
                char old;
                for (int i = 0; i < chars.length; i++) {
                    old = chars[i];
                    for(char c='a';c<='z';c++){
                        chars[i] = c;
                        String curStr = String.valueOf(chars);
                        if(word.contains(curStr) && !curStr.equals(str)){
                            deque.addLast(curStr);
                            edge.computeIfAbsent(curStr,s->new HashSet<>()).add(str);
                            //System.out.println(String.format("%s -> %s",str,curStr));
                        }
                        if(curStr.equals(endWord)){
                            isFind = true;
                        }
                    }
                    chars[i] = old;
                }
            }
            if(isFind) return true;
        }
        return isFind;

    }
    public static void dfs(String beginWord,String curWord){
        if(curWord.equals(beginWord)){
            //System.out.println("找到了一条路");
            ans.add(List.copyOf(tmp.reversed()));
            tmp.clear();
            return;
        }
        for(String str:edge.getOrDefault(curWord,new HashSet<>())){
            //System.out.println("答案加入:"+str);
            if(!visit.contains(str)){
                visit.add(str);
                tmp.add(str);
                dfs(beginWord,curWord);
                //System.out.println("答案删除:"+str);
                tmp.remove(str);
                visit.remove(str);
            }

        }

    }
    public static void build(List<String> wordList){
        word = new HashSet<>(wordList);
        deque.clear();
        edge.clear();
        ans.clear();
        tmp.clear();
    }
}
