// https://www.acmicpc.net/problem/15650
// 백준 15650번 N과 M (2)
import java.io.*;
import java.util.*;

public class Main {
    public static int M, N;
    public static StringBuilder sb = new StringBuilder();
    public static List<Integer> list = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splitArray = bufR.readLine().split(" ");
		
		M = Integer.parseInt(splitArray[0]);
		N = Integer.parseInt(splitArray[1]);
		
		backTracking(1);
		
		System.out.println(sb.toString());
	}
	
	public static void backTracking(int index) {
	    if(list.size() == N) {
	        for(int i=0;i<list.size();i++) sb.append(list.get(i)).append(" ");
	        sb.append("\n");
	        
	        return;
	    }
	    
	    for(int i = index ; i <= M ; i++) {
	        list.add(i);
	        backTracking(i+1);
	        list.remove(list.size()-1);
	    }
	}
}

// 하지만 이 문제처럼 사전순으로 배열해야하는 경우에는 출력해야하는 수열을 담는 list를 전역으로 선언해줘야 값이 꼬이지 않는다 (이유는 왜 그런지 모르겠다)
