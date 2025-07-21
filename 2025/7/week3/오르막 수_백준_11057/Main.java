import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[10];
        dp[0] = 1;
        for (int i = 0; i <= N; i++) {
            for (int j = 1; j < 10; j++) {
                dp[j] = (dp[j-1] + dp[j])%10_007;
            }
        }
        System.out.println(dp[9]);
    }
}