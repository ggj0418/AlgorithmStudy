// https://www.acmicpc.net/problem/11726
// 백준 11726번 2xn 타일링
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(bufR.readLine());
        if(num == 1) {
            bufW.write(1 + "\n");
        } else {
            int[] dp = new int[num+1];
		    dp[1] = 1;
		    dp[2] = 2;
		
		    for(int i=3;i<=num;i++) dp[i] = ( dp[i-1] + dp[i-2] ) % 10007;
		
		    bufW.write(dp[num] + "\n");
        }
		
		bufW.flush();
		bufW.close();
		bufR.close();
	}
}

// 쉬운 bottom to up dp 문제이지만 1이라는 케이스를 처리 안해줘서 자꾸 틀렸던 문제이다
