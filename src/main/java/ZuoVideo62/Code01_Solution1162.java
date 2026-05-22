package ZuoVideo62;

//测试链接:https://leetcode.cn/problems/as-far-from-land-as-possible/description/
public class Code01_Solution1162 {
	public static int MAX_ROW = 101;
	public static int MAX_COL = 101;
	public static int[][] deque = new int[MAX_ROW*MAX_COL][2];
	public static int l=0,r=0;
	public static boolean[][] visited = new boolean[MAX_ROW][MAX_COL]; 
	
	//上，右，下, 左
	public static int[] direction = {-1,0,1,0,-1};
    public int maxDistance(int[][] grid) {
    	l=0;r=0;
    	int landCount = 0;
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid[0].length;j++) {
    			if(grid[i][j] == 1) {
    				visited[i][j] = true;
    				deque[r][0] = i;
    				deque[r++][1] = j;
    				landCount++;
    			}else {
    				visited[i][j] = false;
    			}
    		}
    	}
    	if(landCount==0 || landCount == grid.length*(grid[0].length) ) {
    		return -1;
    	}
    	int level = 0;
    	while(l<r) {
    		int size = r-l;
    		for(int i=0,nx,ny;i<size;i++) {
    			int[] pop = deque[l++];
    			for(int j=0;j<4;j++) {
    				nx = pop[0] + direction[j];
    				ny = pop[1] + direction[j+1];
    				if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length) {
    					continue;
    				}
    				if(!visited[nx][ny]) {
    					visited[nx][ny] = true;
    					deque[r][0] = nx;
    					deque[r++][1] = ny;
    				}
    			}
    		}
    		level++;
    	}
    	return level-1;
        
    }
}
