// https://www.acmicpc.net/problem/1264
// 백준 1264번 모음의 개수
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s;
        Pattern p = Pattern.compile("[aeiou]");
        
        StringBuilder sb = new StringBuilder();
        while(!(s = r.readLine().toLowerCase()).equals("#")) {
            Matcher m = p.matcher(s);
            
            int c = 0;
            while (m.find()) {
                c++;
            }
            sb.append(c + "\n");
        }
        
        w.write(sb.toString());
        w.flush();
    }
}

/// 모음 aeiou 중에서 매치되는 값을 넘겼다.
