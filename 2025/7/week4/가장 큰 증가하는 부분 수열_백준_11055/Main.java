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
        int[] dp = new int[n];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < n; i++) {
            int tempMax = nums[i];
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) tempMax = Math.max(tempMax, dp[j] + nums[i]);
            }
            dp[i] = tempMax ;
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}