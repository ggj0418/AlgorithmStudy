// https://www.acmicpc.net/problem/1463
// 백준 1463번 1로 만들기
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {        
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int N = Integer.parseInt(bufR.readLine());
        int[] dp = new int[N+1];
		
        dp[0] = 0;
	dp[1] = 0;
		
        for(int i=2;i<=N;i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
        }
		
        bufW.write(dp[N] + "\n");
        bufW.flush();
        bufW.close();
    }
}

// Bottom to up 방식을 사용해서 순차적으로 구하는 방식으로 해결
