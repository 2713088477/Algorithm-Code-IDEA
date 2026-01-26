package ZuoVideo42;

//背景说明:
//有一个袋子可以装6个或者8个苹果，给你rest个苹果，返回最少需要多少个袋子
public class MinBags {

    public static int bags1(int apple){
        int ans = f(apple);
        return ans == Integer.MAX_VALUE ? -1 :ans;
    }
    public static int f(int rest){
        if(rest < 0) return Integer.MAX_VALUE;
        if(rest == 0) return 0;
        int p1 = f(rest-8);
        int p2 = f(rest-6);
        p1 += p1 == Integer.MAX_VALUE ? 0 : 1;
        p2 += p2 == Integer.MAX_VALUE ? 0 : 1;
        return Math.min(p1,p2);
    }
    public static int bags2(int apple){
        if((apple & 1) != 0){
            return -1;
        }
        if(apple <18){
            if(apple==0) return 0;
            if(apple==6||apple==8) return 1;
            if(apple==12||apple==14||apple==16) return 2;
            return -1;
        }
        return (apple-18)/8+3;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println(i+"个苹果的最小袋子:"+bags1(i));
        }
    }
}
