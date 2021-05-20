// https://www.acmicpc.net/problem/11656
// 백준 11656 접미사 배열
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String n = in.readLine();
        String[] answer = new String[n.length()];
        
        for(int i = 0; i < n.length(); i++) {
            answer[i] = n.substring(i);
        }
        
        Arrays.sort(answer);
        
        for(String a : answer) {
            out.write(a + "\n");
        }
        out.flush();
        out.close();
        in.close();
    }
}
