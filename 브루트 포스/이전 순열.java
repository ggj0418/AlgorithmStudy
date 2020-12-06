// https://www.acmicpc.net/problem/10973
// 백준 10973 이전 순열
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		
        boolean flag = false;
        int N = Integer.parseInt(bufR.readLine());
        int[] array = new int[N];
        String[] splitArray = bufR.readLine().split(" ");
		
        for(int i=0;i<N;i++) array[i] = Integer.parseInt(splitArray[i]);
		
        for(int i=N-1;i>=0;i--) {
            // 이 for문이 끝날때까지 break가 걸리지 않는다는 것은 주어진 숫자열이 오름차순으로 끝까지 간다는 소리 <=> 이보다 작은 순열이 없다
            if(i == 0) {
                flag = true;
                break;
            }
		
            // 내림차순인 인덱스를 발견하면 (즉 이전 순열이 존재할 수 있는 구간을 발견하면)
            if(array[i] < array[i-1]) {
                int left = i-1;
                int right = array.length-1;
				
                // 내림차순이 시작되는 i-1(left) 부터 시작해서 그 뒤에 있는 숫자들을 뒤에서부터 보면서 처음으로 left 값보다 같거나 작은 값을 찾는다
                // 그 이유는 만약 1 2 5 3 6 7 이라고 하면 left는 5의 인덱스가 될 것이다.
                // 이 때에 이전 순열이 될 순열은 left인 5와 그 다음 같거나 작은 값인 3을 바꾸고 뒤에 값을 정리한 값이다 (5 뒤에는 전부 오름차순이기 때문에 앞 숫자를 바꾸는것이 이전값이 된다)
                while(left < right) {
                    if(array[left] >= array[right]) {
                        int temp = array[left];
                        array[left] = array[right];
                        array[right] = temp;
                        break;
                    }
                    right--;
                }
                
                // 위의 left(i-1)를 이전 순열의 값으로 바꾸어주었고, 위에서 바꾼 right는 left보다 작거나 같은 최초의 수였기 때문에 
                // 바꾼다고 해도 left 뒤의 부분이 오름차순이라는 것은 변함이 없다.
                // 따라서 left 뒤의 값들을 내림차순으로 바꾸어주는 작업을 진행한다
                // 이미 오름차순이었기 때문에 이분탐색으로 자리만 바꿔줘도 내림차순으로 변경 가능하다
                left = i;
                right = array.length-1;
                
                while(left < right) {
                    int temp2 = array[left];
                    array[left] = array[right];
                    array[right] = temp2;
                    left++;
                    right--;
                }
                
                // 내림차순인 부분이 있다는 것은  순열이 있다는 뜻이므로 작업을 진행하고 16번째 줄의 for문을 종료해준다
                break;
            }
        }
		
        if(flag) System.out.println(-1);
        else {
            for(int i : array) System.out.print(i + " ");
        }
    }
}

// 10972 다움 순열과 차순만 다르게 해서 풀면 되는 문제
