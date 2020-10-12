// https://www.acmicpc.net/problem/10430

// 단순 연산 문제
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        String[] splitArray = bufR.readLine().split(" ");
        int a = Integer.parseInt(splitArray[0]);
        int b = Integer.parseInt(splitArray[1]);
        int c = Integer.parseInt(splitArray[2]);
        
        System.out.println((a+b)%c);
        System.out.println((a%c+b%c)%c);
        System.out.println((a*b)%c);
        System.out.println((a%c*b%c)%c);
    }
}
