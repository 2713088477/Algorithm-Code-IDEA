package ZuoVideo57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//测试链接:https://leetcode.cn/problems/find-all-people-with-secret/description/
public class Code02_Solution2092 {
    public static int MAX_SIZE = (int)1E5;
    public static int[] father = new int[MAX_SIZE];
    public static boolean[] isKnown = new boolean[MAX_SIZE];
    
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        build(n, firstPerson);
        Arrays.sort(meetings,(a1,a2)->a1[2]-a2[2]);
        int m = meetings.length;
        for(int l=0,r;l<m;){
            r=l;
            while (r<m && meetings[r][2]==meetings[l][2]) {
                r++;
            }
            //[l,r)是可以分享秘密的
            for(int share = l;share<r;share++){
                union(meetings[share][0], meetings[share][1]);
            }
            //如果一轮会议下来，还是不知道秘密，撤销集合
            for(int share = l;share<r;share++){
                if(!isKnown[find(meetings[share][0])]){
                    father[meetings[share][0]] = meetings[share][0];
                    father[meetings[share][1]] = meetings[share][1];
                }
            }
            l=r;
        }
        List<Integer> knowList = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isKnown[find(i)]){
                knowList.add(i);
            }
        }
        return knowList;
    }
    public static void build(int total,int firstPerson){
        for(int i=0;i<total;i++){
            father[i] = i;
            isKnown[i] = false;
        }
        isKnown[0] = true;
        father[firstPerson] = 0;
    }
    public static int find(int a){
        if(a == father[a]) return a;
        father[a] = find(father[a]);
        return father[a];
    }
    public static void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb){
            father[fa] = fb;
            isKnown[fb] |= isKnown[fa];
        }
    }

}
