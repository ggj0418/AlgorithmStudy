// https://www.acmicpc.net/problem/1439
// 백준 1439번 뒤집기
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
	
	    String S = bufR.readLine();
	    int zero = 0;
	    int one = 0;
	    
	    if(S.charAt(0) == '0') zero++;
	    else one++;
	    
	    for(int i=0;i<S.length()-1;i++) {
	        if(S.charAt(i) != S.charAt(i+1)) {
	            if(S.charAt(i+1) == '0') zero++;
	            else one++;
	        }
	    }
		
		bufW.write(Math.min(one, zero) + "\n");
		bufW.flush();
		bufW.close();
		bufR.close();
	}
}
// 연속되는 1, 0 들의 집합을 하나의 숫자로 치부한 뒤 0과 1 집합의 개수가 몇개가 되는지 파악해서 그 중에 더 수가 적은 집합을 골라 출력한다
