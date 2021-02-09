// https://www.acmicpc.net/problem/1342
// 백준 1342번 행운의 문자열
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String S = in.readLine();
        int[] alphabet = new int[26];
        
        for(int i=0;i<S.length();i++) {
            alphabet[S.charAt(i)-'a']++;
        }
        int answer = backTracking(0, '0', S.length(), alphabet);
        
        out.write(String.valueOf(answer));
        out.flush();
        out.close();
        in.close();
    }
    
    private static int backTracking(int index, char preChar, int length, int[] alphabet) {
        int count = 0;
        
        if(index == length) {
            count++;
        } else {
            for(int i=0;i<26;i++) {
                int num = 'a' + i;
                if(alphabet[i] > 0 && ('a' + i) != preChar) {
                    alphabet[i]--;
                    count += backTracking(index+1, (char)('a'+i), length, alphabet);
                    alphabet[i]++;
                }
            }
        }
        
        return count;
    }
}

/*
문제를 해결한 핵심 로직은 순열 방식으로 주어진 문자열을 한 글자씩 배치해가면서 정답을 백트래킹 방식으로 찾은 것이다
먼저 사용자로부터 입력받은 문자열을 한 글자씩 기준으로 해서 총 사용되는 개수를 int형 배열에 저장한다. (char -> int 형변환)
a~z까지 모든 문자를 돌면서 이전에 사용된 문자와 다른 문자이고, 아직 사용할 수 있는 개수가 남아있는 문자 인덱스에 다다르면 해당 문자를 사용하고 다음 페이즈로 넘긴다
만약 완성된 행운의 문자열이 있으면 count를 ++ 해주고 이 값을 리턴해준다
행운의 문자열이 아닌 경우는 for문에서 다음 페이즈로 넘어가지 못해서 끝나고 행운의 문자열인 경우 35번째 줄의 가지 시작점에 count가 모이게 된다.
따라서 최종적으로 모이는 값을 리턴해주면 정답이다
*/
