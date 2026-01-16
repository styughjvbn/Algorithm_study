import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[][][] dp = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        while (true) {
            int a, b, c;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) + 50;
            b = Integer.parseInt(st.nextToken()) + 50;
            c = Integer.parseInt(st.nextToken()) + 50;
            if (a == 49 && b == 49 && c == 49) {
                break;
            }
            sb.append("w(").append(a-50).append(", ").append(b-50).append(", ").append(c-50).append(") = ").append(dfs(a,b,c)).append('\n');
        }
        System.out.println(sb);
    }

    public static int dfs(int a, int b, int c) {
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 50 || b <= 50 || c <= 50) {
            dp[a][b][c] = 1;
            return 1;
        }

        if (a > 70 || b > 70 || c > 70) {
            dp[a][b][c] = dfs(70, 70, 70);
            return dp[a][b][c];
        }

        if (a < b && b < c) {
            dp[a][b][c] = dfs(a, b, c - 1) + dfs(a, b - 1, c - 1) - dfs(a, b - 1, c);
        }else{
            dp[a][b][c] = dfs(a - 1, b, c) + dfs(a - 1, b - 1, c) + dfs(a - 1, b, c - 1) - dfs(a - 1, b - 1, c - 1);
        }
        return dp[a][b][c];
    }
}