// https://www.acmicpc.net/problem/1117
// 백준 1117번 색칠 1
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(bufR.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		BigInteger absX = BigInteger.valueOf(x2).subtract(BigInteger.valueOf(x1));      // x2 - x1
		BigInteger absY = BigInteger.valueOf(y2).subtract(BigInteger.valueOf(y1));      // y2 - y1
		BigInteger colorArea = absX.multiply(absY).multiply(BigInteger.valueOf(c+1));   // (x2 - x1) * (y2 - y1) * (c+1)
		BigInteger width = BigInteger.valueOf(W).multiply(BigInteger.valueOf(H));       // W * H
		
		// 만약 오른쪽 크기가 더 커서 왼쪽이 오른쪽에 다 덮힌다면
		if(f <= W / 2) {
		    if(f <= x1) {   // 접히는 부분이 x1보다 더 왼쪽에 있어서 영향이 없을 때
		        bufW.write(width.subtract(colorArea) + "\n");                                                               // W * H - colorArea
		    } else {        // 접히는 부분이 x1보다 오른쪽에 있어서 영향이 있을 때
		        // W * H - (colorArea + (min(f, x2) - x1) * (y2 - y1) * (c+1))
		        BigInteger temp1 = BigInteger.valueOf(f).min(BigInteger.valueOf(x2)).subtract(BigInteger.valueOf(x1));      // Math.min(f, x2) - x1
		        BigInteger temp2 = temp1.multiply(absY).multiply(BigInteger.valueOf(c+1));                                  // (Math.min(f, x2) - x1) * (y2 - y1) * (c+1)
		        bufW.write(width.subtract(colorArea).subtract(temp2) + "\n");                                               // W * H - (colorArea + (Math.min(f, x2) - x1) * (y2 - y1) * (c+1))
		    }
		}
		// 만약 오른쪽 크기가 더 작아서 왼쪽이 오른쪽보다 튀어나올 때
		else {
		    if(W <= x1 + f) {   // 근데 칠해지는 부분이 튀어나온 부분이 아닐 때
		        bufW.write(width.subtract(colorArea) + "\n");                                                               // W * H - colorArea
		    } else {            // 칠해지는 부분이 튀어나온 부분을 일부 포함한 경우
		        BigInteger temp1 = BigInteger.valueOf(W).min(BigInteger.valueOf(f + x2)).subtract(BigInteger.valueOf(f + x1));      // Math.min(W, f + x2) - (f + x1)
		        BigInteger temp2 = temp1.multiply(absY).multiply(BigInteger.valueOf(c+1));                                  // (Math.min(W, f + x2) - (f + x1)) * (y2 - y1) * (c+1)
		        bufW.write(width.subtract(colorArea).subtract(temp2) + "\n");                                               // W * H - (colorArea + (Math.min(W, f + x2) - (f + x1)) * (y2 - y1) * (c+1))
		    }
		}
		
		bufW.flush();
		bufW.close();
		bufR.close();
	}
}

// 구현적으로는 접었을 때 접은 부분이 덮히는 부분보다 튀어나가는지 먼저 분류해주고 칠하는 부분이 튀어나간 부분을 포함하는지 안하는지를 추가적으로 고려해서 해당 부분을 처리해주면 된다.
// 질문이 엄청 길어서 어려워보이지만 사실은 접는 횟수가 그렇게 많지 않기 때문에 (세로로 한번, 가로로 C번 만큼) 케이스를 분류하기 쉬운 문제였다
// 하지만 문제는 overflow 였는데, 처음엔 int로 처리했더니 실패했다. 숫자 하나가 10^9까지 범위를 가지기 때문이었다.
// 두번째로는 long으로 시도했는데 long조차도 overflow가 떴다.
// 마지막으로 처음 써보는 BigInteger를 사용해봤는데 성공했다!!
// 실제로 BigInteger는 끝없이 수를 담을 수 있다고 한다. (문자열 형태로 이루어져 있기 때문이라고 한다)
// 하지만 관련된 문법이 존재해서 간단한 수식을 구현하는 데에도 큰 어려움을 겪었다.
