import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = st.nextToken().charAt(0) - '0';
            }
        }

        int[] res = dfs(paper, n, 0, 0);
        System.out.println(res[0] + "\n" + res[1]);
    }

    public static int[] dfs(int[][] paper, int size, int i, int j) {
        if(size <= 1){
            if(paper[i][j] == 0)
                return new int[]{1, 0};
            else
                return new int[]{0, 1};
        }

        int[] localPaperCount = new int[2];
        int nextSize = size / 2;
        arrPlus(localPaperCount, dfs(paper, nextSize, i, j));
        arrPlus(localPaperCount, dfs(paper, nextSize, i + nextSize, j));
        arrPlus(localPaperCount, dfs(paper, nextSize, i, j + nextSize));
        arrPlus(localPaperCount, dfs(paper, nextSize, i + nextSize, j + nextSize));

        if (localPaperCount[0] == 4 && localPaperCount[1] == 0) {
            localPaperCount[0] = 1;
        }
        if (localPaperCount[1] == 4 && localPaperCount[0] == 0) {
            localPaperCount[1] = 1;
        }

        return localPaperCount;
    }

    public static void arrPlus(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] += arr2[i];
        }
    }
}