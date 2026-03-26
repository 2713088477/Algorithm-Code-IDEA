package ZuoVideo51;

import java.util.PriorityQueue;

// 计算等位时间
// 给定一个数组arr长度为n，表示n个服务员，每服务一个人的时间
// 给定一个正数m，表示有m个人等位，如果你是刚来的人，请问你需要等多久？
// 假设m远远大于n，比如n <= 10^3, m <= 10^9，该怎么做是最优解？
public class Code06_Google {
    public static int waitingTime1(int[] arr,int m){
        PriorityQueue<int[]>  priorityQueue = new PriorityQueue<>((n1,n2)->  n1[0]-n2[0]);
        int len = arr.length;
        for(int i= 0;i<len;i++){
            priorityQueue.add(new int[]{0,arr[i]});
        }
        for(int i=0;i<m;i++){
            int[] poll = priorityQueue.poll();
            poll[0] += poll[1];
            priorityQueue.add(poll);
        }
        return priorityQueue.peek()[0];
    }
    public static int waitingTime2(int[] arr,int m){
        int min = Integer.MAX_VALUE;
        for(int num:arr){
            min = Math.min(min,num);
        }
        long ans = 0;
        for(long l=0,r=min*m,mid;l<=r;){
            mid = l + ((r-l)>>1);
            if(f(arr,mid)>=m+1){
                ans = mid;
                r = mid -1;
            }else {
                l = mid +1;
            }
        }
        return (int)ans;
    }
    public static long f(int[] arr,long time){
        long ans = 0;
        for (int num : arr) {
            ans += time/num+1;
        }
        return ans;
    }

    // 对数器测试
    public static void main(String[] args) {
        System.out.println("测试开始");
        int N = 50;
        int V = 30;
        int M = 3000;
        int testTime = 20000;
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * N) + 1;
            int[] arr = randomArray(n, V);
            int m = (int) (Math.random() * M);
            int ans1 = waitingTime1(arr, m);
            int ans2 = waitingTime2(arr, m);
            if (ans1 != ans2) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }

    // 对数器测试
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }
}
