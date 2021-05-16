// https://www.acmicpc.net/problem/1697
// 백준 1697 숨바꼭질
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
		
        int subin = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());
        
        int[] array = new int[100001];
        
        bfs(array, subin, bro);
		
        out.write(array[bro] + "\n");
        out.flush();
        out.close();
        in.close();
    }
    
    private static void bfs(int[] array, int subin, int bro) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(subin);
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            if(current == bro) {
                break;
            }
        
            int next;
            for(int i = 0; i < 3; i++) {
                if(i == 0) next = current - 1;
                else if(i == 1) next = current + 1;
                else next = current * 2;
                
                if(0 <= next && next < array.length && array[next] == 0) {
                   array[next] = array[current] + 1;
                    queue.add(next);
                }
            }    
        }
    }
}
