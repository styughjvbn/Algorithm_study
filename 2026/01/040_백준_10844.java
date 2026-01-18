import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n][10];
        Arrays.fill(dp[0], 1);
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
            }
            dp[i][9] = dp[i - 1][8];
        }

        long res = 0;
        for (int i = 0; i < 10; i++) {
            res += dp[n - 1][i];
            res %= 1_000_000_000;
        }
        System.out.println(res);
    }
}