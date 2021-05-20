// https://www.acmicpc.net/problem/1373
// 백준 1373번 8진수 2진수
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String n = in.readLine();
        
        if(n.length() % 3 == 1) {
            n = "00" + n;
        }
        else if(n.length() % 3 == 2) {
            n = "0" + n;
        }
        for(int i = 0; i < n.length(); i += 3) {
            String temp = "" + n.charAt(i) + n.charAt(i + 1) + n.charAt(i + 2);
            
            sb.append(Integer.parseInt(temp, 2));
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
        in.close();
    }
}
