import dp.FindMaxChain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindMaxChainTest {

    @Test
    @DisplayName("测试函数")
    public void f(){
        FindMaxChain chain = new FindMaxChain();
        int[][] arr = {
                {7, 9},
                {4, 5},
                {7, 9},
                {-7, -1},
                {0, 10},
                {3, 10},
                {3, 6},
                {2, 3}
        };
        int res = chain.findLongestChain(arr);
        System.out.println(res);
    }
}
