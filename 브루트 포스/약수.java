// https://www.acmicpc.net/problem/1037
// 백준 1037번 약수
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(bufR.readLine());
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] splitArray = bufR.readLine().split(" ");
        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(splitArray[i]);
            
            max = Math.max(max, N);
            min = Math.min(min, N);
        }
        
        System.out.println(max * min);
    }
}

문제의 조건에서 양수 A가 N의 진짜 약수가 되기 위한 조건은 A가 1이나 N이 아니어야한다고 했으니, 2번째 줄에서 주어지는 수는 N의 약수중 1과 N을 제외한 약수들일 것이다.
여기서 두번째로 크고, 두번째로 작은 약수를 서로 곱하면 N이 나오기 때문에 해당값들을 구해서 계산해주면 된다
