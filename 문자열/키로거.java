// https://www.acmicpc.net/problem/5397
// 백준 5397번 키로거
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(in.readLine());
        
        while(n-- > 0) {
            LinkedList<Character> queue = new LinkedList<>();
            ListIterator<Character> it = queue.listIterator();
            String input = in.readLine();
            
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c == '<') {
                    if(it.hasPrevious()) {
                        it.previous();
                    }
                }
                else if(c == '>') {
                    if(it.hasNext()) {
                        it.next();
                    }
                }
                else if(c == '-') {
                    if(it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                }
                else {
                    it.add(c);
                }
            }
            
            for(char tc : queue) {
                out.write(String.valueOf(tc));
            }
            out.newLine();
        }
        
        out.flush();
        out.close();
        in.close();
    }
}

// stack 2개를 활용해서 풀면 시간이 엄청 단축되긴 하지만 ListIterator이라는 신기한 반복자가 이러한 문제를 푸는 데에 굉장히 적합해서
// 활용해서 풀어보았다.
