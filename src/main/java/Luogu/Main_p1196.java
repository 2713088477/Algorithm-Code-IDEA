package Luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

//测试链接:https://www.luogu.com.cn/problem/P1196
//TODO:有问题
public class Main_p1196 {
    public static int MAX_SIZE = 30001;
    public static int[] father = new int[MAX_SIZE];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        build();
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            int t = (int)in.nval;
            String op;
            int a,b;
            for(int i=0;i<t;i++){
                in.nextToken();
                op = in.sval;
                in.nextToken();
                a = (int)in.nval;
                in.nextToken();
                b = (int)in.nval; 
                if(op.equals("M")){
                    union(a, b);fcddf
                }else if(op.equals("C")){
                    out.println(query(a, b));
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }
    public static void build(){
        for(int i=1;i<MAX_SIZE;i++){
            father[i] = i;
        }
    }
    public static int find(int a){
        if(a != father[a]){
            father[a] = find(father[a]);
        }
        return father[a];
    }
    public static void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(fa>fb){
            father[fb] = fa;
        }else if(fa<fb){
            father[fa] = fb;
        }
    }
    public static int query(int a,int b){
        int fa =find(a);
        int fb =find(b);
        if(fa != fb){
            return -1;
        }else{
            return Math.abs(b-a)-1;
        }
    }
}
