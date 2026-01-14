import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            String numStr = br.readLine();
            if (numStr.charAt(0) == '0') {
                if(!pq.isEmpty())
                    sb.append(pq.poll());
                else
                    sb.append('0');
                sb.append('\n');
            }else{
                Integer num = Integer.parseInt(numStr);
                pq.add(num);
            }
        }

        System.out.println(sb);
    }
}