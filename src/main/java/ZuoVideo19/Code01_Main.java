package ZuoVideo19;

import java.io.*;

public class Code01_Main {
    public static void main(String[] args) throws IOException {
        FileReader input = new FileReader("F:\\code\\Ideal\\AlgorithmCode\\Code\\src\\main\\java\\ZuoVideo19\\input.txt");
        FileWriter output = new FileWriter("F:\\code\\Ideal\\AlgorithmCode\\Code\\src\\main\\java\\ZuoVideo19\\output.txt");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(input);
        PrintWriter out = new PrintWriter(output);
        StreamTokenizer in = new StreamTokenizer(br);
        while(in.nextToken() != StreamTokenizer.TT_EOF){
            double v = in.nval;
            out.println(v);
        }
        out.flush();
        out.close();
        br.close();
    }
}