import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int MAX_NUM = 1_000_000;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[MAX_NUM + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= MAX_NUM; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3])%1_000_000_009;
        }
        for (int i = 0; i < T; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(sb);
    }
}