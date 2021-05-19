// https://www.acmicpc.net/problem/5430
// 백준 5430번 AC
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(in.readLine());
        loop: while(t-- > 0) {
            LinkedList<Integer> queue = new LinkedList<>();
            String operation = in.readLine();
            int n = Integer.parseInt(in.readLine());
            boolean order = true;
            
            StringTokenizer st = new StringTokenizer(in.readLine(), "[],");
            for(int i = 0; i < n; i++) {
                queue.addLast(Integer.parseInt(st.nextToken()));
            }
            
            for(int i = 0; i < operation.length(); i++) {
                if(operation.charAt(i) == 'R') {
                    order = !order;
                } else {
                    if(queue.isEmpty()) {
                        out.write("error\n");
                        continue loop;
                    }
                    
                    if(order) {
                        queue.removeFirst();
                    }
                    else {
                        queue.removeLast();
                    }
                }
            }
            
            out.write(getPrintValue(queue, order) + "\n");
        }
        
        out.flush();
        out.close();
        in.close();
    }
    
    private static String getPrintValue(LinkedList<Integer> queue, boolean order) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(queue.size() > 0) {
            while(!queue.isEmpty()) {
                sb.append(order ? queue.pollFirst() : queue.pollLast());
                if(!queue.isEmpty()) {
                    sb.append(",");
                }
            }
        }
        sb.append("]");
        
        return sb.toString();
    }
}
// 배열 자체를 뒤집기보다는 deque와 순서를 표시하는 boolean flag 하나만 활용하면 쉽게 풀 수 있는 문제이다.
// 다만 배열 입력값을 파싱하는 부분에서 처음에는 []를 먼저 replace로 없앤 다음 split(",") 으로 값을 받았으나 배열의 길이가 0인 경우를 처리하지 못했다
// 길이가 0인 케이스만 따로 빼서 처리할 수도 있었으나 StringTokenizer를 활용하면 더욱 쉽게 처리할 수 있어서 사용하였다.
