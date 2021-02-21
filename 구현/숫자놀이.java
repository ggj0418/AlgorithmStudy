// https://www.acmicpc.net/problem/1755
// 백준 1755번 숫자놀이
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<String> queue = new PriorityQueue<>();
		
		for(int i=M;i<=N;i++) {
		    queue.add(parseInputToString(i));
		}
		
		int index = 0;
		while(!queue.isEmpty()) {
		    if(index != 0 && index % 10 == 0) out.write("\n");
		    out.write(parseInputToInt(queue.poll()) + " ");
		    index++;
		}
		
		out.flush();
		out.close();
		in.close();
	}
	
	private static int parseInputToInt(String input) {
	    int answer = 0;
	    
	    String[] splitArray = input.split(" ");
	    
	    for(int i=0;i<splitArray.length;i++) {
	        answer = answer * 10 + stringToInt(splitArray[i]);
	    }
	    
	    return answer;
	}
	
	private static String parseInputToString(int n) {
	    String answer = "";
	    
	    while(n > 0) {
	        int remain = n % 10;
	        answer = intToString(remain) + " " + answer;
	        n /= 10;
	    }
	    
	    return answer;
	}
	
	private static String intToString(int n) {
	    String answer = "";
	    switch (n) {
	        case 0:
	            answer = "zero";
	            break;
	        case 1:
                answer = "one";
                break;
            case 2:
                answer = "two";
                break;
            case 3:
                answer = "three";
                break;
            case 4:
                answer = "four";
                break;
            case 5:
                answer = "five";
                break;
            case 6:
                answer = "six";
                break;
            case 7:
                answer = "seven";
                break;
            case 8:
                answer = "eight";
                break;
            case 9:
                answer = "nine";
                break;
	    }
	    
	    return answer;
	}
	
	private static int stringToInt(String input) {
	    int answer = 0;
	    
	    switch (input) {
	        case "zero":
	            answer = 0;
	            break;
	        case "one":
                answer = 1;
                break;
            case "two":
                answer = 2;
                break;
            case "three":
                answer = 3;
                break;
            case "four":
                answer = 4;
                break;
            case "five":
                answer = 5;
                break;
            case "six":
                answer = 6;
                break;
            case "seven":
                answer = 7;
                break;
            case "eight":
                answer = 8;
                break;
            case "nine":
                answer = 9;
                break;
	    }
	    
	    return answer;
	}
}

// PirorityQueue를 활용해서 int -> string으로 변환시켜서 큐에 넣은 String 값들을 정렬시켜놓고 하나하나 빼내면서 다시 int로 바꿔서 출력하는 방식이다
