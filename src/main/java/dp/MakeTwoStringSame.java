package dp;

public class MakeTwoStringSame {
    public int minimumDeleteSum(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int len1=arr1.length,len2=arr2.length;
        if(len1<len2){
            char[] temp=arr1;arr1=arr2;arr2=temp;
            len1=arr1.length;len2=arr2.length;
        }
        int[] dp= new int[len2+1];
        for(int i=1;i<=len2;i++){
            dp[i]=dp[i-1]+arr2[i-1];
        }
        int leftUp=0,temp;
        for(int i=1;i<=len1;i++){
            leftUp=dp[0];
            dp[0]=dp[0]+arr1[i-1];
            for(int j=1;j<=len2;j++){
                temp=dp[j];
                if(arr1[i-1]==arr2[j-1]){
                    dp[j]=leftUp;
                }else{
                    int ans1=dp[j]+arr1[i-1];
                    int ans2=dp[j-1]+arr2[j-1];
                    dp[j]=Math.min(ans1,ans2);
                }
                leftUp=temp;
            }
        }
        return dp[len2];
    }
    public int f(char[] arr1,int len1,char[] arr2,int len2){
        if(len1==0&&len2==0){
            return 0;
        }
        if(len1>0&&len2>0&&arr1[len1-1]==arr2[len2-1]){
            return f(arr1,len1-1,arr2,len2-1);
        }else{
            int ans1=len1>0?f(arr1,len1-1,arr2,len2)+arr1[len1-1]:Integer.MAX_VALUE;
            int ans2=len2>0?f(arr1,len1,arr2,len2-1)+arr2[len2-1]:Integer.MAX_VALUE;
            return Math.min(ans1,ans2);
        }
    }

}
