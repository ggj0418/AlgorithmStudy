import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX = Integer.MAX_VALUE / 2 - 1;
    
        public static void main(String[] args) throws IOException {
		        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(in.readLine());
            int answer = 0;
        
            int computers = Integer.parseInt(st.nextToken());
            int lines = Integer.parseInt(st.nextToken());
            int[][] connecionValue = new int[computers+1][computers+1];
        
            for(int i=1;i<=computers;i++) {
                for(int j=1;j<=computers;j++) {
                    if(i != j) connecionValue[i][j] = MAX;
                }
            }
        
            while(lines-- > 0) {
                st = new StringTokenizer(in.readLine());
            
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
            
                connecionValue[start][end] = Math.min(connecionValue[start][end], value);
                connecionValue[end][start] = connecionValue[start][end];
            }
        
            floydWarshall(computers, connecionValue);
        
          int previousSum = Integer.MAX_VALUE;
          for(int i=1;i<=computers;i++) {
                int sum = 0;
                for(int j=1;j<=computers;j++) {
                    if(i == j) continue;
                    sum += connecionValue[i][j];
                }
            
                if(previousSum > sum) {
                previousSum = sum;
                answer = i;
            }
        }
		
    		out.write(String.valueOf(answer));
    		out.flush();
    		out.close();
    		in.close();
	  }
	
	  private static void floydWarshall(int city, int[][] distance) {
        for(int a=1;a<=city;a++) {
            for(int b=1;b<=city;b++) {
                for(int c=1;c<=city;c++) {
                    distance[b][c] = Math.min(distance[b][a] + distance[a][c], distance[b][c]);
	                  distance[c][b] = distance[b][c];
	              }
	          }
	      }
	  }
}
