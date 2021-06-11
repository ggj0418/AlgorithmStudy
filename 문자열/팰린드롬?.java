// https://www.acmicpc.net/problem/10942
// 백준 10942번 팰린드롬?
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = in.readLine();
        int[] array = new int[Integer.parseInt(input)];
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(in.readLine());
        while(m-- > 0) {
            st = new StringTokenizer(in.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            int[] temp = Arrays.copyOfRange(array, start - 1, end);

            if(check(temp)) {
                out.write("1");
            }
            else {
                out.write("0");
            }
            
            out.newLine();
        }
        
        out.flush();
        out.close();
        in.close();
    }
    
    private static boolean check(int[] temp) {
        if(temp.length == 1) {
            return true;
        }
        
        for(int i = 0; i < temp.length / 2; i++) {
            if(temp[i] != temp[temp.length - (i + 1)]) {
                return false;
            }
        }
        
        return true;
    }
}

// DP로 풀면 엄청 효율적이 된다는데 한번 시도해봐야겠다
