import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        int[] array = new int[5];
        
        String[] splitArray = bufR.readLine().split(" ");
        for(int i=0;i<5;i++) array[i] = Integer.parseInt(splitArray[i]);
        
        int result = 1;
        
        while(true) {
            int count = 0;
            
            for(int i=0;i<5;i++) {
                if(result % array[i] == 0) count++;
            }
            
            if(count >=3) break;
            result++;
        }
        
        System.out.println(result);
    }
}
