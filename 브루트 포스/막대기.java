import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        int length = 64;
        int count = 0;
        
        int X = Integer.parseInt(bufR.readLine());
        
        while(X > 0) {
            if(length > X) {
                length /= 2;
            } else {
                X -= length;
                count++;
            }
        }
        
        System.out.println(count);
    }
}
