// https://www.acmicpc.net/problem/1302
// 백준 1302번 베스트셀러
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] ars) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new HashMap<>();
        
        int n = Integer.parseInt(in.readLine());
        while(n-- > 0) {
            String title = in.readLine();
            
            map.put(title, map.getOrDefault(title, 0) + 1);
        }
        
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) == map.get(o2)) {
                    return o1.compareTo(o2);
                }
                return map.get(o2) - map.get(o1);
            }
        });
        
        out.write(keyList.get(0));
        out.flush();
        out.close();
        in.close();
    }
}
