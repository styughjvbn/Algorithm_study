import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//중요도가 같은 문서가 여러개 있을 수 있으므로 단순히 우선순위큐를 사용해서느 안된다.

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Deque<int[]> deque = new ArrayDeque<>();

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(new int[]{i, num});
                pq.add(num);
            }

            boolean isEnd = false;
            for (int i = 0; i < n; i++) {
                while (!deque.isEmpty()) {
                    int[] doc = deque.pollFirst();
                    if (pq.peek() == doc[1]) {
                        pq.poll();
                        if (doc[0] == m) {
                            sb.append(i + 1).append('\n');
                            isEnd = true;
                        }
                        break;
                    } else {
                        deque.addLast(doc);
                    }
                }
                if (isEnd)
                    break;
            }

        }
        System.out.println(sb);
    }
}