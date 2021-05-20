// https://www.acmicpc.net/problem/1062
// 백준 1062번 가르침
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] answer = new int[1];
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        String[] input = new String[n];
        boolean[] visit = new boolean[26];
        
        if(k < 5) {    // 꼭 쓰이는 값인 anta, tica도 못 채우는 경우
            out.write(0 + "\n");
        }
        else if(k == 26) {    // 모든 알파벳을 다 쓰는 경우
            out.write(n + "\n");
        }
        else {
            for(int i = 0; i < n; i++) {
                String str = in.readLine();
                input[i] = str.substring(4, str.length() - 4);
            }
            
            k -= 5;    // anta, tica 제거
            visit['a'-97] = true;
            visit['n'-97] = true;
            visit['t'-97] = true;
            visit['i'-97] = true;
            visit['c'-97] = true;
            
            backTracking(0, 0, answer, visit, input, k);
            
            out.write(answer[0] + "\n");
        }
        
        out.flush();
        out.close();
        in.close();
    }
    
    private static void backTracking(int index, int count, int[] answer, boolean[] visit, String[] input, int k) {
        if(count == k) {
            int max = 0;
            
            loop: for(String str : input) {
                for(int i = 0; i < str.length(); i++) {
                    if(!visit[str.charAt(i) - 97]) {
                        continue loop;
                    }
                }
                max++;
            }
            
            answer[0] = Math.max(max, answer[0]);
            return;
        }
        
        for(int i = index; i < 26; i++) {
            if(!visit[i]) {
                visit[i] = true;
                backTracking(i + 1, count + 1, answer, visit, input, k);
                visit[i] = false;
            }
        }
    }
}
