// https://www.acmicpc.net/problem/11723
// 백준 11723번 집합

// 그야말로 자바에서 런타임 관련한 자잘한 기술들의 집합체라고 볼 수 있는 문제이다. 일단 배열 대신 비트마스크를 사용한 하나의 정수로 집합을 구현했다는 것 자체가
// 런타임을 대폭 감소시킬 수 있는 요인이었다.
// 그 외에도 System.out.println과 bufferedWriter의 싸움은 대략 20ms의 차이를 보여서 러닝타임이 극한으로 줄어야하는 상황에서 말고는 System 출력을 사용해도 될 것같다
// 또한 평소에 split을 써서 입력값을 받는 방식을 선호했는데 StringTokenizer를 사용하니 무려 300ms의 런타임을 줄일 수 있었다.
// 마지막으로 if문이나 switch문을 돌릴때 모든 조건에서 사용되는 변수가 아니면 각각의 조건에서 따로따로 초기화시켜주는게 조금 더 
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        
	int M = Integer.parseInt(bufR.readLine());
        int set = 0;
        StringBuilder sb = new StringBuilder();
		
        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(bufR.readLine());
            String operation = st.nextToken();
            int num;
		    
            switch(operation) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    set |= (1 << (num - 1));
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set &= ~(1 << (num - 1));
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((set & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    set ^= (1 << (num - 1));
                    break;
                case "all" :
                    set |= (~0);
                    break;
                case "empty" :
                    set &= 0;
                    break;
                }
            }
		
        bufW.write(sb.toString());
        bufW.flush();
        bufW.close();
    }
}
