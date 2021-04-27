// https://www.acmicpc.net/problem/2579
// 백준 2579번 계단 오르기
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(in.readLine());
        int[][] dp = new int[n+1][2];
        
        // 0은 계단이 가지고 있는 점수, 1은 dp로 쓸 부분
        for(int i = 1; i <= n; i++) {
            dp[i][0] = Integer.parseInt(in.readLine());
        }
        
        dp[1][1] = dp[1][0];
        if(n >= 2) {
            dp[2][1] = dp[1][0] + dp[2][0];
        }
        
        for(int i = 3; i <= n; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-3][1] + dp[i-1][0]) + dp[i][0];
        }
        
        out.write(dp[n][1] + "\n");
        out.flush();
        out.close();
        in.close();
    }
}
