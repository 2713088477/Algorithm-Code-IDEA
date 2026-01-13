package LeetCodeDaily;

public class SeparateSquare {
    public double separateSquares(int[][] squares) {
        long totalS=0;
        int maxY=0;
        for(int[] t:squares){
            totalS+=((long)t[2]*t[2]);
            maxY=Math.max(maxY,t[1]+t[1]);
        }
        double left=0,right=maxY;
        for(int i=0;i<=50;i++){
            double mid=left+(right-left)/2;
            if(check(squares,mid,totalS)){
                right=mid;
            }else{
                left=mid;
            }
        }
        return (left+right)/2;
    }
    public boolean check(int[][] squares,double mid,long total){
        double sum=0.0;
        for(int[] t:squares){
            if(t[1]<=mid){
                double r=t[2];
                sum+=(r*(Math.min(mid-t[1],r)));
            }
        }
        return sum>=total/2.0;
    }
}
