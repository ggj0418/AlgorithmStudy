// https://www.acmicpc.net/problem/1620
// 백준 1620번 나는야 포켓몬 마스터 이다솜
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        String[] strs = new String[n + 1];
        for(int i = 1; i <= n; i++) {
            String input = in.readLine();
            map.put(input, i);
            strs[i] = input;
        }
        
        for(int i = 0; i < m; i++) {
            String input = in.readLine();
            
            // 숫자이면
            if('0' <= input.charAt(0) && input.charAt(0) <= '9') {
                out.write(strs[Integer.parseInt(input)] + "\n");
            }
            // 문자이면
            else {
                out.write(map.get(input) + "\n");
            }
        }
        
        out.flush();
        out.close();
        in.close();
    }
}

// Map에서 value로 키를 찾는 로직은 시간 초과가 나므로 String, Integer 파라미터로 이름당 번호를 구하고
// String 배열을 선언해서 번호당 이름을 저장해놓으면 빠르게 풀 수 있다
