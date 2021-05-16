// https://www.acmicpc.net/problem/1654
// 백준 1654번 랜선 자르기
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long max = -1;
        long[] lines = new long[n];
        for(int i = 0; i < n; i++) {
            lines[i] = Integer.parseInt(in.readLine());
            max = Math.max(lines[i], max);
        }
        
        long left = 1;
        long right = max;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            for(long line : lines) {
                sum += line / mid;
            }
            
            // 위치 조정
            if(sum >= m) {    
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        out.write(right + "\n");
        out.flush();
        out.close();
        in.close();
    }
}
