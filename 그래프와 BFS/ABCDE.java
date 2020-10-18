// https://www.acmicpc.net/problem/13023
// 백준 13023번 ABCDE
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int answer = 0;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        String[] splitArray = bufR.readLine().split(" ");
        N = Integer.parseInt(splitArray[0]);
        M = Integer.parseInt(splitArray[1]);
        list = new ArrayList[N];
        visited = new boolean[N];
        
        for(int i=0;i<N;i++) list[i] = new ArrayList<>();

        for(int i=0;i<M;i++) {
            splitArray = bufR.readLine().split(" ");
            int a = Integer.parseInt(splitArray[0]);
            int b = Integer.parseInt(splitArray[1]);

            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0;i<N;i++) {
            if(answer == 1) break;
            dfs(i, 0);
        }

        System.out.println(answer);
    }

    static void dfs(int num, int count) {
        if(answer == 1) return;

        if(count >= 5) {
            answer = 1;
            return;
        }

        for(int i=0; i<list[num].size(); i++) {
            int x = list[num].get(i);

            if(!visited[x]) {
               visited[x] = true;
               dfs(x, count+1);
               visited[x] = false;
            }
        }
    }
}
