import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] treeHeights = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            treeHeights[i] = Integer.parseInt(st.nextToken());
        }

        long high = Integer.MAX_VALUE;
        long low = 0;
        long middle = (high + low) / 2;
        while (low <= high) {
            if (chopTree(treeHeights, middle) >= m) {
                low = middle + 1;
            }else{
                high = middle - 1;
            }
            middle = (high + low) / 2;
        }
        System.out.println(high);
    }

    public static long chopTree(long[] treeHeights, long chopHeight) {
        long totalLog = 0;
        for (long tree : treeHeights) {
            long chopedLog = tree - chopHeight;
            totalLog += Math.max(chopedLog, 0);
        }

        return totalLog;
    }
}