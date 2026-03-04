package ZuoVideo48;

import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/xepqZ5/
public class Code05_SolutionLCP74 {
    public int fieldOfGreatestBlessing(int[][] forceField) {
        int len = forceField.length;
        //这里记录立场的所有x坐标
        long[] x = new long[len*2];
        //这里记录立场所有的y坐标
        long[] y = new long[len*2];
        for(int i=0;i<len;i++){
            //这里进行坐标转换,目的是防止出现0.5
            x[i*2] = 2L *forceField[i][0] - forceField[i][2];
            x[i*2+1] = 2L *forceField[i][0] + forceField[i][2];
            y[i*2] = 2L *forceField[i][1] - forceField[i][2];
            y[i*2+1] = 2L *forceField[i][1] + forceField[i][2];
        }
        int xsize = sortReturnSize(x);
        int ysize = sortReturnSize(y);
        int[][] diff = new int[xsize+2][ysize+2];
        for(int i=0;i<forceField.length;i++){
            long lx = 2L *forceField[i][0] - forceField[i][2];
            long ly = 2L *forceField[i][1] - forceField[i][2];
            long rx = 2L *forceField[i][0] + forceField[i][2];
            long ry = 2L *forceField[i][1] + forceField[i][2];
            //这里的search是离散化,就是不根据坐标的值的大小去开辟空间,而是根据值的个数去开辟，然后再做映射
            add(diff,search(x,xsize,lx),search(y,ysize,ly),search(x,xsize,rx),search(y,ysize,ry));
        }
        int ans = 1;
        for(int i=1;i<diff.length;i++){
            for(int j=1;j<diff[0].length;j++){
                diff[i][j] += diff[i-1][j] +diff[i][j-1]-diff[i-1][j-1];
                ans = Math.max(ans,diff[i][j]);
            }
        }
        return ans;
    }
    public static int search(long[] arr,int size,long target){
        int left=0,right=size-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]<target) left= mid+1;
            else if(arr[mid]>target) right=mid-1;
            else return mid+1;
        }
        return -1;
    }

    public static void add(int[][] diff,int lx,int ly,int rx,int ry){
        diff[lx][ly] += 1;
        diff[lx][ry+1] -=1;
        diff[rx+1][ly]-=1;
        diff[rx+1][ry+1]+=1;
    }
    public static int sortReturnSize(long[] nums){
        Arrays.sort(nums);
        int size = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[size++]=nums[i];
            }
        }
        return size;
    }

}
