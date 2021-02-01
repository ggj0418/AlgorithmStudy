// https://www.acmicpc.net/problem/1531
// 백준 1531번 투명
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bufR.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[101][101];
        int answer = 0;
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bufR.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for(int x=x1;x<=x2;x++) {
                for(int y=y1;y<=y2;y++) {
                    map[x][y]++;
                }
            }
        }
        
        for(int i=1;i<=100;i++) {
            for(int j=1;j<=100;j++) {
                if(map[i][j] > M) answer++;
            }
        }
        
        bufW.write(answer + "\n");
        bufW.flush();
        bufW.close();
        bufR.close();
    }
}

// 그림의 범위가 100, 100 크지 않은 범위이기에 다른 기법을 사용하지 않고 단순 매핑 계산으로 풀었습니다.
// 범위 안에 있는 맵들의 값을 +1 시켜주고 매핑이 다 진행된 이후 한 차례 더 M 초과의 값을 서치하면서 정답을 카운트했습니다.
