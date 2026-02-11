package ZuoVideo19;

import java.io.*;

public class Code02_Main {
    public static String line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while((line= br.readLine()) != null){
            String[] split = line.split(" ");
            int sum = 0;
            for (String s : split) {
                sum += Integer.valueOf(s);
            }
            out.println(sum);
        }
        out.flush();
        out.close();
        br.close();
    }
}
