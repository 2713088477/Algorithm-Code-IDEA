package ZuoVideo45;
import java.util.Arrays;

//测试链接:https://www.nowcoder.com/practice/c552d3b4dfda49ccb883a6371d9a6932
public class Code01_Solution {
    public static int MAX_SIZE = 100005;
    public static int[][] node = new int[MAX_SIZE][12];
    public static int[] pass = new int[MAX_SIZE];
    public static int cnt;
    public static void build(){
        cnt = 1;
    }
    public static void clear(){
        for(int i=1;i<=cnt;i++){
            Arrays.fill(node[i],0);
            pass[i]=0;
        }
    }
    public static int calPath(char c){
        if(c=='-') return 10;
        else if(c=='#') return 11;
        else return c-'0';
    }
    public static void insert(String word){
        int cur =1;
        pass[cur]++;
        int path;
        for(int i=0;i<word.length();i++){
            path = calPath(word.charAt(i));
            if(node[cur][path]==0){
                node[cur][path]=++cnt;
            }
            cur = node[cur][path];
            pass[cur]++;
        }
    }
    public static int startWith(String prefix){
        int cur =1;
        int path;
        for(int i=0;i<prefix.length();i++){
            path = calPath(prefix.charAt(i));
            if(node[cur][path]==0) return 0;
            cur = node[cur][path];
        }
        return pass[cur];
    }

    public int[] countConsistentKeys (int[][] b, int[][] a) {
        //将a所有的前缀加入前缀树中
        build();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<a.length;i++){
            builder.setLength(0);
            for(int j=1;j<a[i].length;j++){
                builder.append(String.valueOf(a[i][j]-a[i][j-1])+"#");

            }
            //插入到前缀树中
            insert(builder.toString());

        }
        //统计结果
        int[] ans = new int[b.length];
        for(int i=0;i<b.length;i++){
            builder.setLength(0);
            for(int j=1;j<b[i].length;j++){
                builder.append(String.valueOf(b[i][j]-b[i][j-1])+"#");

            }
            // 查询builder在前缀树中出现了几次
            ans[i] = startWith(builder.toString());
        }
        clear();
        return ans;
    }
}
