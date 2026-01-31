package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lanqiao_7 {
    public static long mod = (long)1e9+7L;
    public static List<StringBuilder> list = new ArrayList<>();
    static{
        list.add(new StringBuilder("0"));
        list.add(new StringBuilder("1"));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tNum = sc.nextInt();
        for(int i=0;i<tNum;i++){
            int n =sc.nextInt();
        }
        sc.close();
    }
    public static long f(int n){
        int last = list.size()-1;
        while(last+1<n){
            StringBuilder sb = new StringBuilder(list.get(last-1).toString()+list.get(last).toString());
            list.add(sb);
            last++;
        }
        return 0l;

    }
}
