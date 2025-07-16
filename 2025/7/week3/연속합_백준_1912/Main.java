import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        long[] nums = new long[n];
        long[] prevMinPrefixSum = new long[n];
        nums[0] = Integer.parseInt(st.nextToken());
        prevMinPrefixSum[0] = nums[0];
        long result = Math.max(-1_000_000_001, nums[0]);
        for (int i = 1; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken()) + nums[i - 1];
            prevMinPrefixSum[i] = Math.min(nums[i], prevMinPrefixSum[i - 1]);
            result = Math.max(result, nums[i] - prevMinPrefixSum[i - 1]);
            result = Math.max(result, nums[i]);
        }
        System.out.println(result);
    }
}