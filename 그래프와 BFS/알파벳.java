// https://www.acmicpc.net/problem/1987
// 백준 1987번 알파벳
import java.io.*;
import java.util.*;

public class Main {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        char[][] map = new char[r][c];
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < r; i++) {
            map[i] = in.readLine().toCharArray();
            for(int j = 0; j < c; j++) {
                if(!set.contains(map[i][j])) {
                    set.add(map[i][j]);
                }
            }
        }

        int initSize = set.size();
        set.remove(map[0][0]);
        backTracking(map, set, 0, 0, initSize);
        
        out.write(answer + "\n");
        out.flush();
        out.close();
        in.close();
    }
    
    private static void backTracking(char[][] map, Set<Character> set, int x, int y, int initSize) {
        for(int i = 0; i < 4; i++) {
            int postX = x + dx[i];
            int postY = y + dy[i];
            
            if(0 <= postX && postX < map.length && 0 <= postY && postY < map[0].length) {
                if(set.contains(map[postX][postY])) {
                    set.remove(map[postX][postY]);
                    backTracking(map, set, postX, postY, initSize);
                    set.add(map[postX][postY]);
                }
                else {
                    answer = Math.max(initSize - set.size(), answer);
                }
            }
        }
    }
}

/*
전형적인 dfs 템플렛의 문제이지만 매번 쓰는 count, visit를 사용하지 않고 색다르게 set를 써서 풀어보려고 시도했다
정답은 맞췄지만 1800ms에 가까운 끔찍한 실행시간이 나왔다.
역시 템플렛대로 푸는게 훨씬 
*/
