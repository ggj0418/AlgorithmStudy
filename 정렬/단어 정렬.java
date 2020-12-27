// https://www.acmicpc.net/problem/1181
// 백준 1181 단어 정렬
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(bufR.readLine());
        String[] array = new String[N];
        
        for(int i=0;i<N;i++) {
            array[i] = bufR.readLine();
        }
        
        // 입력값들을 1. 단어길이 2. 알파벳 순서 대로 배열
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                if(word1.length() < word2.length()) {
                    return -1;
                } else if(word1.length() == word2.length()) {
                    return word1.compareTo(word2);
                }
                return 1;
            }
        });
        
        // 중복값 제거
        for(int i=0;i<N;i++) {
            if(i == N-1 || !array[i].equals(array[i+1])) bufW.write(array[i] + "\n");
        }
        
        bufW.flush();
        bufW.close();
        bufR.close();
    }
}
