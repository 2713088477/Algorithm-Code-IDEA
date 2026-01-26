package ZuoVideo42;

//吃草问题
//有n颗草，两头牛轮流吃，每次吃只能是4的幂，如果某头牛无草可吃，那么这头牛输掉
//输入n颗草和先开始吃草的牛，返回赢掉游戏的牛
public class WinWithEatGrass {
    public static String eatGrass1(int n, String start){
        return f(n,start);
    }
    public static String f(int n,String cur){
        String enemy = cur.equals("A")?"B":"A";
        if(n==0){
            return enemy;
        }
        int eat = 1;
        while(eat <= n){
            if(f(n-eat,enemy).equals(cur)){
                return cur;
            }
            eat *= 4;
        }
        return enemy;
    }
    public static String eatGrass2(int n, String start){
        String enemy = start.equals("A")?"B":"A";
        if(n%5==0 || n%5==2){
            return enemy;
        }
        return start;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(i+"颗草，赢家是:"+ eatGrass1(i, "A"));
        }
    }
}
