// https://www.acmicpc.net/problem/1759
// 백준 1759번 암호 만들기
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] splitArray = bufR.readLine().split(" ");
		
		int L = Integer.parseInt(splitArray[0]);
		int C = Integer.parseInt(splitArray[1]);
		
		splitArray = bufR.readLine().split(" ");
		Arrays.sort(splitArray);
		
		dfs(L, splitArray, "", 0);
	}
	
	static void dfs(int L, String[] splitArray, String temp, int index) {
	    if(temp.length() == L) {
            int mo = 0, ja = 0;
	        for(int i=0;i<temp.length();i++) {
	            if( temp.charAt(i) == 'a' || temp.charAt(i) == 'e' || temp.charAt(i) == 'i' || temp.charAt(i) == 'o' || temp.charAt(i) == 'u') {
	                mo++;
                } else {
	                ja++;
                }
	        }
	        
	        if(mo > 0 && ja > 1) {
	            System.out.println(temp);
	        }
            
            return;
	    }
	    if(splitArray.length <= index) return;
	    
	    dfs(L, splitArray, temp + splitArray[index], index+1);
	    dfs(L, splitArray, temp, index+1);
	}
}

// 만약 수열의 길이가 고정되어 있고, 특정 차순으로 정렬해야하는 경우에는 위의 경우처럼 다음 원소를 쓸것인가 쓰지 않을것인가 2가지 케이스로 나눠가면서 진행하는게 용이하다
