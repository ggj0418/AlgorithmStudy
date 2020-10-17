// https://www.acmicpc.net/problem/10972
// 백준 10972 다음 순열
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		
		boolean flag = false;
		int N = Integer.parseInt(bufR.readLine());
		int[] array = new int[N];
		String[] splitArray = bufR.readLine().split(" ");
		
		for(int i=0;i<N;i++) array[i] = Integer.parseInt(splitArray[i]);
		
		for(int i=N-1;i>=0;i--) {
		    if(i == 0) {
		        flag = true;
		        break;
		    }
		    if(array[i] > array[i-1]) {
                int left = i-1;
                int right = array.length-1;
                while(left < right) {
                    if(array[left] <= array[right]) {
                        int temp = array[left];
                        array[left] = array[right];
                        array[right] = temp;
                        break;
                    }
                    right--;
                }
                
                left = i;
                right = array.length-1;
                
                while(left < right) {
                    int temp2 = array[left];
		            array[left] = array[right];
		            array[right] = temp2;
		            left++;
		            right--;
                }
                
		        break;
		    }
		}
		
		if(flag) System.out.println(-1);
		else {
		    for(int i : array) System.out.print(i + " ");
		}
	}
}
