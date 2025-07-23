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
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] leftDp = new int[n];
        int[] rightDp = new int[n];
        leftDp[0] = nums[0];
        rightDp[n-1] = nums[n-1];
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            leftDp[i] = Math.max(leftDp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, leftDp[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            rightDp[i] = Math.max(rightDp[i + 1] + nums[i], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, leftDp[i -1]+rightDp[i + 1]);
        }
        System.out.println(ans);
    }
}