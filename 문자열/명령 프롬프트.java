// https://www.acmicpc.net/problem/1032
// 백준 1032번 명령 프롬프트
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        char[] sArray = null;

        while(n-- > 0) {
            if(sArray == null) {
                sArray = in.readLine().toCharArray();
            }
            else {
                char[] inputArray = in.readLine().toCharArray();

                for(int i = 0; i < sArray.length; i++) {
                    if(sArray[i] == inputArray[i] || sArray[i] == '?') {
                        continue;
                    }
                    else {
                        sArray[i] = '?';
                    }
                }
            }
        }
        
        out.write(String.valueOf(sArray));
        out.flush();
        out.close();
        in.close();
    }
}
