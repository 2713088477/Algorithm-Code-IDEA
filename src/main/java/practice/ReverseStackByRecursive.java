package practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ReverseStackByRecursive {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        System.out.println("原本的stack:" + stack);
        reverseStack1(stack);
        System.out.println("逆序之后:"+stack);
        reverseStack2(stack);
        System.out.println("zai逆序之后:"+stack);
    }
    public static void reverseStack1(Deque<Integer> stack){
        reverse1(stack,new ArrayList<Integer>());
    }
    public static void reverse1(Deque<Integer> stack, List<Integer> list){
        if(stack.isEmpty()){
            return;
        }
        Integer pop = stack.pop();
        list.add(pop);
        reverse1(stack,list);
        stack.push(list.get(stack.size()));
    }

    public static void reverseStack2(Deque<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int bottom = popBottom(stack);
        reverseStack2(stack);
        stack.push(bottom);
    }
    public static int popBottom(Deque<Integer> stack){
        Integer pop = stack.pop();
        if(stack.isEmpty()){
            return pop;
        }
        int ans = popBottom(stack);
        stack.add(pop);
        return ans;
    }
}
