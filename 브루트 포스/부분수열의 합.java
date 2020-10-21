// https://www.acmicpc.net/problem/1182
// 백준 1182번 부분수열의 합
import java.util.*;
import java.io.*;

class Main {
    static int count = 0;
    static int s;
    public static void main(String[] args) throws Exception {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        String[] splitArray = bufR.readLine().split(" ");
        int n = Integer.parseInt(splitArray[0]);
        s = Integer.parseInt(splitArray[1]);
 
        int[] arr = new int[n];
        splitArray = bufR.readLine().split(" ");
 
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(splitArray[i]);
 
        powerSet(arr, n, 0, 0);        
        // s가 0 일때는 부분집합 중에 공집합인 경우도 카운트 될 수 있음
        if(s == 0) 
            count--;
        
        System.out.println(count);
    }
 
    static void powerSet(int[] arr, int n, int idx, int sum) {
        if(idx == n) {
            if(sum == s) 
                count++;
            return;
        }
 
        powerSet(arr, n, idx + 1, sum);
        powerSet(arr, n, idx + 1, sum + arr[idx]);
    }
}
