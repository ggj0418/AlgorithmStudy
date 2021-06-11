// https://www.acmicpc.net/problem/10798
// 백준 10798번 세로읽기
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char[][] map = new char[5][15];
        for(int i = 0; i < 5; i++) {
            Arrays.fill(map[i], '.');
        }
        
        for(int i = 0; i < 5; i++) {
            String input = in.readLine();
            for(int j = 0; j < input.length(); j++) {
                map[i][j] = input.charAt(j);
            }
        }
        
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(map[j][i] != '.') {
                    out.write(map[j][i]);
                }
            }
        }
        
        out.flush();
        out.close();
        in.close();
    }
}
// 간단한 문제
