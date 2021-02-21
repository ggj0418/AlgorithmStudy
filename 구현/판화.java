// https://www.acmicpc.net/problem/1730
// 백준 1730번 판화
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(in.readLine());
        String operation = in.readLine();
        
        // 가로
        int[][] horizontal = new int[n][n];
        // 세로
        int[][] vertical = new int[n][n];
        int x = 0, y = 0;
        
        for(int i=0;i<operation.length();i++) {
            char alphabet = operation.charAt(i);
            
            switch (alphabet) {
                case 'U':
                    if(isOut(n, x-1, y)) break;
                    vertical[x][y] = 1;
                    vertical[--x][y] = 1;
                    break;
                case 'D':
                    if(isOut(n, x+1, y)) break;
                    vertical[x][y] = 1;
                    vertical[++x][y] = 1;
                    break;
                case 'L':
                    if(isOut(n, x, y-1)) break;
                    horizontal[x][y] = 1;
                    horizontal[x][--y] = 1;
                    break;
                case 'R':
                    if(isOut(n, x, y+1)) break;
                    horizontal[x][y] = 1;
                    horizontal[x][++y] = 1;
                    break;
            }
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(vertical[i][j] + horizontal[i][j] == 2) out.write("+");
                else if(horizontal[i][j] == 1) out.write("-");
                else if(vertical[i][j] == 1) out.write("|");
                else out.write(".");
            }
            out.write("\n");
        }
        
        out.flush();
        out.close();
        in.close();
    }
    
    private static boolean isOut(int n, int row, int col) {
        if(row < 0 || row >= n || col < 0 || col >= n) {
            return true;
        }
        return false;
    }
}

// 가로로 간 곳을 기록하는 horizontal 배열과 세로로 간 곳을 기록하는 vertical 배열을 선언한다
// 어느 구역으로 갈 때에 가고자 하는 곳이 범위 내인가를 판별하고 범위 안이라면 현재 있는 위치와 갈 위치의 기록 배열에 1로써 기록해둔다
// 기록 배열에 전부 기록한 한 후에, 다시 기록 배열들을 보면서 둘다 1인 경우에는 "+", 가로로만 지나간 경우는 "-", 세로로만 지나간 경우는 "|", 나머지 경우에는 "."으로 출력한다
