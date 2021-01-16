// https://www.acmicpc.net/problem/1436
// 백준 1436번 영화감독 숀
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = 0;
		int end = 0;
		
		int N = Integer.parseInt(bufR.readLine());
		
		while(count < N) {
		    end++;
		    if(isEnd(end)) {
		        count++;
		    }
		}
		
		bufW.write(end + "\n");
		bufW.flush();
		bufW.close();
		bufR.close();
	}
	
	private static boolean isEnd(int end) {
	    int cnt = 0;
	    String str = String.valueOf(end);
	    
	    for(int i=0;i<str.length();i++) {
	        if(str.charAt(i) == '6') {
	            cnt++;
	            if(cnt >= 3) return true;
	        } else {
	            cnt = 0;
	        }
	    }
	    
	    return false;
	}
}
// Brute Force로 모든 숫자들을 돌면서 666이 연속으로 나오는가를 조사
