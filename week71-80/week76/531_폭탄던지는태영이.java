import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int reverseM = n - m + 1;
        int iter = (n - reverseM) / 2;
        long[][] dp = new long[reverseM + 1][reverseM + 1];
        for (int i = 0; i < iter; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(0).append(" ");
            }
            sb.append('\n');
        }

        for (int i = 1; i <= reverseM; i++) {
            for (int j = 0; j < iter; j++) {
                sb.append(0).append(" ");
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= reverseM; j++) {
                long input = -Long.parseLong(st.nextToken());
                long a = 0;
                long b = 0;
                long c = 0;
                if (i > m) {
                    a = dp[i - m][j];
                }
                if (j > m) {
                    b = dp[i][j - m];
                }
                if (i > m && j > m) {
                    c = dp[i - m][j - m];
                }
                dp[i][j] = input + a + b - c;
                long ans = dp[i][j] - dp[i - 1][j] - dp[i][j - 1] + dp[i - 1][j - 1];
                sb.append(ans).append(" ");
            }
            for (int j = 0; j < iter; j++) {
                sb.append(0).append(" ");
            }
            sb.append("\n");
        }
        for (int i = 0; i < iter; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(0).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}