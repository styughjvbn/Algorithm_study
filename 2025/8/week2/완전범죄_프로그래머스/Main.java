import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1000000;
        int[][] dp = new int[info.length + 1][m]; // dp[i][bTrace] = A 누적 최소 흔적
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int i = 0; i < info.length; i++) {
            int aCost = info[i][0];
            int bCost = info[i][1];

            for (int b = 0; b < m; b++) {
                if (dp[i][b] == INF) continue;

                // A 도둑이 현재 물건(aCost)을 가져갈 수 있음
                if (dp[i][b] + aCost < n)
                    dp[i + 1][b] = Math.min(dp[i + 1][b], dp[i][b] + aCost);

                // B 도둑이 가져갈 수 있음
                if (b + bCost < m)
                    dp[i + 1][b + bCost] = Math.min(dp[i + 1][b + bCost], dp[i][b]);
            }
        }

        int min = INF;
        for (int b = 0; b < m; b++)
            min = Math.min(min, dp[info.length][b]);

        return min == INF ? -1 : min;
    }
}