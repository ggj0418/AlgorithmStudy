// https://www.acmicpc.net/problem/1271
// 백준 1271번 엄청난 부자2
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(r.readLine());
        
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());
        
        w.write(n.divide(m) + "\n");
        w.write(n.remainder(m) + "\n");
        w.flush();
    }
}

/// 얼핏 보면 굉장히 간단한 문제이다.
/// 단순히 몫과 나머지를 출력해주면 될 것 같은 문제이지만 입력값을 살펴보면 10의 1000승으로,
/// long 이라는 정수형 타입을 한참 웃도는 범위이다.
/// 따라서 BigInteger라는 무한의 정수를 처리할 수 있는 타입으로 초기화해서 처리했다.
/// BigInteger가 String 타입을 활용해서 계산을 하는 방식이라던데 이를 구현해보고 싶다.
