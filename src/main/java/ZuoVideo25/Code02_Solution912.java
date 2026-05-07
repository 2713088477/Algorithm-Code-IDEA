package ZuoVideo25;

//测试链接:https://leetcode.cn/problems/sort-an-array/
public class Code02_Solution912 {
    public int[] sortArray(int[] nums) {
        int heapSize = nums.length;
        for(int i=nums.length-1;i>=0;i--){
            heapify(nums, i, heapSize);
        }
        heapSort(nums, heapSize);
        return nums;
    }
    public static void heapify(int[] heap,int index,int heapSize){
        int l = 2*index+1;
        int best = 0;
        while(l<heapSize){
            best = l+1<heapSize && heap[l+1]>heap[l] ? l+1:l;
            best = heap[best] > heap[index] ? best:index;
            if(best == index) break;
            swap(heap, index, best);
            index = best;
            l = 2*index+1;
        }
    }
    public static void swap(int[] nums,int a,int b){
        if(a==b) return;
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    } 
    public static void heapSort(int[] heap,int heapSize){
        while(heapSize>0){
            swap(heap, --heapSize, 0);
            heapify(heap, 0, heapSize);
        }
    }
}
