import java.io.*;
import java.util.*;

public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][m+1];
        int res = 0;
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m+1; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num != 0){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        System.out.println(res);
    }
}