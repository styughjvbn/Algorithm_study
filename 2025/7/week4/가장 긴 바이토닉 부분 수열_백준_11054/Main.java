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
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        dp[n-1][0] = dp[n-1][1] = 1;
        int result = 1;
        for (int i = 0; i < n; i++) {
            int tempPrevMax = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) tempPrevMax = Math.max(tempPrevMax, dp[j][0] + 1);
            }
            dp[i][0] = tempPrevMax ;
        }
        for (int i = n - 1; i >= 0; i--) {
            int tempNextMax = 1;
            for (int j = i + 1; j < n; j++) {
                if(nums[i] > nums[j]) tempNextMax = Math.max(tempNextMax, dp[j][1] + 1);
            }
            dp[i][1] = tempNextMax ;
            result = Math.max(result, dp[i][1] + dp[i][0] - 1);
        }

        System.out.println(result);
    }
}