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
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n + 1];
        st = new  StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = nums[i - 1] + num;
        }

        for (int i = 0; i < m; i++) {
            st =  new  StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(nums[end] - nums[start-1]).append('\n');
        }

        System.out.println(sb);
    }
}
