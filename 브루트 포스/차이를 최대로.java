// https://www.acmicpc.net/problem/10819
// 백준 10819번 차이를 최대로
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> small = new Stack<>();
		Stack<Integer> big = new Stack<>();
		
		int N = Integer.parseInt(bufR.readLine());
		int[] array = new int[N];
		int answer = 0;
		boolean isSmallTurn = true;
		boolean isSmallReverse = false;
		boolean isBigReverse = false;
		
		String[] splitArray = bufR.readLine().split(" ");
		for(int i=0;i<N;i++) array[i] = Integer.parseInt(splitArray[i]);
		Arrays.sort(array);
		
		int left = 0, right = N-1;
		while(left < right) {
		    if(isSmallTurn) {
		        if(isSmallReverse) {
		            small.push(array[right]);
		            right--;
		        } else {
		            small.push(array[left]);
		            left++;
		        }
		        isSmallReverse = !isSmallReverse;
		        isSmallTurn = !isSmallTurn;
		    } else {
		        if(isBigReverse) {
		            big.push(array[left]);
		            left++;
		        } else {
		            big.push(array[right]);
		            right--;
		        }
		        isBigReverse = !isBigReverse;
		        isSmallTurn = !isSmallTurn;
		    }
		    
		    if(left == right) {
		        if(Math.abs(small.peek() - array[left]) > Math.abs(big.peek() - array[left])) {
		            small.push(array[left]);
		        } else {
		            big.push(array[left]);
		        }
		    }
		}
		
		int preSmallValue = -101;
		
		while(!small.isEmpty()) {
		    if(preSmallValue == -101) {
		        preSmallValue = small.pop();
		    } else {
		        int currentSmallValue = small.pop();
		        answer += Math.abs(preSmallValue - currentSmallValue);
		        preSmallValue = currentSmallValue;
		    }
		}
		
		int preBigValue = 101;
		while(!big.isEmpty()) {
		    if(preBigValue == 101) {
		        preBigValue = big.pop();
		    } else {
		        int currentBigValue = big.pop();
		        answer += Math.abs(preBigValue - currentBigValue);
		        preBigValue = currentBigValue;
		    }
		}
		answer += Math.abs(preBigValue - preSmallValue);
		
		System.out.println(answer);
	}
}
