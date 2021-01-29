// https://www.acmicpc.net/problem/1440
// 백준 1440번 타임머신
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int canHour = 0, canOther = 0;
        String[] splitArray = bufR.readLine().split(":");
        
        for(int i=0;i<3;i++) {
            int time = Integer.parseInt(splitArray[i]);
            if(time >= 1 && time <= 12) {
                canHour++;
                canOther++;
            } else if(time == 0 || time <= 59) {
                canOther++;
            }
        }
        
        // 시간으로 쓸 수 있는 값이면 분초로도 쓸 수 있다는 것을 명심
        if(canHour == 0) {  // 시간으로 쓸 수 있는 숫자가 없으면 순서를 바꿔도 만들 수 있는 조합이 없다
            bufW.write(0 + "\n");
        } else if(canHour == 1 && canOther == 3) {  // 시간으로 쓸 수 있는 숫자가 1개고 분초로 쓸 수 있는 숫자가 전체라면 시간을 고정으로 넣어놓고 분초만 바꾸는 2가지 경우이다
            bufW.write(2 + "\n");
        } else if(canHour == 2 && canOther == 3) {  // 시간이 2개이고 분초로 쓸 수 있는 숫자가 전체라면 시간 2 * 분 2 * 초 1 = 4이다
            bufW.write(4 + "\n");
        } else if(canHour == 3) { // 시간으로 쓸 수 있는게 3개이면 모든 칸에 숫자를 넣을 수 있으므로 시간 3 * 분 2 * 초 1 = 6이다
            bufW.write(6 + "\n");
        } else {  // 그 외의 경우는 분초가 3보다 작은 숫자인 경우이므로 만들 수 있는 조합이 없다
            bufW.write(0 + "\n");
        }
        
        bufW.flush();
        bufW.close();
        bufR.close();
    }
}
// 문제를 푸는 메인 로직은 시간으로 쓸 수 있는 숫자가 몇개인지, 분/초로 쓸 수 있는 숫자가 몇개인지 체크하는 것이다.
