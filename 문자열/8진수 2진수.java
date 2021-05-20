// https://www.acmicpc.net/problem/1212
// 백준 1212번 8진수 2진수
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String n = in.readLine();
        
        for(int i = 0; i < n.length(); i++) {
            String temp = Integer.toBinaryString(n.charAt(i) - '0');
            if(i != 0) {
                if(temp.length() == 2) {
                    temp = "0" + temp;
                }
                else if(temp.length() == 1) {
                    temp = "00" + temp;
                }
            }
            
            sb.append(temp);
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
        in.close();
    }
}
