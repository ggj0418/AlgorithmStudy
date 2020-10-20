// https://www.acmicpc.net/problem/9095
// 백준 9095 1,2,3 더하기

// 모든 경우의 수를 전부 구해보다가 d[i] = d[i-1] + d[i-2] + d[i-3] 이라는 점화식을 발견하였다. 
// 이렇게 특정 수들의 합으로 더 큰 숫자를 구하는 문제는 대부분 이러한 형태의 점화식으로 풀 수 있을 것 같다.
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bufR.readLine());
		int[] array = new int[11];
		
		array[1] = 1;
		array[2] = 2;
		array[3] = 4;
		
		for(int i=4;i<11;i++) {
		    array[i] = array[i-1] + array[i-2] + array[i-3];
		}
		
		for(int i=0;i<T;i++) {
		    System.out.println(array[Integer.parseInt(bufR.readLine())]);
		}
	}
}
