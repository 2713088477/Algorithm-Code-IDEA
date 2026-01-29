package LeetCodeHot100;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_17 {
    private static Map<Character,List<Character>> map = new HashMap<>();
    static {
        map.put('2',List.of('a','b','c'));map.put('3',List.of('d','e','f'));
        map.put('4',List.of('g','h','i'));map.put('5',List.of('j','k','l'));
        map.put('6',List.of('m','n','o'));map.put('7',List.of('p','q','r','s'));
        map.put('8',List.of('t','u','v'));map.put('9',List.of('w','x','y','z'));
    }
    private List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        char[] array = digits.toCharArray();
        char[] ansArr = new char[array.length];
        f(array,ansArr,0);
        return ans;
    }
    public void f(char[] arr,char[] ansArr,int size){
        if(size == arr.length){
            ans.add(new String(ansArr));
            return;
        }
        Character num = arr[size];
        List<Character> characters = map.get(num);
        for (int i = 0; i < characters.size(); i++) {
            ansArr[size]=characters.get(i);
            f(arr,ansArr,size+1);
        }
    }
}
