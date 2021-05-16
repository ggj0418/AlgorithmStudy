// https://www.acmicpc.net/problem/1920
// 백준 1920번 수 찾기
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<>();
        
        	int n = Integer.parseInt(in.readLine());
        	StringTokenizer st = new StringTokenizer(in.readLine());
        	while(n-- > 0) {
            		list.add(Integer.parseInt(st.nextToken()));
        	}
        	Collections.sort(list);
        
        	int m = Integer.parseInt(in.readLine());
        	st = new StringTokenizer(in.readLine());
        
        	while(m-- > 0) {
            		int index = Collections.binarySearch(list, Integer.parseInt(st.nextToken()));
            		if(index >= 0) {
                		out.write(1 + "\n");
            		}
            		else {
                		out.write(0 + "\n");
            		}
        	}
        
        	out.flush();
        	out.close();
        	in.close();
	}
}
