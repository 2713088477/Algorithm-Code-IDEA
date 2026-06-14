package practice;

import java.util.HashSet;
import java.util.List;


//测试链接:https://leetcode.cn/problems/word-ladder/
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> word = new HashSet<>(wordList);
        if(!word.contains(endWord)) return 0;
        HashSet<String> small = new HashSet<>();
        HashSet<String> big = new HashSet<>();
        HashSet<String> nextLevel = new HashSet<>();
        small.add(beginWord);big.add(endWord);
        int level = 2;
        while(!small.isEmpty()){
            for(String curWord:small){
                char[] chars = curWord.toCharArray();
                for(int i=0;i<chars.length;i++){
                    char old = chars[i];
                    for(char tmp='a';tmp<='z';tmp++){
                        chars[i] = tmp;
                        String newWord = String.valueOf(chars);
                        if(big.contains(newWord)){
                            return level;
                        }
                        if(!newWord.equals(curWord) && word.contains(newWord)){
                            word.remove(newWord);
                            nextLevel.add(newWord);
                            System.out.println(String.format("在%d层找到了%s",level,newWord));
                        }
                    }
                    chars[i] = old;
                }
            }
            level++;

            small.clear();
            if(nextLevel.size()>big.size()){
                HashSet<String> tmp = big;
                big = nextLevel;
                nextLevel = small;
                small = tmp;
            }else{
                HashSet<String> tmp = small;
                small = nextLevel;
                nextLevel = tmp;
            }
        }
        return 0;
    }
}
