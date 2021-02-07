// https://www.acmicpc.net/problem/1065
// 백준 1065번 한수
import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
        	int N = Integer.parseInt(in.readLine());
        
        	out.write(go(N) + "\n");
        	out.flush();
 	       out.close();
        	in.close();
	}
 
	private static int go(int N) {
		int answer = 0;
 
        	// 1자리 혹은 2자리 수의 경우 모든 경우가 등차수열이므로 숫자 그대로 리턴
		if (N < 100) {
			return N;
		} 
	        // 3자리의 경우 99까지의 수는 모두 등차수열이므로 미리 더해준다
	        else {
			answer = 99;
 
			for (int i=100;i<=N;i++) {
				int hundred = i / 100;
				int ten = (i / 10) % 10;
				int one = i % 10;
 
        		        // 등차수열인 경우 answer++
				if ((hundred - ten) == (ten - one)) {
					answer++;
				}
			}
		}
 
		return answer;
	}
}
