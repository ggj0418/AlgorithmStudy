// https://www.acmicpc.net/problem/10988
// 백준 10988 팰린드롬인지 확인하기
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = in.readLine();
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - (i + 1))) {
                out.write("0");
                out.flush();
                out.close();
                in.close();
                return;
            }
        }
        
        out.write("1");
        out.flush();
        out.close();
        in.close();
    }
}

// 문자열의 순방향, 역방향대로 진행하면서 서로서로 값이 동일한가 그렇지 않은가를 판단해서 그렇지 않으면 0, 동일하면 1을 출력해준다.
// 이 때에 문자열 길이의 절반까지만 보면 더 적은 양을 보고도 판단할 수 있다
