import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] += dp[j - 1];
                dp[j] %=1_000_000_000;
            }
        }
        System.out.println(dp[n]);
    }
}