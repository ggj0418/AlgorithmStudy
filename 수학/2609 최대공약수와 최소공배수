// https://www.acmicpc.net/problem/2609
// 백준 2609번 최대공약수와 최소공배수
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        String[] splitArray = bufR.readLine().split(" ");
        int a = Integer.parseInt(splitArray[0]);
        int b = Integer.parseInt(splitArray[1]);
        
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        
        if(max % min == 0) {
            System.out.println(min);
            System.out.println(max);
        } else {
            int temp = min;
            do {
                min--;
            } while(max % min != 0 || temp % min != 0);
            System.out.println(min);
            
            min = Math.min(a,b);
            while(min % max != 0) {
                min += temp;
            }
            System.out.println(min);
        }
    }
}
