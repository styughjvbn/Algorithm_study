import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        for (;k>0; k--) {
            st = new StringTokenizer(br.readLine(), " ");

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            List<Integer>[] edges = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                edges[u].add(v);
                edges[v].add(u);
            }
            int[] visit = new int[V];
            boolean isBipartite = true;
            for (int i = 0; i < V; i++) {
                if(!isBipartite)
                    break;
                if(visit[i] != 0)
                    continue;
                Deque<Integer> deque = new ArrayDeque<>();
                deque.add(i);
                visit[i] = 1;
                while (isBipartite && !deque.isEmpty()) {
                    int vertex = deque.pollFirst();
                    for (Integer adjustVertex : edges[vertex]) {
                        if (visit[adjustVertex] == visit[vertex]) {
                            isBipartite = false;
                            break;
                        }
                        if (visit[adjustVertex] == 0 ){
                            deque.add(adjustVertex);
                            visit[adjustVertex] = visit[vertex] * -1;
                        }
                    }
                }
            }
            if(isBipartite){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}