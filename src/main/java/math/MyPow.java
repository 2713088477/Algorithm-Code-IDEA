package math;

public class MyPow {
    public static int myPow(int basis,int b){
        if(b==0) return 1;
        int ans = basis;
        while(b/2>0){
            ans *=ans;
            b/=2;
        }
        for(int i=0;i<b;i++){
            ans *= basis;
        }
        return ans;
    }

    public static void main(String[] args) {
        int min = 1,max = (int)1e6;
        System.out.println("测试开始");
        for(int i=0;i<1000;i++){
            int basis = getRandom(min,max);
            int b = getRandom(min,max);

            if(myPow(basis,b)!=Math.pow(basis,b)){
                System.out.println("出错了😒😒");
            }
        }
        System.out.println("测试结束");
    }
    public static int getRandom(int min,int max){
        return (int)Math.random()*(max-min+1) + min;
    }
}
