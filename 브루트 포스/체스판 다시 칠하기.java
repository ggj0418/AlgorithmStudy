// https://www.acmicpc.net/problem/1018
// 백준 1018번 체스판 다시 칠하기
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        String[] splitArray = bufR.readLine().split(" ");
        int N = Integer.parseInt(splitArray[0]);
        int M = Integer.parseInt(splitArray[1]);

        char[][] map = new char[N][M];
        for(int i=0;i<N;i++){
            String input = bufR.readLine();
            for(int j=0;j<M;j++)
                map[i][j] = input.charAt(j);
        }

        int min = 64;
        for(int i=0;i<N-8+1;i++){
            for(int j=0;j<M-8+1;j++){
                // B로 시작하는 체스판과 비교
                int diff_B = 0;
                for(int a=0;a<8;a++) {
                    for (int b=0;b<8;b++) {
                        // B로 시작하면 짝수행에서 짝수열은 B, 홀수열은 W
                        // 홀수행에서 짝수열은 W, 홀수열은 B
                        if (a % 2 == 0) {
                            if (b % 2 == 0) {
                                if (map[i + a][j + b] != 'B') ++diff_B;
                            } else {
                                if (map[i + a][j + b] != 'W') ++diff_B;
                            }
                        } else {
                            if (b % 2 == 0) {
                                if (map[i + a][j + b] != 'W') ++diff_B;
                            } else {
                                if (map[i + a][j + b] != 'B') ++diff_B;
                            }
                        }
                    }
                }
           
                // W로 시작하는 체스판과 비교
                int diff_W = 0;
                for(int a=0;a<8;a++) {
                    for(int b=0;b<8;b++){
                        // W로 시작하면 짝수행에서 짝수열은 W, 홀수열은 B
                        // 홀수행에서 짝수열은 B, 홀수열은 W
                        if(a%2 == 0){
                            if(b%2 == 0){
                                if(map[i+a][j+b] != 'W') ++diff_W;
                            } else {
                                if(map[i+a][j+b] != 'B') ++diff_W;
                            }
                        } else {
                            if(b%2 == 0){
                                if(map[i+a][j+b] != 'B') ++diff_W;
                            } else {
                                if(map[i+a][j+b] != 'W') ++diff_W;
                            }
                        }
                    }
                }
           
                // 최솟값 비교
                int dif_min = (diff_W < diff_B) ? diff_W : diff_B;
                if(dif_min < min) min = dif_min;
            }
        }
        
        System.out.println(min);
    }
}
