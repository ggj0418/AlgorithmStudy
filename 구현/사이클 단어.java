// https://www.acmicpc.net/problem/1544
// 백준 1544번 사이클 단어
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(in.readLine());
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<N;i++) go(set, in.readLine());
        
        out.write(String.valueOf(set.size()));
        out.flush();
        out.close();
        in.close();
    }
    
    private static void go(Set<String> set, String input) {
        int len = input.length();
        StringBuilder sb = null;
        
        for(String word : set) {
            sb = new StringBuilder(word);
            for(int i=0;i<len;i++) {
                if(input.equals(sb.toString())) {
                    return;
                } else {
                    sb.append(sb.charAt(0)).deleteCharAt(0);
                }
            }
        }
        set.add(input);
    }
}

/*
자체적으로 중복을 허용하지 않는 Set Collection을 활용해서 문제를 풀었습니다.
입력값을 이전에 Set에 들어있는 문자열들과 비교해보고 동일하면 입력값을 Set에 넣지 않고 넘깁니다.
이 때에 입력값을 시계방향으로 글자 하나하나씩 옮겨가면서 비교합니다. (sb.append(sb.charAt(0)).deleteCharAt(0))
Set에 동일한 값이 없으면 입력값을 Set에 넣고 go 함수를 종료시킵니다.
모든 입력값에 대하여 위의 과정을 거친 후, Set의 size를 리턴시키면 서로 다른 문자의 개수가 리턴되어 문제를 해결할 수 있습니다
*/
