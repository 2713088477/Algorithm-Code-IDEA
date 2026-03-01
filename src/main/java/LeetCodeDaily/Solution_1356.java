package LeetCodeDaily;
import java.util.Arrays;
public class Solution_1356 {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((a,b)->{
                    int c1 = countOneBits(a);
                    int c2 = countOneBits(b);
                    return c1!=c2?c1-c2:a-b;
                })
                .mapToInt(i-> i)
                .toArray();
    }
    public int countOneBits(int num){
        int count=0;
        while(num!=0){
            num = num&(num-1);
            count++;
        }
        return count;
    }

}
