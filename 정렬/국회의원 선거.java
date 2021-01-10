// https://www.acmicpc.net/problem/1417
// 백준 1417번 국회의원 선거
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bufR.readLine());
		int dasom = Integer.parseInt(bufR.readLine());
		int[] arr = new int[N-1];
        
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(bufR.readLine());
		}	
		
		int min = 0;
		if(N == 1) {	// 후보가 자신 혼자인경우
			bufW.write(0 + "\n");
		} else {
			while(true) {
				Arrays.sort(arr);
				boolean isDasom = true;
				int maxVote = arr.length-1;	// 가장 투표가 많은 후보의 인덱스
				// 후보중 가장 높은 투표를 받은 후보가 다솜이의 투표수 이상인경우
				if(dasom <= arr[arr.length-1]) {
					dasom++;	// 다솜이 투표 +1
					arr[maxVote] --;	// 가장 높은 투표를 받는 후보 -1 
					min++;		// 한명 매수
					isDasom = false;	// 다솜이가 당선이 되지 못했으므로 false로 설정
				}
				if(isDasom)	// 다솜이보다 높은 투표수가 없는경우
				break;
			}
		    
			bufW.write(min + "\n");
		}
		
		bufW.flush();
		bufW.close();
		bufR.close();
	}
}
