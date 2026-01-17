package LeetCodeDaily;

public class Solution_3047 {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int r=0;
        for(int i=0;i<bottomLeft.length;i++){
            for(int j=i+1;j<bottomLeft.length;j++){
                int leftX=Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                int leftY=Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                int rightX=Math.min(topRight[i][0],topRight[j][0]);
                int rightY=Math.min(topRight[i][1],topRight[j][1]);
                if(leftX<rightX && leftY<rightY){
                    int t=Math.min(rightX-leftX,rightY-leftY);
                    r=Math.max(r,t);
                }
            }
        }
        return (long)r*(long)r;
    }

}
