package simulate;

import java.util.Arrays;
import java.util.Scanner;

public class Lanqiao_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,f(Arrays.copyOf(arr,arr.length),i));
        }
        System.out.println(ans);
        sc.close();
    }
    public static int f(int[] arr,int start){
        int size =arr.length;
        int num = 1;
        int ans =0;
        while(num<=arr.length&&size>0){
            while(arr[start]==-1){
                start=(start+1)%arr.length;
            }
            if(arr[start]==num){
                ans += num;
                arr[start]=-1;size--;
                num=1;
                start = (start+1)%arr.length;
                continue;
            }
            num++;
            start=(start+1)%arr.length;
        }
        return ans;
    }
}
