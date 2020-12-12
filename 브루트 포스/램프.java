// https://www.acmicpc.net/problem/1034
// 백준 1034번 램프
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        
        String[] splitArray = bufR.readLine().split(" ");
        int N = Integer.parseInt(splitArray[0]);
        int M = Integer.parseInt(splitArray[1]);
        
        for(int i=0;i<N;i++) list.add(bufR.readLine());
        
        int K = Integer.parseInt(bufR.readLine());
        
        for(int i=0;i<N;i++) {
            int zeroNumber = 0;
            
            for(int j=0;j<M;j++) {
                if(list.get(i).charAt(j) == '0') zeroNumber++;
            }
            
            int count = 0;
            // 둘다 홀수거나 짝수면 true 아니면 false
            if(zeroNumber <= K && !(isOdd(zeroNumber) ^ isOdd(K))) {
                for(int k=0;k<N;k++) {
                    if(list.get(i).equals(list.get(k))) count++;
                }
            }
            
            max = Math.max(max, count);
        }
        
        System.out.println(max);
    }
    
    public static boolean isOdd(int num) {
        return num % 2 == 1;
    }
}

문제에서 원하는 조건은 K번 스위치를 누른 이후에 켜져있는 행(행의 값들이 전부 1인 행)의 최대값을 구하는 것이다.
이 때에, 스위치로 컨트롤 하는것은 열이기 때문에 만약 서로 다른 두 행이 다른 패턴을 가지고 있다면 죽었다깨어나도 두 행을 동시에 켜져있는 행으로 만들지 못한다
다른 패턴이라는 뜻은 같은 열에 두 행이 서로 다른 값을 가진다는 것인데 열 단위로 한꺼번에 값을 바꾸는 스위치의 특성상 두 행을 동시에 켜져있게 만들지 못한다
따라서 서로 다른 두 행간에 같은 패턴을 가지고 있고, 이러한 패턴이 행렬에 최대한 많이 분포되어있는 값을 찾아서 계산하면 된다.

또한 패턴 내에서의 0을 모두 1로 바꿀 수 있어야하기 때문에
하나의 행에서 존재하는 0의 개수가 스위치를 조작하는 K 번보다 크면 해당 행의 0을 전부 1로 바꾸지 못하므로 켜져있는 행을 만들지 못한다.
마지막으로 하나의 행에서 존재하는 0의 개수가 K와 짝홀이 같아야하는데, 서로 다를 경우 K번을 모두 써야하는 문제의 조건상, 최소 하나의 값이 0으로 다시 바뀌기 때문이다.
ex) k가 3이고 행이 1 0 0 1 인 경우 k를 2번 활용해서 1 1 1 1 을 만들었지만 마지막 1번에서 어떠한 값은 반드시 0으로 바뀌어야한다
