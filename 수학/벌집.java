// https://www.acmicpc.net/problem/2292
// 백준 2292번 벌집
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(in.readLine());
        int crisp = 1;
        
        long multiple = 1;
        
        while(multiple < N) {
            multiple += 6 * (crisp++);
        }
        
        out.write(crisp + "\n");
        out.flush();
        out.close();
        in.close();
    }
}

/*
겹겹이 증가하는데 이 증가하는 겹을 이루고 있는 육각형의 개수는 6, 12, 18, 24 이런식으로 6의 배수로 이루어져있다.
따라서 초기값 1에서 각 겹마다의 육각형 개수(6의 배수)를 더해가면서 주어진 숫자 N이 해당 겹의 마지막 숫자(multiple)보다 같거나 작을때까지 multiple을 6의 배수만큼 더해가면서 답을 찾는다
*/
