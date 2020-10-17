// https://www.acmicpc.net/problem/2309
// 백준 2309 일곱 난쟁이
import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited = new boolean[9];
    static int[] array = new int[9];
    static boolean flag = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<9;i++) array[i] = Integer.parseInt(bufR.readLine());
        
        backTracking(0, 0, list);
    }
    
    static void backTracking(int index, int sum, List<Integer> list) {
        if(flag) return;
        
        if(index == 7 && list.size() == 7) {
            if(sum == 100) {
                Collections.sort(list);
                for(int i=0;i<list.size();i++) System.out.println(list.get(i));
                flag = true;
            }
            return;
        }
        
        for(int i=0;i<9;i++) {
            if(visited[i]) continue;
            if(sum + array[i] <= 100) {
                visited[i] = true;
                list.add(Integer.valueOf(array[i]));
                backTracking(index+1, sum+array[i], list);
                visited[i] = false;
                list.remove(Integer.valueOf(array[i]));
            }
        }
    }
}
