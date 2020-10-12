// https://www.acmicpc.net/problem/6588
// 백준 6588번 골드바흐의 추측
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[] arr = new boolean[1000001];
        arr[0] = arr[1] = false;
        for(int i=2; i<1000001; i+=1) {
            arr[i] = true;
        }
        for(int i=2; i*i<1000001; i+=1) {
            for(int j=i*i; j<1000001; j+=i) {
                arr[j] = false;
            }
        }
        
        while(true) {
            int num = Integer.parseInt(bufR.readLine());
            if(num == 0) break;
            
            getGoldbach(num, arr);
        }
    }
    
    private static void getGoldbach(int num, boolean[] arr) {
        int left = 0, right = num;
        
        while(left <= right) {
            if(arr[left] && arr[right]) {
                System.out.println(num + " = " + left + " + " + right);
                return;
            }
            left++;
            right--;
        }
        
        System.out.println("Goldbach's conjecture is wrong.");
    }
}
