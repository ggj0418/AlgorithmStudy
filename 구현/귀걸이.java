// https://www.acmicpc.net/problem/1380
// 백준 1380번 귀걸이
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bufR.readLine());
		int count = 1;
		
		while(N != 0) {
		    String[] girls = new String[N];
		    String[] backPhone = new String[N];
		    for(int i=0;i<N;i++) {
    		    girls[i] = bufR.readLine();
		    }
		    
		    Arrays.fill(backPhone, "0");
		    for(int i=0;i<2*N-1;i++) {
		        String[] splitArray = bufR.readLine().split(" ");
		        
		        int index = Integer.parseInt(splitArray[0]) - 1;
		        String returnFlag = splitArray[1];
		        
		        if(backPhone[index].equals("A")) {
		            if(returnFlag.equals("B")) {
		                backPhone[index] = "Good";
		            }
		        } else if(backPhone[index].equals("B")) {
		            if(returnFlag.equals("A")) {
		                backPhone[index] = "Good";
		            }
		        } else {
		            backPhone[index] = returnFlag;
		        }
		    }
		    
		    for(int i=0;i<N;i++) {
		        if(backPhone[i].equals("A") || backPhone[i].equals("B")) {
		            bufW.write(count + " " + girls[i] + "\n");
		            count++;
		        }
		    }
		    
		    N = Integer.parseInt(bufR.readLine());
		}
		
    bufW.flush();
    bufW.close();
		bufR.close();
	}
}

// N 길이의 학생 이름을 넣는 배열 girls, 돌려받았는지 아닌지 상태를 판별하는 backPhone배열을 선언한다
// backPhone 배열의 상태는 0 (아무 상태도 아님), A or B (뺏김), Good(돌려받음)이 존재한다
// 각 2N-1의 뺏김상태 입력값들에서 0 혹은 Good 상태에서 A가 들어오면 A를, B가 들어오면 B를, A 상태에서 B가 들어오면 Good을, B 상태에서 A가 들어오면 Good을 backPhone에 저장한다
// 이후 상태가 A 혹은 B 인 즉, 뺏긴 학생들의 이름만 출력해준다
