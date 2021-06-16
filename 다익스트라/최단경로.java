// https://www.acmicpc.net/problem/1753
// 백준 1753번 최단경로
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        int[] values = new int[v + 1];
        Arrays.fill(values, Integer.MAX_VALUE);
        
        List<List<Edge>> list = new ArrayList<>();
        for(int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }
        
        int start = Integer.parseInt(in.readLine());
        while(e-- > 0) {
            st = new StringTokenizer(in.readLine());
            
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            
            list.get(source).add(new Edge(destination, value));
        }
        
        solve(list, values, start, v);
        
        for(int i = 1; i <= v; i++) {
            out.write(values[i] != Integer.MAX_VALUE ? Integer.toString(values[i]) : "INF");
			      out.newLine();
        }
        
        out.flush();
        out.close();
        in.close();
    }
    
    private static void solve(List<List<Edge>> list, int[] values, int start, int v) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        boolean[] visit = new boolean[v + 1];
        
        queue.add(new Edge(start, 0));
        values[start] = 0;
        
        while(!queue.isEmpty()) {
            Edge current = queue.poll();
            int postX = current.destination;
            
            if(!visit[postX]) {
                visit[postX] = true;
                
                for(Edge edge : list.get(postX)) {
                    if(!visit[edge.destination] && values[edge.destination] > values[postX] + edge.value) {
                        values[edge.destination] = values[postX] + edge.value;
                        queue.add(new Edge(edge.destination, values[edge.destination]));
                    }
                }
            }
        }
    }
    
    public static class Edge implements Comparable<Edge>{
        int destination;
        int value;
        
        public Edge(int destination, int value) {
			    this.destination = destination;
			    this.value = value;
		  }

        @Override
        public int compareTo(Edge o1) {
            return this.value - o1.value;
        }
    }
}

/*
다익스트라 알고리즘의 템플릿같은 문제로써, 시작점에서 도착점까지 가는 길의 최단 경로를 찾는 방식이다
보통 다익스트라는 이차원 배열로 값을 찾는 방식과 힙을 사용한 방식이 있는데 힙 방식이 런타임 쪽에서 훨씬 유리하기 때문에 채택해보았다
현재 위치에서 다음 위치로 갈때에, 다음 위치의 누적된 value값이 현재 위치에서 다음 위치로 가는 value + 현재 위치까지 오는데 걸린 value 보다 크면 후자의 값이 최소값이 되므로
이를 이용해서 초기화 시켜주고 힙에 넣어주면서 진행한다
*/
