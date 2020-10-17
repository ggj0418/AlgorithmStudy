// https://www.acmicpc.net/problem/9095
// 백준 9095 1,2,3 더하기
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
