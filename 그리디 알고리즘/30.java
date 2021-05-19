// https://www.acmicpc.net/problem/10610
// 백준 10610번 30
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = in.readLine();
        int[] counts = new int[10];
        long sum = 0;
        
        for(int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            counts[num]++;
            sum += num;
        }
        
        if(counts[0] == 0 || sum % 3 != 0) {
            out.write("-1");
            out.flush();
            out.close();
            in.close();
            
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            while(counts[i] > 0) {
                sb.append(i);
                counts[i]--;
            }
        }
       
        out.write(sb.toString());
        out.flush();
        out.close();
        in.close();
    }
}

// 문제를 처음에 오해해서 10 ^ 5을 10,000으로 해석해서 NumberFormatError가 떴다.
// 자세히 읽어보니 그게 아니었고 이 수는 int, long의 범주를 한참 벗어난 수였다.
// 그래서 String 형식 그대로 받아서 처리했고 30의 배수는 0을 하나 이상 포함하고, 각 자리 수의 합이 3의 배수가 되어야하므로 이 조건 그대로 구현했다
