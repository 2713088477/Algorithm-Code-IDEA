package ZuoVideo56;

//测试链接:https://leetcode.cn/problems/similar-string-groups/description/
public class Code04_Solution839 {
    public static int MAX_SIZE = 301;
    public static int[] father = new int[MAX_SIZE];
    public static int cnt;
    public int numSimilarGroups(String[] strs) {
        build(strs.length);
        int strLength = strs[0].length();
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                if(!isSame(i, j)){
                    int diff = 0;
                    for(int index=0;index<strLength;index++){
                        if(strs[i].charAt(index)!=strs[j].charAt(index)){
                            diff++;
                        }
                    }
                    if(diff==2||diff==0){
                        union(i, j);
                        cnt--;
                    }
                }
            }
        }
        return cnt;
    }
    public static void build(int size){
        for(int i=0;i<size;i++){
            father[i] = i;
        }
        cnt = size;
    }
    public static int find(int x){
        if(x==father[x]){
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
    public static boolean isSame(int x,int y){
        return find(x)==find(y);
    }
    public static void union(int x,int y){
        int fx = find(x);
        int fy = find(y);
        if(fx!=fy){
            father[fx] = fy;
        }
    }
}
