import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] nums;
    static int[] permutation;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        permutation = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int depth, int k) {
        if (depth >= M) {
            for (int i = 0; i < M; i++) {
                sb.append(permutation[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = k; i < N; i++) {
            permutation[depth] = nums[i];
            dfs(depth + 1, i + 1);
        }
    }
}