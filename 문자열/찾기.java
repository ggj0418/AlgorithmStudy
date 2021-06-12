// https://www.acmicpc.net/problem/1786
// 백준 1786번 찾기
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String target = in.readLine();
        	String pattern = in.readLine();

        	int[] kmp = new int[pattern.length()];

        	int j = 0;
        	for(int i = 1; i < pattern.length(); i++) {
            		while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                		j = kmp[j - 1];
            		}

            		if(pattern.charAt(i) == pattern.charAt(j)) {
                		kmp[i] = ++j;
            		}
        	}
        
        	int answer = 0;
        	StringBuilder sb = new StringBuilder();
        	j = 0;

        	for(int i = 0; i < target.length(); i++) {
            		while(j > 0 && target.charAt(i) != pattern.charAt(j)) {
                		j = kmp[j - 1];
            		}

            		if(target.charAt(i) == pattern.charAt(j)) {
                		if(j == pattern.length() - 1) {
                    			answer++;
                    			sb.append(i - pattern.length() + 2).append(" ");
                    			j = kmp[j];
                		}
                		else {
                    			j++;
                		}
            		}
        	}

		out.write(answer + "\n");
        	out.write(sb.toString());
		
		out.flush();
		out.close();
		in.close();
	}
}
// KMP 알고리즘을 활용했는데 아직 이해가 가지 않아서 공부해봐야할 것 같다
