// https://www.acmicpc.net/problem/1188
// 백준 1188번 음식 평론가
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(bufR.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int answer = M - getGcd(N,M);
        bufW.write(answer + "\n");
        bufW.flush();
        bufW.close();
        bufR.close();
    }
    
    private static int getGcd(int a, int b) {
        if(b == 0) return a;
        else return getGcd(b, a % b);
    }
}

// 이 문제는 N과 M이 서로소인 경우와 서로소가 아닌 경우로 분류할 수 있다.
// 먼저 서로소가 아닌 경우를 살펴보면
// g = gcd(N,M) 이라고 가정하고 f(N,M) 이 해당 문제의 정답이라고 하자.
// f(N,M) = f(N/g, M/g) * g 이다. (만약 2개의 소시지로 6명에게 분배한다고 하면 1개 3명의 답인 2에서 2를 곱해서 만든 값인 4가 된다)
// 이때, N/g, M/g는 서로소이기 때문에 서로소가 아닌 경우를 생각하지 않고 서로소인 경우만 값을 구하면 된다
// 어떤 gcd(x,y) = 1인 x,y값에서 문제의 답을 찾아보자. 소시지를 일자로 붙여놓고 자른다고 생각해보자. 일자일때는 x / y 부분으로 나누면 정확하게 등분이 된다.
// gcd(x,y) = 1일 때, d = x / y 라고 가정하면 (d는 자르는 부분이라고 생각하면 됨)
// d * (1,2, ... , y-1)를 생각해보면 d는 항상 분수이기 때문에 자르는 지점은 이어붙인 곳이 될 수 없다 (d * (1,2....,y-1) 이 부분을 (1,2....,y-1) * x / y 이렇게 생각하면 이해가 쉽다)
// 따라서 자르는 지점이 붙인 곳이 될 수 없으므로 소시지는 y-1 (사람 수 - 1) 만큼만 자르면 된다
//
// 이걸 수식으로 표현해보면
// f(N/g, M/g) = f(x, y) = y - 1
// f(N, M) 
//    = f(N/g, M/g) * g 
//    = (y-1) * g 
//    = y*g - g
//    = M - gcd(N,M)
//
// 따라서 f(N, M) = M - gcd(N, M)
