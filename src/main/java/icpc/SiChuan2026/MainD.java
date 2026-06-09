package icpc.SiChuan2026;

import java.io.*;

public class MainD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            int num = (int) in.nval;
            for(int i=0;i<num;i++){
                in.nextToken();
                String word = in.sval;
                out.println(isOk(word)?"YES":"NO");
            }

        }
        out.flush();
        out.close();
        br.close();
    }
    public static boolean isOk(String word){
        int[] carr1 = new int[26];
        int[] carr2 = new int[26];
        for(int i=0;i<word.length();i+=2){
            carr1[word.charAt(i)-'a']++;
            if(i+1<word.length()){
                carr2[word.charAt(i+1)-'a']++;
            }
        }
        if(word.length()%2==0){
            int diff = 0;
            for(int i=0;i<carr1.length;i++){
                diff += Math.abs(carr1[i]-carr2[i]);
            }
            return diff == 0;
        }else{
            int count = 0;
            for(int i=0;i<carr1.length;i++){
                if(carr1[i] % 2 !=0){
                    count++;
                }
            }
            for(int i=0;i<carr2.length;i++){
                if(carr2[i] % 2 !=0){
                    count++;
                }
            }
            return count == 1;
        }
    }
}
