// https://www.acmicpc.net/problem/1260
// 백준 1260번 DFS와 BFS
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        String[] splitArray = bufR.readLine().split(" ");
        int N = Integer.parseInt(splitArray[0]);
        int M = Integer.parseInt(splitArray[1]);
        int root = Integer.parseInt(splitArray[2]);
        
        List<Integer>[] list = new ArrayList[N+1];
        
        for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
        
        for(int i=0;i<M;i++) {
            splitArray = bufR.readLine().split(" ");
            
            int start = Integer.parseInt(splitArray[0]);
            int end = Integer.parseInt(splitArray[1]);
            
            list[start].add(end);
            list[end].add(start);
        }
        
        for(int i=1;i<=N;i++) Collections.sort(list[i]);
        
        boolean[] visited = new boolean[N+1];
        dfs(root, list, visited);
        System.out.println();
        
        Arrays.fill(visited, false);
        bfs(root, list, visited);
    }
    
    static void dfs(int root, List<Integer>[] list, boolean[] visited) {
        if(visited[root]) return;
        
        visited[root] = true;
        System.out.print(root + " ");
        for(int next : list[root]) {
            if(!visited[next]) dfs(next, list, visited);
        }
    }
    
    static void bfs(int root, List<Integer>[] list, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for(int next : list[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
