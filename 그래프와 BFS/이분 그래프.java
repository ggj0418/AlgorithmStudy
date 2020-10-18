// https://www.acmicpc.net/problem/1707
// 백준 1707번 이분 그래프
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(bufR.readLine());
        
        for(int i=0;i<K;i++) {
            String[] splitArray = bufR.readLine().split(" ");
            int V = Integer.parseInt(splitArray[0]);
            int E = Integer.parseInt(splitArray[1]);
            
            List<Integer>[] list = new ArrayList[V+1];
            
            for(int j=1;j<=V;j++) list[j] = new ArrayList<>();
            
            for(int j=0;j<E;j++) {
                splitArray = bufR.readLine().split(" ");
                
                int start = Integer.parseInt(splitArray[0]);
                int end = Integer.parseInt(splitArray[1]);
                
                list[start].add(end);
                list[end].add(start);
            }
            
            int[] colors = new int[V+1];
            boolean ok = true;
            
            for(int j=1;j<=V;j++) {
                // 제일 처음에 리스트를 돌때 빨간색(1)이라고 표시를 해둔다
                // 그 다음 도착하는 노드는 파란색(2) 이런식으로 표시
                if(colors[j] == 0) dfs(list, colors, j, 1);
            }
            
            for(int j=1;j<=V;j++) {
                for(int k : list[j]) {
                    // 한 노드가 갈 수 있는 모든 노드들을 보면서
                    // 갈 수 있는 모든 노드들은 모두 현재 노드와
                    // 반대편에 있어야지 이분 그래프가 성립함
                    // 따라서 색깔이 같아야 하는데 색깔이 다르면 이분 그래프가 아님!
                    if(colors[j] == colors[k]) {
                        ok = false;
                    }
                }
            }
            
            System.out.println((ok) ? "YES" : "NO");
        }
    }
    
    static void dfs(List<Integer>[] list, int[] colors, int aSide, int color) {
        colors[aSide] = color;
        for(int bSide : list[aSide]) {
            // 현재 들어온 값에서 갈 수 있는 모든 노드들을 보면서
            // 한번도 안 간 값이 있으면 색깔을 자기와 반대로 칠하면서 진행
            if(colors[bSide] == 0) dfs(list, colors, bSide, 3-color);
        }
    }
}
