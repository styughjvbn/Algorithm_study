import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[][] nums;
    static int[][] combinations;
    static int result = -50000;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[N * M][3];
        combinations = new int[K][];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                nums[i * M + j] = new int[]{Integer.parseInt(st.nextToken()), i, j};
            }
        }
        Arrays.sort(nums, (a, b) -> Integer.compare(b[0], a[0])); // a[0] 기준 내림차순
        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int depth, int k) {
        if (depth >= K) {
            int tmpResult = 0;
            for (int i = 0; i < K; i++) {
                tmpResult += combinations[i][0];
            }
            result = Math.max(result, tmpResult);

            return;
        }

        int range = N * M;
        for (int i = k; i < range; i++) {
            boolean existAdjust = false;
            combinations[depth] = nums[i];
            for (int j = depth-1; j >= 0; j--) {
                if(isAdjust(combinations[depth],combinations[j])) {
                    existAdjust = true;
                    break;
                }
            }

            if(existAdjust) continue;
            dfs(depth + 1, i + 1);
        }
    }

    static int[] di = new int[]{0,1, 0 ,-1};
    static int[] dj = new int[]{1, 0 ,-1, 0};

    public static boolean isAdjust(int[] a, int[] b){
        for (int k = 0; k < 4; k++) {
            int ni = a[1] + di[k];
            int nj = a[2] + dj[k];
            if( ni == b[1] && nj == b[2]) return true;
        }
        return false;
    }
}