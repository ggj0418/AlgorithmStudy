// https://www.acmicpc.net/problem/1038
// 백준 1038번 감소하는 수
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bufR.readLine());
        // 만들 수 있는 가장 큰 수는 9876543210이고 이것은 1022번째 수이기 때문에 이보다 높은 순서의 감소하는 수는 존재하지 않는다
        if(N > 1022) {
            System.out.println(-1);
        } 
        // N이 한자리수이면 그 자체가 감소하는 수가 된다
        else if(N < 10) {
            System.out.println(N);
        } 
        // 그 이외의 경우에는 한자리 수에서부터 시작해서 Queue에 넣어놓은 다음
        // 하나씩 꺼내서, 꺼낸 숫자의 뒤에 올 수 있는 숫자를 붙여서 Queue에 다시 넣는다
        else {
            Queue<Long> queue = new LinkedList<>();
            int count= 0;
            for(int i=1; i<10; i++) {
                queue.add(new Long(i));
                count++;
            }
            while(count < N) {
                // 꺼낸 숫자의 마지막 자릿수를 기준으로 잡아서 감소하는 수를 만든다
                long k = queue.poll();
                long temp = k % 10;
                // 내림차순으로 만들기
                for(int i=0;i<temp;i++) {
                    queue.add(k * 10 + i);
                    count++;
                    if(count == N) {
                        System.out.println(k * 10 + i);
                        break;
                    }
                }
            }
        }
    }
}
