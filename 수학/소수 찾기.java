// https://www.acmicpc.net/problem/1978
// 백준 1978 소수찾기
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        
        int n = Integer.parseInt(bufR.readLine());
        String[] splitArray = bufR.readLine().split(" ");
        
        for(int i=0;i<n;i++) {
            if(isPrime(Integer.parseInt(splitArray[i]))) answer++;
        }
        
        System.out.println(answer);
    }
    
    private static boolean isPrime(int num) {
        if(num == 1 || num == 0) return false;
        
        for(int i=2;i<=num/2;i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}
