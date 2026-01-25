import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        String line = br.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());

        int[] numbers = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < n; i++) {
            if (numbers[i] == numbers[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                if (numbers[start] == numbers[end] && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (dp[s][e]) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}