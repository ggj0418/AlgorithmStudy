// https://www.acmicpc.net/problem/1405
// 백준 1405번 미친 로봇

import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static double answer = 0.0000000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        double[] direction = new double[4];
        
        int N = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[31][31];
        
        for(int i=0;i<4;i++) {
            direction[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }
        
        backTracking(15, 15, N, visited, direction, 1.0);
        
        out.write(answer + "\n");
        out.flush();
        out.close();
        in.close();
    }
    
    private static void backTracking(int x, int y, int N, boolean[][] visited, double[] direction, double chance) {
        if(N == 0) {
            answer += chance;
            return;
        }
        
        for(int i=0;i<4;i++) {
            int postX = x + dx[i];
            int postY = y + dy[i];
            
            if(!visited[postX][postY]) {
                visited[x][y] = true;
                N--;
                backTracking(postX, postY, N, visited, direction, chance * direction[i]);
                visited[x][y] = false;
                N++;
            }
        }
    }
}

// 전형적인 백트래킹 문제이다. 로봇이 간 곳을 visited로 체크해주면서 N번 만큼 이동하였을 때 해당 케이스의 확률을 정답 변수에 더해주면 된다.
// 소수점 9자리까지 표현하기 위해서 answer를 선언할때 저렇게 선언해주었다.
