import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static char[][] frame;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        frame = new char[n][n];
        for (int i = 0; i < n; i++) {
            frame[i] = br.readLine().toCharArray();
        }
        System.out.println(dfs(0, 0, n));
    }

    public static String dfs(int ii, int jj, int size) {
        if (size <= 1) {
            return String.valueOf(frame[ii][jj]);
        }

        boolean canCompress = true;
        char basePoint = frame[ii][jj];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (frame[ii + i][jj + j] != basePoint) {
                    canCompress = false;
                    break;
                }
            }
            if (!canCompress) break;
        }

        if (canCompress) {
            return String.valueOf(basePoint);
        } else {
            StringBuilder innerData = new StringBuilder();
            int nextSize = size / 2;
            innerData.append("(");
            innerData.append(dfs(ii, jj, nextSize));
            innerData.append(dfs(ii , jj+ nextSize, nextSize));
            innerData.append(dfs(ii+ nextSize, jj , nextSize));
            innerData.append(dfs(ii + nextSize, jj + nextSize, nextSize));
            innerData.append(")");

            return innerData.toString();
        }
    }
}