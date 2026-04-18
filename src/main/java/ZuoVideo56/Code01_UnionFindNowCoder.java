package ZuoVideo56;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

//测试链接：https://www.nowcoder.com/practice/e7ed657974934a30b2010046536a5372
public class Code01_UnionFindNowCoder {
    public static int MAX_SIZE = (int)1e6+1;
    public static int[] father = new int[MAX_SIZE];
    public static int[] size = new int[MAX_SIZE];
    public static int[] stack = new int[MAX_SIZE];
    public static int n,m;
    public static int op,x,y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;
            in.nextToken();
            m = (int)in.nval;
            init();
            for(int i=0;i<m;i++){
                in.nextToken();
                op = (int)in.nval;
                in.nextToken();
                x = (int)in.nval;
                in.nextToken();
                y = (int)in.nval;
                if(op == 1){
                    out.println(isSame(x, y)?"Yes":"No");
                }else if(op == 2){
                    union(x, y);
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void init(){
        for(int i=1;i<=n;i++){
            father[i] = i;
            size[i] =1;
        }
    }
    public static int find(int index){
        int size = 0;
        while(father[index] != index){
            stack[size++] = index;
            index = father[index];
        }
        //扁平化
        while(size>0){
            father[stack[--size]] = index;
        }
        return index;
    }
    public static boolean isSame(int a,int b){
        return find(a) == find(b);
    }
    public static void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(size[fa]>size[fb]){
            father[fb] = fa;
            size[fa] += size[fb];
        }else{
            father[fa] = fb;
            size[fb] += size[fa];
        }

    }
}
