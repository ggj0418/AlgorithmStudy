// https://www.acmicpc.net/problem/1934
// 백준 1934번 최소공배수
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bufR.readLine());
        
        for(int i=0;i<n;i++) {
            String[] splitArray = bufR.readLine().split(" ");
            
            int a = Integer.parseInt(splitArray[0]);
            int b = Integer.parseInt(splitArray[1]);
            
            System.out.println(a * b / getGcd(a,b));
        }
    }
    
    private static int getGcd(int a, int b) {
        if(b == 0) return a;
        else return getGcd(b, a % b);
    }
}
