// https://www.acmicpc.net/problem/1427
// 백준 1427번 소트인사이드
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char[] array = bufR.readLine().toCharArray();
        
        Arrays.sort(array);
        
        for(int i=array.length-1;i>=0;i--) {
            bufW.write(array[i]);
        }
        
        bufW.flush();
        bufW.close();
        bufR.close();
    }
}
// Arrays.sort(array, Collections.reverseOrder()); 이 방식이 char 배열에서는 사용되지 않는 것 
