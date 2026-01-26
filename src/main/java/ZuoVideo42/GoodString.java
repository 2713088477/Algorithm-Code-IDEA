package ZuoVideo42;

//给你一个长度n,用"r","e","d"三个字母拼出这个长度为n的字符串，返回所有的拼法中，有多少字符串是好串
//好串的定义如下:该字符串中的所有字串，有且仅有一个字串是长度>=2的回文串
public class GoodString {
    public static int getGoodString1(int n){
        char[] path = new char[n];
        return f(path,0);
    }
    public static int f(char[] path,int cur){
        if(cur == path.length){
            int num = 0;
            for(int i=0;i<path.length;i++){
                for(int j=i+1;j<path.length;j++){
                    if(isOk(path,i,j)){
                        num++;
                    }
                    if(num>1) return 0;
                }
            }
            return num;
        }
        int ans = 0;
        path[cur]='r';
        ans += f(path,cur+1);
        path[cur]='e';
        ans += f(path,cur+1);
        path[cur]='d';
        ans += f(path,cur+1);
        return ans;
    }

    private static boolean isOk(char[] path, int l, int r) {
        while (l<r){
            if(path[l]!=path[r]) return false;
            l++;
            r--;
        }
        return true;
    }
    public static int getGoodString2(int n){
        if(n==1) return 0;
        if(n==2) return 3;
        if(n==3) return 18;
        return 30+(n-4)*6;
    }

    public static void main(String[] args) {
        for(int i=1;i<=100;i++){
            System.out.println(i+"的长度的好串有:"+ getGoodString1(i)+"个");
        }
    }
}
