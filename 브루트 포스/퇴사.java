// https://www.acmicpc.net/problem/14501
// 백준 14501번 퇴사
import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(bufR.readLine());
        int[][] map = new int[N+1][2];
		
        for(int i=0;i<N;i++) {
            String[] splitArray = bufR.readLine().split(" ");
		    
            map[i][0] = Integer.parseInt(splitArray[0]);
            map[i][1] = Integer.parseInt(splitArray[1]);
        }
		
        powerSet(0, N, map, 0);
		
        System.out.println(max);
    }
	
    public static void powerSet(int index, int N, int[][] map, int sum) {
        if(index == N) {
            max = Math.max(max, sum);
            return;
        }
	    
        if(index + map[index][0] <= N) {
            powerSet(index + map[index][0], N, map, sum + map[index][1]);
            powerSet(index + 1, N, map, sum);
        } else {
            powerSet(index + 1, N, map, sum);
        }
    }
}
