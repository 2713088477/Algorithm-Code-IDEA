package ZuoVideo42;

//判断一个数是不是一段连续整数之和
//比如:12=3+4+5
public class JudgeNum {
    //暴力尝试
    public static boolean judge1(int num){
        for(int start =1;start<num-1;start++){
            int sum = start;
            for(int diff = start+1;sum<num;diff++){
                sum += diff;
                if(sum == num){
                    return true;
                }
                if(sum>num){
                    break;
                }
            }
        }
        return false;
    }
    //找出规律后
    public static boolean judge2(int num){
        return (num & (num-1)) != 0;
    }
    public static void main(String[] args) {
        for(int i=1;i<=100;i++){
            System.out.println(i+"的结果是:"+ judge1(i));
            System.out.println(i+"的结果是:"+ judge2(i));
        }
    }

}
