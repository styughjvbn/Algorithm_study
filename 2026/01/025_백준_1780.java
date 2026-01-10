import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[][] paper;
    static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, n);
        for (int i : count) {
            System.out.println(i);
        }
    }

    public static void dfs(int si, int sj, int size) {
        if (size <= 1) {
            count[paper[si][sj] + 1]++;
            return;
        }

        boolean isOneKind = true;
        int kind = paper[si][sj];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (kind != paper[i + si][j + sj]) {
                    isOneKind = false;
                    break;
                }
            }
            if (!isOneKind) break;
        }

        if (isOneKind) {
            count[kind + 1]++;
        } else {
            int nextSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    dfs(si + nextSize * i, sj + nextSize * j, nextSize);
                }
            }
        }
    }
}