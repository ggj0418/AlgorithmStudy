// https://www.acmicpc.net/problem/2805
// 백준 2805번 나무 자르기
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int max = -1;
        int[] trees = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }
        
        long left = 0;
        long right = max;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            for(int tree : trees) {
                if(tree > mid) {
                    sum += (tree - mid);
                }
            }
            
            if(sum >= m) {    // 잘린 나무가 희망하는 값보다 크거나 같을 경우는 높이를 높여야한다
                left = mid + 1;
            }
            else {            // 잘린 나무가 희망하는 값보다 작은 경우는 높이를 낮춰야한다
                right = mid - 1;
            }
        }
        
        out.write(right + "\n");
        out.flush();
        out.close();
        in.close();
    }
}
