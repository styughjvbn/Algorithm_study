import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] s = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i][0] = Integer.parseInt(st.nextToken()); // 행(row)
            s[i][1] = Integer.parseInt(st.nextToken()); // 열(column)
        }

        long[][] dp = new long[n][n];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int x = j + i;
                dp[j][x] = Long.MAX_VALUE;

                for (int k = j; k < x; k++) {
                    long cost = dp[j][k] + dp[k + 1][x] + (long)s[j][0] * s[k][1] * s[x][1];
                    dp[j][x] = Math.min(dp[j][x], cost);
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}