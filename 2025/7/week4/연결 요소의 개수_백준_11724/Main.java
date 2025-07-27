import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            edges[u].add(v);
            edges[v].add(u);
        }

        int[] visit = new int[n];
        int connectedComponentCount = 0;
        for (int i = 0; i < n; i++) {
            if(visit[i] != 0)
                continue;
            connectedComponentCount++;
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(i);
            visit[i] = 1;
            while(!deque.isEmpty()){
                int vertex = deque.pollFirst();
                for (Integer adjustVertex : edges[vertex]) {
                    if(visit[adjustVertex] != 0)
                        continue;
                    visit[adjustVertex] = 1;
                    deque.add(adjustVertex);
                }
            }
        }
        System.out.println(connectedComponentCount);
    }
}