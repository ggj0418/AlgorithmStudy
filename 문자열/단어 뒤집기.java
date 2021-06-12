// https://www.acmicpc.net/problem/9093
// 백준 9093번 단어 뒤집기
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(in.readLine());
        
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            
            while(st.hasMoreTokens()) {
                out.write(reverseString(st.nextToken()) + " ");
            }
            out.newLine();
        }
        
        out.flush();
        out.close();
        in.close();
    }

    private static String reverseString(String str) {
        char[] array = str.toCharArray();
        for(int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - (i + 1)];
            array[array.length - (i + 1)] = temp;
        }

        return String.valueOf(array);
    }
}
