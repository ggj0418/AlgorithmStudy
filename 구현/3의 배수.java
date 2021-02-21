// https://www.acmicpc.net/problem/1769
// 백준 1769번 3의 배수
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = in.readLine();
		int count = 0;
		while(input.length() > 1) {
		    int sum = 0;
		    for(int i=0;i<input.length();i++) {
		        sum += input.charAt(i) - '0';
		    }
		    
		    input = String.valueOf(sum);
		    count++;
		}
		
		out.write(count + "\n");
		if(Integer.parseInt(input) % 3 == 0) out.write("YES");
		else out.write("NO");
		
		out.flush();
		out.close();
		in.close();
	}
}

// while문 한번 돌릴때마다 입력값의 자릿수 합을 구하고 입력값에 대입시키는 방식을 반복하고 while이 몇 사이클 돌았는가를 구하면서 입력값의 자릿수가 1이 될때까지 반복한다
// 이후에 한자리가 된 입력값이 3의 배수인가 아닌가를 판별해서 while 사이클 개수와 함께 출력해준다
