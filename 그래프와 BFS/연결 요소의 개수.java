// https://www.acmicpc.net/problem/11724
// 백준 11724번 연결 요소의 개수
import java.io.*;

public class Main {
    static int N,M;
    static int visited[];
    static int map[][];
	
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] splitArray = bufR.readLine().split(" ");
        N = Integer.parseInt(splitArray[0]);
        M = Integer.parseInt(splitArray[1]);
        map = new int[N+1][N+1];
        visited = new int[N+1];
		
        // x에서 y로 가는 길, y에서 x로 가는 길을 표시	    
        for(int i=0;i<M;i++) {
            splitArray = bufR.readLine().split(" ");
            int x = Integer.parseInt(splitArray[0]);
            int y = Integer.parseInt(splitArray[1]);
            map[x][y] = map[y][x] = 1;
        }

        int count = 0;
        // 1부터 시작해서 N까지 둘러보면서 dfs에서 지나간 부분은 1로 표시하면서 연결된 영역을 카운트
        for(int i=1;i<=N;i++) {
            if(visited[i] == 0) {
                dfs(i);
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    static void dfs(int x) {
        visited[x] = 1;
        for(int i=1;i<N+1;i++) {
            if(map[x][i] == 1 && visited[i]==0) {
                dfs(i);
            }
        }
    }
}
