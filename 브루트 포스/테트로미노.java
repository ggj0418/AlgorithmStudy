// https://www.acmicpc.net/problem/14500
// 백준 14500번 테트로미노
import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bufR.readLine());
        
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[row+6][col+6];
        
        for(int i=3;i<row+3;i++) {
            st = new StringTokenizer(bufR.readLine());
            
            for(int j=3;j<col+3;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0;i<row+3;i++) {
            for(int j=0;j<col+3;j++) {
                bruteForce(i, j, map);
            }
        }
        
        bufW.write(max + "\n");
        bufW.flush();
        bufW.close();
        bufR.close();
    }
    
    public static void bruteForce(int x, int y, int[][] map) {
        // 1. 긴 막대기 눕힌거
        // 0
        // 0
        // 0
        // 0
        int sum = 0;
        sum += map[x][y];
        sum += map[x][y+1];
        sum += map[x][y+2];
        sum += map[x][y+3];
        if(max < sum) max = sum;
        
        // 2. 긴 막대기 세운거
        // 0 0 0 0
        sum = 0;
        sum += map[x][y];
        sum += map[x+1][y];
        sum += map[x+2][y];
        sum += map[x+3][y];
        if(max < sum) max = sum;
        
        // 3. 네모
        // 0 0
        // 0 0
        sum = 0;
        sum += map[x][y];
        sum += map[x+1][y];
        sum += map[x+1][y+1];
        sum += map[x][y+1];
        if(max < sum) max = sum;
        
        // 4. ㄱ 자 모양
        // 0 0 0 
        //     0
        sum = 0;
        sum += map[x][y];
        sum += map[x+1][y];
        sum += map[x+2][y];
        sum += map[x+2][y+1];
        if(max < sum) max = sum;
        
        // 5. ㄱ 자 모양
        //     0
        // 0 0 0
        sum = 0;
        sum += map[x][y+1];
        sum += map[x+1][y+1];
        sum += map[x+2][y+1];
        sum += map[x+2][y];
        if(max < sum) max = sum;
        
        // 6. ㄱ자 모양
        // 0 0
        // 0
        // 0
        sum = 0;
        sum += map[x][y];
        sum += map[x][y+1];
        sum += map[x][y+2];
        sum += map[x+1][y];
        if(max < sum) max = sum;
        
        // 7. ㄱ자 모양
        // 0 
        // 0
        // 0 0
        sum = 0;
        sum += map[x][y];
        sum += map[x][y+1];
        sum += map[x][y+2];
        sum += map[x+1][y+2];
        if(max < sum) max = sum;
        
        // 8. ㄱ자 모양
        // 0 
        // 0 0 0
        sum = 0;
        sum += map[x][y];
        sum += map[x][y+1];
        sum += map[x+1][y+1];
        sum += map[x+2][y+1];
        if(max < sum) max = sum;
        
        // 9. ㄱ자 모양
        // 0 0 0
        // 0
        sum = 0;
        sum += map[x][y];
        sum += map[x][y+1];
        sum += map[x+1][y];
        sum += map[x+2][y];
        if(max < sum) max = sum;
        
        // 10. ㄱ자 모양
        //   0
        //   0
        // 0 0
        sum = 0;
        sum += map[x][y+2];
        sum += map[x+1][y+2];
        sum += map[x+1][y+1];
        sum += map[x+1][y];
        if(max < sum) max = sum;
        
        // 11. ㄱ자 모양
        // 0 0
        //   0
        //   0
        sum = 0;
        sum += map[x][y];
        sum += map[x+1][y];
        sum += map[x+1][y+1];
        sum += map[x+1][y+2];
        if(max < sum) max = sum;
        
        // 12. 그 ㄹ자 있자너 그거 그래
        // 0 0
        //   0 0
        sum = 0;
        sum += map[x][y];
        sum += map[x+1][y];
        sum += map[x+1][y+1];
        sum += map[x+2][y+1];
        if(max < sum) max = sum;
        
        // 13. 그 ㄹ자 있자너 그거 그래
        //   0
        // 0 0
        // 0
        sum = 0;
        sum += map[x][y+2];
        sum += map[x][y+1];
        sum += map[x+1][y+1];
        sum += map[x+1][y];
        if(max < sum) max = sum;
        
        // 14. 그 ㄹ자 있자너 그거 그래
        //   0 0
        // 0 0
        sum = 0;
        sum += map[x+2][y];
        sum += map[x+1][y];
        sum += map[x+1][y+1];
        sum += map[x][y+1];
        if(max < sum) max = sum;
        
        // 15. 그 ㄹ자 있자너 그거 그래
        // 0 
        // 0 0
        //   0
        sum = 0;
        sum += map[x][y];
        sum += map[x][y+1];
        sum += map[x+1][y+1];
        sum += map[x+1][y+2];
        if(max < sum) max = sum;
        
        // 16. ㅗ자 모양
        //   0
        // 0 0 0
        sum = 0;
        sum += map[x][y+1];
        sum += map[x+1][y+1];
        sum += map[x+2][y+1];
        sum += map[x+1][y];
        if(max < sum) max = sum;
        
        // 17.ㅏ자 모양
        // 0
        // 0 0
        // 0
        sum = 0;
        sum += map[x][y];
        sum += map[x][y+1];
        sum += map[x][y+2];
        sum += map[x+1][y+1];
        if(max < sum) max = sum;
        
        // 18.ㅜ자 모양
        // 0 0 0
        //   0
        sum = 0;
        sum += map[x][y];
        sum += map[x+1][y];
        sum += map[x+2][y];
        sum += map[x+1][y+1];
        if(max < sum) max = sum;
        
        // 19.ㅓ자 모양
        //   0
        // 0 0
        //   0
        sum = 0;
        sum += map[x+1][y];
        sum += map[x][y+1];
        sum += map[x+1][y+1];
        sum += map[x+1][y+2];
        if(max < sum) max = sum;
    }
}

// 먼저 가장 긴 블럭인 일자블록을 영역에 한칸만 걸치게 둘 경우, 원래 영역에서 +3만큼 확장되게된다. 따라서 원래 맵을 가로세로로 3만큼 확장시킨 후, 확장된 부분은 0으로 채운 뒤
// 진짜 말 그대로 브루트포스, 모든 경우의 수를 대입해서 값을 찾았다.
