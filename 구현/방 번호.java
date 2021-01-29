// https://www.acmicpc.net/problem/1475
// 백준 1475번 방 번호
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String N = bufR.readLine();
        Integer[] numbers = new Integer[9];
        Arrays.fill(numbers, 0);
        
        for(int i=0;i<N.length();i++) {
            if(N.charAt(i) == '6' || N.charAt(i) == '9') {
                numbers[6]++;
            } else {
                int number = N.charAt(i) - '0';
                numbers[number]++;
            }
        }
        numbers[6] = (int) Math.ceil(numbers[6] / 2.0);
        Arrays.sort(numbers, Collections.reverseOrder());
        
        bufW.write(numbers[0] + "\n");
        bufW.flush();
        bufW.close();
        bufR.close();
    }
}
// 문제를 푸는 로직 자체는 어렵지 않다. 그냥 0~8까지 담은 정수형 배열을 선언한 다음, N의 자리수를 전부 다 배열에 넣어놓고 (9는 6와 같은 취급), 숫자 6은 같은 세트의 9로 대용할 수 있기 때문에
// numbers[6]을 2로 나눈 후 올림시킨다 이후에 배열을 내림차순 정렬해서 가장 큰 값을 출력해주면 된다
// 여기서 약간 헷갈렸던 부분은 3가지이다.
// 1. Arrays.fill을 시켜주지 않으니 17번째 줄에서 NullPointerError가 떴다. Integer 형식으로 선언한 것에서 뭔가 포인트가 있는 듯하다
// 2. Math.ceil에서 올바른 올림을 하기 위해서 2가 아닌 2.0으로 나누어주었다
// 3. Arrays.sort를 reverseOrder해주는 과정에서 reverseOrder가 Collections의 메서드다보니 primitive 형식으로 선언해주어야 작동하는 듯하다(int -> Integer)
