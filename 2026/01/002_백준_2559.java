import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n + 1];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
        }

        int res = -1_000_000_000;
        for (int i = k; i <= n; i++) {
            res = Math.max(res, nums[i] - nums[i - k]);
        }
        System.out.println(res);
    }
}
