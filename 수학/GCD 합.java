// https://www.acmicpc.net/problem/9613
// 백준 9613번 GCD 합
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bufR.readLine());
        
        for(int i=0;i<n;i++) {
            String[] splitArray = bufR.readLine().split(" ");
            
            int m = Integer.parseInt(splitArray[0]);
            int[] arr = new int[m];
            for(int j=0;j<m;j++) {
                arr[j] = Integer.parseInt(splitArray[j+1]);
            }
            Arrays.sort(arr);
            
            System.out.println(getGcdSum(arr));
        }
    }
    
    private static long getGcdSum(int[] nums) {
        long sum = 0;
        
        for(int left = 0; left<nums.length-1;left++) {
            int right = left + 1;
        
            while(right < nums.length) {
                sum += getGcd(nums[right], nums[left]);
                right++;
            }
        }
        
        return sum;
    }
    
    private static int getGcd(int a, int b) {
        if(b == 0) return a;
        else return getGcd(b, a % b);
    }
}
