import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] course = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            course[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for( int i = 0; i < n; i++ ) {
            while(!deque.isEmpty() && course[deque.peekLast()] < course[i]) deque.pollLast();
            deque.addLast(i);
//            System.out.println(deque);
            if(deque.peekFirst() <= i - (m*2-1)) deque.pollFirst();
//            System.out.println(deque);

            if(i>= 2*m-2) sb.append(course[deque.peekFirst()]).append(" ");
        }

        System.out.println(sb);
    }
}
