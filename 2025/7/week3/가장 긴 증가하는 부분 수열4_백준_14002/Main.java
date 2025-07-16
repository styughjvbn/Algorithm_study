import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        int[] prevLIS = new int[n];
        dp[0] = 1;
        prevLIS[0] = -1;
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            prevLIS[i] = -1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prevLIS[i] = j;
                }
            }
            if(dp[maxIdx] < dp[i]){
                maxIdx = i;
            }
        }
        System.out.println(dp[maxIdx]);
        while(true){
            sb.insert(0,nums[maxIdx]);
            maxIdx = prevLIS[maxIdx];
            if(maxIdx == -1) break;
            sb.insert(0," ");
        }
        System.out.println(sb);
    }
}