import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] weights;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        weights = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[n + 1][15001];

        solve(0, 0);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int marble = Integer.parseInt(st.nextToken());
            if (marble > 15000) {
                sb.append("N ");
            } else {
                if (dp[n][marble]) sb.append("Y ");
                else sb.append("N ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    static void solve(int idx, int w) {
        if (dp[idx][w]) return;
        dp[idx][w] = true;

        if (idx == n) return;

        solve(idx + 1, w + weights[idx]);
        solve(idx + 1, Math.abs(w - weights[idx]));
        solve(idx + 1, w);
    }
}