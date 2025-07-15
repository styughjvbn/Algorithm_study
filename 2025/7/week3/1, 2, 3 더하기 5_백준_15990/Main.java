import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static long DIVIDE_NUM = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[100_001][4];
        long[] cases = new long[100_001];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = dp[3][2] = dp[3][3] = 1;
        cases[1] = 1;
        cases[2] = 1;
        cases[3] = 3;
        for (int i = 4; i < 100_001; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = (cases[i-j] - dp[i-j][j])%DIVIDE_NUM;
            }
            cases[i] = dp[i][1] + dp[i][2] + dp[i][3];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(cases[n]%DIVIDE_NUM).append('\n');
        }
        System.out.println(sb);
    }
}