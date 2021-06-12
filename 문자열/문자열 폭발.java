// https://www.acmicpc.net/problem/9935
// 백준 9935번 문자열 폭발
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		    String plain = in.readLine();
		    String bomb = in.readLine();
        LinkedList<Character> queue = new LinkedList<>();

		    for(int i = 0; i < plain.length(); i++) {
            queue.addLast(plain.charAt(i));

            if(queue.size() >= bomb.length()) {
				        boolean check = true;
				        for (int j = 0; j < bomb.length(); j++) {
                    if(queue.get(queue.size() - bomb.length() + j) != bomb.charAt(j)) {
                        check = false;
		    				        break;
                    }
    				    }
                
    				    if(check) {
    					      for(int j = 0; j < bomb.length(); j++) {
    						        queue.removeLast();
    					      }
    				    }
            }
		    }
        
        if(queue.size() == 0) {
            out.write("FRULA");
        }
        else {
            for(char c : queue) {
                out.write(String.valueOf(c));
            }
        }
		
		    out.flush();
        out.close();
        in.close();
    }
}

// LinkedList에 문자 하나씩 넣어보면서 LinkedList에 들어간 문자열의 길이가  bomb 문자열 길이와 같거나 클 경우 (삭제할 가능성이 있을 때)
// 새로 넣은 문자를 기준으로 해서 LinkedList와 bomb을 비교해보면서 동일하면 bomb 만큼 removeLast해주고 아니면 그냥 패스
