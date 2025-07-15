import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] cardPackPrices = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cardPackPrices[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ( j > i ){
                    dp[i][j] = dp[i][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - j][j] + cardPackPrices[j]);
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}