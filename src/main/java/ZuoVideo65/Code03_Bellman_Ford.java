package ZuoVideo65;

import java.util.Arrays;

/**
 * 这道题不是严格地bellman-ford,因为原始的算法每一轮是实时看distance去算的
 * 而这道题不是，这道题是有自己的一个题意，需要看上一轮的distance
 */
//测试链接: https://leetcode.cn/problems/cheapest-flights-within-k-stops/description/
public class Code03_Bellman_Ford {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;
        //这里注意循环k轮
        for(int i=0;i<=k;i++){
            int[] nextDistance = Arrays.copyOf(distance, n);
            for(int[] flight:flights){
                int from = flight[0],to = flight[1],value = flight[2];
                if( distance[from] != Integer.MAX_VALUE &&  nextDistance[to] > distance[from] + value){
                    nextDistance[to] = distance[from] + value;
                }
            }
            distance = nextDistance;
        }
        return distance[dst] == Integer.MAX_VALUE ? -1: distance[dst];
    }
}
