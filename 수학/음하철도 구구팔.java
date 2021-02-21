// https://www.acmicpc.net/problem/1393
// 백준 1393번 음하철도 구구팔

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int stationX = Integer.parseInt(st.nextToken());
		int stationY = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		int subwayX = Integer.parseInt(st.nextToken());
		int subwayY = Integer.parseInt(st.nextToken());
		int dx = Integer.parseInt(st.nextToken());
		int dy = Integer.parseInt(st.nextToken());
		
		int gcd = getGcd(dx, dy);
		dx /= gcd;
		dy /= gcd;
		
		double preDistance = getDistance(stationX, stationY, subwayX, subwayY);
		while(true) {
		    subwayX += dx;
		    subwayY += dy;
		    double distance = getDistance(stationX, stationY, subwayX, subwayY);
		    
		    // 이전 직선거리보다 지금 직선거리가 더 길면 이전 포인트가 최소 거리였다는 소리이다
		    if(distance > preDistance) {
		        subwayX -= dx;
		        subwayY -= dy;
		        
		        out.write(subwayX + " " + subwayY);
		        break;
		    }
		    
		    preDistance = distance;
		}
		
		out.flush();
		out.close();
		in.close();
	}
	
	private static int getGcd(int a, int b) {
	    if(b == 0) return a;
	    else return getGcd(b, a % b);
	}
	
	private static double getDistance(int stationX, int stationY, int subwayX, int subwayY) {
	    return Math.sqrt(Math.pow(Math.abs(stationX-subwayX), 2) + Math.pow(Math.abs(stationY-subwayY), 2));
	}
}

// 현재 전철 위치에서 주어진 초당 이동량만큼 계속 이동하면서 정거장과의 직선거리가 가장 최소가 되는 전철의 위치를 구하는 방식이다.
// 이 문제를 풀 때에 헷갈릴 만한 포인트가 2개 있는데
// 하나는 초당 이동량을 서로소로 만들어야한다는 것이고
// (입력 예시에서 힌트를 얻었다. 초기 위치가 (2,1) 이고 이동량이 (2,4)  인데 정답은 (3,3)인 나올 수 없는 값인데 이동량을 서로소로 만들면 가능)
// 나머지 하나는 dx,dy가 양수라면 양의 방향으로만 진행하고 음수라면 음의 방향으로만 진행한다는 것이다 (ex 2,3이라면 2,3 만큼 뒤로 이동하지는 않는다는 것이다)
// 초기 입력값에서의 정류장과 전철과의 거리를 미리 구한 다음, dx', dy' (서로소) 만큼 이동하면서 직전값(preDistance)과 비교해서 현재의 거리측정값이 더 큰 좌표를 구한 후
// 직전값이 나오게 된 전철의 좌표를 구해서 출력해주면 된다 (1차 그래프이기 때문에 한번 값이 증가하면 계속 증가하기 때문에 최소값은 유일하다)
