// https://www.acmicpc.net/problem/2178
// 백준 2178번 미로 탐색
import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] map;
    static int N,M;

    public static void main(String args[]) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bufR.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0;i<N;i++) {
            String input = bufR.readLine();
            for (int j=0;j<M;j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0,0);

        bufW.write(map[N-1][M-1] + "\n");
        bufW.flush();
        bufW.close();
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();            

            for(int i=0;i<4;i++){
                int postX = current[0] + dx[i];
                int postY = current[1] + dy[i];

                if(0 <= postX && postX < N && 0 <= postY && postY < M) {
                    if(map[postX][postY] == 1 && !visited[postX][postY]){
                        queue.offer(new int[] {postX,postY});
                        visited[postX][postY] = true;
                        map[postX][postY] = map[current[0]][current[1]] + 1;
                    }
                }
            }
        }
    }
}

// 이 방식이 최단거리인 이유는 현재 위치에서 사방을 보면서 갈 수 있는 것에 대해서 queue에 넣어놓고 한 Depth씩 진행해나가기 때문에 최단거리가 아닌 진행경로들은 
// 이미 visited 값을 true로 바꾼 최단거리경로 때문에 더 이상 map의 끝까지 진행할 수 없다
