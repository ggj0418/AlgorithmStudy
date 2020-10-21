// https://www.acmicpc.net/problem/15658
// 백준 15658번 연산자 끼워넣기 (2)
import java.io.*;
 
public class Main {
    static long max = Integer.MIN_VALUE;
    static long min = Integer.MAX_VALUE;
    static int[] operator = new int[4];
    static long[] number;
    static int N;
 
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
 
        N = Integer.parseInt(bufR.readLine());
        number = new long[N];
 
        String[] splitArray = bufR.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(splitArray[i]);
        }
 
        splitArray = bufR.readLine().split(" ");
        for (int j = 0; j < 4; j++) {
            operator[j] = Integer.parseInt(splitArray[j]);
        }
 
        backTracking(number[0], 1);
		
        bufW.write(max + "\n");
        bufW.write(min + "\n");
        bufW.flush();
        bufW.close();
    }
 
    public static void backTracking(long num, int idx) {
        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
				
                switch(i) {
                    case 0:	
                        backTracking(num + number[idx], idx + 1);
                        break;
                    case 1:	
                        backTracking(num - number[idx], idx + 1);
                        break;
                    case 2:	
                        backTracking(num * number[idx], idx + 1);
                        break;
                    case 3:	
                        backTracking(num / number[idx], idx + 1);
                        break;   
                }
				
                operator[i]++;
            }
        }
    }
 
}
