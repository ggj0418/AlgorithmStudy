// https://www.acmicpc.net/problem/1476
// 백준 1476 날짜 계산
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
	    String[] splitArray = bufR.readLine().split(" ");
	    
	    int E = Integer.parseInt(splitArray[0]);
	    int S = Integer.parseInt(splitArray[1]);
	    int M = Integer.parseInt(splitArray[2]);
	    
	    while(E != S || S != M) {
	        E += 15;
	        
	        while(S < E) S += 28;
	        while(M < E) M += 19;
	    }
	    
	    System.out.println(E);
	}
}
