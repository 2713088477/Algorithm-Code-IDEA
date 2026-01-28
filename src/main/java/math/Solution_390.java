package math;

import java.util.*;


public class Solution_390 {
    public static int lastRemaining1(int n) {
        List<Integer> list = new LinkedList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        return f(list,0);

    }
    public static int f(List<Integer> list, int way){
        if(list.size()==1){
            return list.get(0);
        }
        if(way == 0){
            for(int i=list.size()-1;i>=0;i--){
                if((i%2)==0){
                    list.remove(i);
                }
            }
            return f(list,1);
        }
        else{
            for(int i=list.size()-1;i>=0;i-=2){
               list.remove(i);
            }
            return f(list,0);
        }
    }

    public static void main(String[] args) {
        for(int i=1;i<=1000;i++){
            System.out.println(i+"的长度最后剩余"+lastRemaining1(i));
        }
    }
}
