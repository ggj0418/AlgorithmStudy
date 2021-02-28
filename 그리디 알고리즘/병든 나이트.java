// https://www.acmicpc.net/problem/1783
// 백준 1783번 병든 나이트
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 처음에 방문자가 있는 제일 왼쪽 하단 칸도 포함해야한다
        // 가로 길이가 1이라는 것은 갈 수 있는 어디로도 이동하지 못한다는 뜻.
        if(N == 1) out.write(1 + "\n");
        // 
        else if(N == 2) out.write(Math.min(4, (M+1)/2) + "\n");
        else if(M <= 6) out.write(Math.min(4, M) + "\n");
        else out.write(M-2 + "\n");
        
        out.flush();
        out.close();
        in.close();
    }
}
