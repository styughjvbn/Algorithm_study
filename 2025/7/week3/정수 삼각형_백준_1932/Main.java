import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][n];
        int prevCol = 0;
        int presentCol = 1;
        dp[0][0] = Integer.parseInt(br.readLine());
        result = dp[0][0];
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                dp[presentCol][j] = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    dp[presentCol][j] += dp[prevCol][j];
                } else if (j == i) {
                    dp[presentCol][j] += dp[prevCol][j - 1];
                } else {
                    dp[presentCol][j] += Math.max(dp[prevCol][j], dp[prevCol][j - 1]);
                }
                result = Math.max(result, dp[presentCol][j]);
            }
            prevCol = (prevCol + 1) % 2;
            presentCol = (presentCol + 1) % 2;
        }
        System.out.println(result);
    }
}