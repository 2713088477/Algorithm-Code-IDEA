package ZuoVideo25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.StringJoiner;

//测试链接:https://www.luogu.com.cn/problem/P1177
//从顶到底建立堆结构
public class Code01_HeapSortTopToBottom {
    //完全二叉树与数组的对应
    //下标i父亲节点: (i-1)/2
    //下标节点i的左孩子: i*2 + 1 右孩子: i*2 + 2
    public static int MAX_SIZE = (int)1E5+1;
    public static int[] maxHeap = new int[MAX_SIZE];
    public static int heapSize = 0;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int)in.nval;
            for(int i=0;i<n;i++){
                in.nextToken();
                heapInsert((int)in.nval);
            }
            heapSort();
            StringJoiner joiner = new StringJoiner(" ");
            for(int i=0;i<n;i++){
                joiner.add(String.valueOf(maxHeap[i]));
            }
            out.println(joiner.toString());
        }
        clear();
        out.flush();
        out.close();
        br.close();
    }
    
    public static void heapInsert(int num){
        int index = heapSize++;
        maxHeap[index] = num;
        while(maxHeap[index] > maxHeap[(index-1)/2]){
            swap(maxHeap, index, (index-1)/2);
            index = (index-1)/2;
        }
    }
    public static void heapify(int index){
        int l = index*2+1;
        int best= 0;
        while (l<heapSize) {
            best = l+1<heapSize && maxHeap[l+1]>maxHeap[l] ? l+1:l;
            best = maxHeap[best] > maxHeap[index] ? best : index;
            if(best == index) break;
            swap(maxHeap, index, best);
            index = best;
            l = index*2+1;
        }
    }
    public static void swap(int[] nums,int a,int b){
        if(a==b) return;
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
    public static void heapSort(){
        while(heapSize>0){
            swap(maxHeap, --heapSize, 0);
            heapify(0);
        }
        
    }
    public static void clear(){
        heapSize = 0;
    }

}
