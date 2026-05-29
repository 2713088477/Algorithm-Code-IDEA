package ZuoVideo63;

import java.util.HashSet;
import java.util.List;

//测试链接:https://leetcode.cn/problems/word-ladder/
public class Code01_Solution127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> word = new HashSet<>(wordList);
        HashSet<String> smallLevel = new HashSet<>();
        HashSet<String> nextLevel = new HashSet<>();
        HashSet<String> bigLevel = new HashSet<>();
        if(!word.contains(endWord)) return 0; //注意要先特判
        smallLevel.add(beginWord);
        bigLevel.add(endWord);
        for (int len = 2; !smallLevel.isEmpty(); len++) {
            word.removeAll(smallLevel);
            for(String str : smallLevel){
                char[] chars = str.toCharArray();
                char old;
                for(int i=0;i<chars.length;i++){
                    old = chars[i];
                    for(char t='a';t<='z';t++){
                        chars[i] = t;
                        String tmpStr = String.valueOf(chars);
                        if(bigLevel.contains(tmpStr)){
                            return len;
                        }
                        if(word.contains(tmpStr) && !str.equals(tmpStr)){
                            nextLevel.add(tmpStr);
                        }
                    }
                    chars[i] = old;
                }
            }
            HashSet<String> tmp;
            if(nextLevel.size()<=bigLevel.size()){
                tmp = smallLevel;
                smallLevel = nextLevel;
                nextLevel = tmp;
                nextLevel.clear();
            }else{
                tmp = smallLevel;
                smallLevel = bigLevel;
                bigLevel = nextLevel;
                nextLevel =tmp;
                nextLevel.clear();
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        String[] wordList = {"hot","dot","dog","lot","log","cog"};

        ladderLength("hit","cog",List.of(wordList));
    }

}
