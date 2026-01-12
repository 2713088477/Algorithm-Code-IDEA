package LeetCodeDaily;

public class CaluMinTimeVisit {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans=0;
        for(int i=0;i<points.length-1;i++){
            int[] curPoint=points[i];
            int[] nextPoint=points[i+1];
            int dx=Math.abs(nextPoint[0]-curPoint[0]);
            int dy=Math.abs(nextPoint[1]-curPoint[1]);
            if(dx==dy){
                ans+=dx;
            }else{
                ans+=Math.max(dx,dy);
            }
        }
        return ans;
    }
}
