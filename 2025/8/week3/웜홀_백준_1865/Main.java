import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int[][] edges = new int[2*m+w][3];
            int idx = 0;
            for (int i1 = 0; i1 < m; i1++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken()) -1;
                int e = Integer.parseInt(st.nextToken()) -1;
                int t = Integer.parseInt(st.nextToken());
                edges[idx++] = new int[]{s,e,t};
                edges[idx++] = new int[]{e,s,t};
            }
            for (int i1 = 0; i1 < w; i1++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken()) -1;
                int e = Integer.parseInt(st.nextToken()) -1;
                int t = Integer.parseInt(st.nextToken());
                edges[idx++] = new int[]{s,e,-t};
            }

            int[] dist = new int[n];
            Arrays.fill(dist, 0);
            for (int i1 = 0; i1 < n-1; i1++) {
                for (int i2 = 0; i2 < idx; i2++) {
                    int s = edges[i2][0];
                    int e =edges[i2][1];
                    int t = edges[i2][2];
                    if(dist[e]>dist[s]+t){
                        dist[e] = dist[s]+t;
                    }
                }
//                System.out.println(Arrays.toString(dist));
            }
            boolean existNegativeCycle = false;
            for (int i2 = 0; i2 < idx; i2++) {
                int s = edges[i2][0];
                int e =edges[i2][1];
                int t = edges[i2][2];
                if(dist[s]==MAX)continue;
                if(dist[e]>dist[s]+t){
                    existNegativeCycle = true;
                    break;
                }
            }
//            System.out.println(Arrays.toString(dist));
            if(existNegativeCycle){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}