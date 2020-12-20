import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        
        Point[] point = new Point[3];
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double[] distance = new double[3];
        
        String[] splitArray = bufR.readLine().split(" ");
        
        point[0] = new Point(Integer.parseInt(splitArray[0]), Integer.parseInt(splitArray[1]));
        point[1] = new Point(Integer.parseInt(splitArray[2]), Integer.parseInt(splitArray[3]));
        point[2] = new Point(Integer.parseInt(splitArray[4]), Integer.parseInt(splitArray[5]));

        // 세 점이 일직선 상에 있어서 사각형을 만들 수 없는 경우
        if((point[1].y - point[0].y) * (point[2].x - point[1].x)
            ==
            (point[1].x - point[0].x) * (point[2].y - point[1].y)) 
        {
            System.out.println("-1");
        }
        // 각각으로 만들 수 있는 변을 계산한 후에 최대 최소값을 계산
        else {
            double one = Math.sqrt(
                Math.pow(point[1].y - point[0].y, 2) + Math.pow(point[1].x - point[0].x, 2)
            );
            double two = Math.sqrt(
                Math.pow(point[2].y - point[0].y, 2) + Math.pow(point[2].x - point[0].x, 2)
            );
            double three = Math.sqrt(
                Math.pow(point[2].y - point[1].y, 2) + Math.pow(point[2].x - point[1].x, 2)
            );
            distance[0] = one + two;
            distance[1] = two + three;
            distance[2] = one + three;

            for(int i=0; i<3; i++) {
                min = (min > distance[i]) ? distance[i] : min;
                max = (max < distance[i]) ? distance[i] : max;
            }

            System.out.println(max * 2 - min * 2);
        }
    }
    
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
        
