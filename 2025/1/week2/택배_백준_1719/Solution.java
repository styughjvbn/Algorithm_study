import java.util.*;
import java.io.*;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dis = new int[n][n];
        int[][] startPoint = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], 300_000);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            dis[a][b] = dis[b][a] = c;
            startPoint[a][b] = b;
            startPoint[b][a] = a;
        }
        for (int i = 0; i < n; i++) {
            dis[i][i] = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int newDis = dis[j][i] + dis[i][k];
                    if (newDis < dis[j][k]) {
                        dis[j][k] = newDis;
                        startPoint[j][k] = startPoint[j][i];
                    }

                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j) sb.append('-');
                else{
                    sb.append(startPoint[i][j]+1);
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}