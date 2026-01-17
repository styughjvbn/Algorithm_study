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
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n][2];
        dp[0][0] = scores[0];
        dp[0][1] = scores[0];
        if (n == 1) {
            System.out.println(scores[0]);
            return;
        }
        dp[1][0] = Math.max(scores[0], scores[1]);
        for (int i = 1; i < n; i++) {
            dp[i][1] = dp[i - 1][0] + scores[i];
            if (i > 1) {
                dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + scores[i];
            }
        }

        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
    }
}