package LeetCodeDaily;


public class Solution_1680 {
    public static int mod = (int)1e9+7;
    public static int concatenatedBinary(int n) {
        StringBuilder builder = new StringBuilder();
        for(int i=1;i<=n;i++){
            builder.append(convertToString(i));
        }
        System.out.println(builder);
        int ans =0;
        for(int i=0;i<builder.length();i++){
            ans = ((ans *2)%mod + (builder.charAt(i)-'0'))%mod ;
        }
        return ans;

    }
    public static String convertToString(int num){
        int start = 31;
        for(int i=31;i>=0;i--){
            if((num&(1<<i))==0){
                start--;
                continue;
            }
            break;
        }
        StringBuilder builder = new StringBuilder();
        while(start>=0){
            builder.append((num&(1<<start))!=0?"1":"0");
            start--;
        }
        return builder.toString();
    }




}
