import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<int[]>[] vertex = new List[n];
        for (int i = 0; i < n; i++) {
            vertex[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            vertex[a].add(new int[]{b,c});
        }
        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken())-1;
        int endCity = Integer.parseInt(st.nextToken())-1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dp = new int[n];
        Arrays.fill(dp, MAX);
        dp[startCity] = 0;
        pq.add(new int[]{startCity, 0});

        while (!pq.isEmpty()) {
            int[] nextVertex = pq.poll();
            if(dp[nextVertex[0]] != nextVertex[1]) continue;
            if(nextVertex[0] == endCity)break;

            for(int[] nextEdge: vertex[nextVertex[0]]){
                if(dp[nextEdge[0]]>nextVertex[1]+nextEdge[1]){
                    dp[nextEdge[0]]=nextVertex[1]+nextEdge[1];
                    pq.add(new int[]{nextEdge[0], nextVertex[1]+nextEdge[1]});
                }
            }
        }
        System.out.println(dp[endCity]);
    }
}