import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<Integer>[] edges;
    static boolean[] visited;
    static int[] dist;
    static int cycleStartPoint;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        edges = new List[n];
        visited = new boolean[n];
        dist = new int[n];
        Arrays.fill(dist, -1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (edges[a] == null) edges[a] = new ArrayList<>();
            if (edges[b] == null) edges[b] = new ArrayList<>();
            edges[a].add(b);
            edges[b].add(a);
        }
        visited[0] = true;
        dfs(0, -1);
//        System.out.println(Arrays.toString(dist));
        visited = new boolean[n];
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb. append(dist[i]).append(' ');
        }
        System.out.println(sb);
    }

    static boolean dfs(int a, int prev) {
        boolean isCycle = false;
//        System.out.println("in  dfs: "+a+" "+isCycle);
        for (int num : edges[a]) {
            if (num == prev) continue;
            if ( visited[num]) {
                dist[num] = 0;
                cycleStartPoint = num;
                isCycle = true;
            }else{
                visited[num] = true;
                if (dfs(num, a)){
                    isCycle = true;
                }
            }
        }
//        System.out.println("out dfs: "+a+" "+isCycle);
        if (isCycle) {
            if (dist[a] == 0) isCycle = false;
            else dist[a] = 0;
        }
        return isCycle;
    }

    static void bfs(){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{cycleStartPoint, 0});
        visited[cycleStartPoint] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (Integer i : edges[cur[0]]) {
                if (!visited[i]) {
                    visited[i] = true;
                    if ( dist[i] == -1 ) dist[i] = cur[1]+1;
                    queue.add(new int[]{i, dist[i] == 0 ? 0 : cur[1]+1});
                }
            }
        }
    }
}