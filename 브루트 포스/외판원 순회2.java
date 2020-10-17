// https://www.acmicpc.net/problem/10971
// 백준 10971번 외판원 순회2
import java.io.*;
import java.util.*;
 
public class Main {
    static int n;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(bufR.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
 
        for (int i=0;i<n;i++) {
            String[] splitArray = bufR.readLine().split(" ");
            for (int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(splitArray[j]);
            }
        }
        for (int i=0;i<n;i++) {
            backTracking(i,i,0,0);
        }
        
        System.out.println(min);
    }
    
    static void backTracking(int start, int index, int count, int sum){
        if(count == n && start == index){
            min = Math.min(min, sum);
            return;
        }
        for (int j = 0; j <n ; j++) {
            if(arr[index][j]==0){
                continue;
            }
 
            if(!visited[index] && arr[index][j] > 0){
                visited[index]=true;
                sum += arr[index][j];
                backTracking(start, j, count+1, sum);
                visited[index] = false;
                sum -= arr[index][j];
            }
        }
    }
 
}
