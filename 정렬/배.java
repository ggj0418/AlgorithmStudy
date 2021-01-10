// https://www.acmicpc.net/problem/1092
// 백준 1092번 배
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(bufR.readLine());
		
    List<Integer> crane = new ArrayList<>();
    List<Integer> box = new ArrayList<>();

    int N = Integer.parseInt(st.nextToken());
		
    st = new StringTokenizer(bufR.readLine());
    for (int i=0;i<N;i++) {
      crane.add(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(bufR.readLine());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(bufR.readLine());
    for (int i=0;i<M;i++) {
      box.add(Integer.parseInt(st.nextToken()));
    }

    // 적재량이 큰 크레인 순, 무게가 무거운 박스 순으로 정렬
    Collections.sort(crane, Collections.reverseOrder());
    Collections.sort(box, Collections.reverseOrder());

    int result = go(crane, box, N);

    bufW.write(result + "\n");
    bufW.flush();
    bufW.close();
    bufR.close();
  }

  private static int go(List<Integer> crane, List<Integer> box, int N) {
    // 제일 적재량이 큰 크레인보다 제일 무거운 박스가 더 크면 아웃
    if (crane.get(0) < box.get(0)) {
      return -1;
    }

    int time = 0;
    // 박스를 다 옮길때까지
    while (box.size() != 0) {
      int craneIndex = 0;
      int boxIndex = 0;
      // 모든 크레인들이 옮길 박스가 있는지 한번 살펴보는게 한 턴
      while (craneIndex < N) {
        if (boxIndex == box.size()) break;  // 박스 인덱스가 박스 리스트의 끝까지 갔다는 것은 해당 박스를 옮길 크레인이 비어있지 않다는 뜻이므로 해당 턴 중단
        if (box.get(boxIndex) <= crane.get(craneIndex)) {  // 해당 인덱스의 크레인이 현재 남아있는 박스 중 가장 무거운 박스를 옮길 수 있으면 옮겨주고 다음 크레인으로 인덱스 넘김
          box.remove(boxIndex);
          craneIndex++;
        } else if (box.get(boxIndex) > crane.get(craneIndex)) { // 현재 인덱스의 크레인이 가장 무거운 박스를 옮길 수 없으면 다음 박스를 탐색
          boxIndex++;
        }
      }
      time++;
    }
    return time;
  }
}
