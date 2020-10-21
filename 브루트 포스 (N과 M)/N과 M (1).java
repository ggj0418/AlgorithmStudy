// https://www.acmicpc.net/problem/15649
// 백준 15649번 N과 M (1)
import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(bufR.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
        
		boolean[] visited = new boolean[N+1];
		int[] array = new int[M];
        
		backTracking(0,visited, M, N, array);
        
        bufW.write(sb.toString());
        bufW.flush();
        bufW.close();
	}
	
	public static void backTracking(int index, boolean[] visited, int len, int N, int[] array) {
	    if(index == len) {
	        for(int i=0;i<len;i++) {
                sb.append(array[i]);
                sb.append(" ");
            }
            sb.append("\n");
	        return;
	    }
	    
	    for(int i=1;i<=N;i++) {
	        if(!visited[i]) {
	            visited[i] = true;
                array[index] = i;
	            backTracking(index+1, visited, len, N, array);
	            visited[i] = false;
	        }
	    }
	}
}

// 이 문제처럼 중복이 허용된 케이스의 경우는 만들어야하는 수열을 백트래킹의 파라미터로 전달해도 상관없다.
