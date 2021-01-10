// https://www.acmicpc.net/problem/1107
// 백준 1107번 리모컨
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        boolean[] isBroken = new boolean[10];
        int N = scan.nextInt();
        int M = scan.nextInt();
        
        for(int i=0;i<M;i++) {
            int brokenNumber = scan.nextInt();
            isBroken[brokenNumber] = true;
        }
        
        // 초기 위치 100에서 타깃까지 그냥 +,-만 사용해서 간 경우
        int answer = Math.abs(N - 100);
        
        // 해당 리모컨으로 갈 수 있는 최대 채널이 999999이므로 이 값까지 모두 브루트포스 진행
        for(int i=0;i<=999999;i++) {
            String temp = Integer.toString(i);
            int length = temp.length();
            
            boolean hasBrokenNumber = false;
            // 제일 앞자리수부터 체크해서 채널 i가 고장한 버튼을 포함하는지 체크
            for(int j=0;j<length;j++) {
                if(isBroken[temp.charAt(j) - '0']) {
                    hasBrokenNumber = true;
                    break;
                }
            }
            
            // 고장난 버튼을 포함하지 않는 숫자라면
            // 해당 i 채널로 가기 위해 숫자를 클릭한 갯수 length와
            // i 채널에서 원하는 채널인 N까지 가기위해서 +/-을 클릭한 횟수를 더한 후
            // 해당 횟수 중에서 최소값을 구한다
            if(!hasBrokenNumber) {
                int min = Math.abs(N - i) + length;
                answer = Math.min(min, answer);
            }
        }
        
        System.out.println(answer);
    }
}

// 처음에는 BufferedReader, BufferedWriter를 사용해서 값을 구했는데 런타임에러가 떴다.
// BufferedWriter만 System 출력으로 바꿔봐도 마찬가지였다.
// 그래서 Integer.toString도 String.valueOf로 바꿔보고, import도 딱 사용하는 모듈만 명시해보기도 하고 했는데 여전히 런타임에러가 떴다.
// 혹시나 싶어서 Scanner, System 출력으로 바꿔보니 런타임에러가 해소되었다.
// 뭐지... 원래 Buffered 세트가 더 빠른것이 아니었나...????
