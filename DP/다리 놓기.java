// https://www.acmicpc.net/problem/1010
// 백준 1010번 다리 놓기
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bufR.readLine());
        
        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(bufR.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[][] dp = new int[N+1][M+1];
            
            for(int i=1;i<=M;i++) dp[1][i] = i;
            
            for(int i=2;i<=N;i++) {
                for(int j=2;j<=M;j++) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }
            }
            
            bufW.write(dp[N][M] + "\n");
        }
        
        bufW.flush();
        bufW.close();
        bufR.close();
    }
}

조합의 성질 중 하나는 n C r = n C r-1 + n-1 C r-1 입니다.
즉, n명 중에서 r 명을 고를 때, 특정 1명을 뽑아놓고 남은 n-1 명중에서 r-1명을 고르는 케이스와 특정 1명을 제외하고 남은 n-1명에서 r명을 고르는 케이스 (서로 독립사건) 를 더하면
n 명 중에서 r 명을 고르는 경우의 수가 나오는 것입니다.
이것을 이 문제에 대입해서 생각해보면 오른편 마을의 개수가 왼편 마을의 개수보다 같거나 크므로 n이고 왼편의 마을 개수가 r 입니다.
이대로 dp 대입해서 bottom to up ?? 사용하면 
