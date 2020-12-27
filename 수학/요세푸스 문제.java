// https://www.acmicpc.net/problem/1158
// 백준 1158번 요세푸스 문제
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(bufR.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> queue = new LinkedList<>();
        
        // 원형으로 돌리기 위해서 queue에 각 사람의 번호 입력
        for(int i=1;i<=N;i++) queue.add(i);
        
        int count = 0;
        
        // 더 이상 남은 사람이 없을 때까지 반복
        while(!queue.isEmpty()) {
            count++;
            Integer number = queue.poll();
            
            // 처음부터 시작하거나 이전 사라진 사람부터 시작해서 K번째에 있는 사람
            if(count == K) {
                // 마지막 사람이면 번호만 넣고
                if(queue.isEmpty()) {
                    sb.append(number);
                } 
                // 아니면 번호 + ", "
                else {
                    sb.append(number).append(", ");
                    count = 0;
                }
            } 
            // K번째에 있는 사람이 아니면 queue에 넣어서 원이 돌아가도록 설정
            else {
                queue.add(number);
            }
        }
    
        sb.append(">");
        
        bufW.write(sb.toString());
        bufW.flush();
        bufW.close();
        bufR.close();
    }
}
