import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n;
        long b;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        long[][] matrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken())%1_000;
            }
        }
        if (b == 1) {
            printMatrix(matrix);
            return;
        }

        long[][] resMatrix = new long[n][n];
        long[][] tempMatrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, n);
            resMatrix[i][i] = 1;
        }
//        b >>= 1;
//        System.out.println(b);
        while (b > 0) {
            if ((b & 1) == 1) {
                resMatrix = multiply(resMatrix, tempMatrix);
            }
            tempMatrix = multiply(tempMatrix, tempMatrix);
            b >>= 1;
        }

        printMatrix(resMatrix);
    }

    public static void printMatrix(long[][] matrix) {
        int n = matrix.length;
        for (long[] longs : matrix) {
            for (int j = 0; j < n; j++) {
                sb.append(longs[j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static long[][] multiply(long[][] matrix1, long[][] matrix2) {
        int l = matrix1.length;
        long[][] newMatrix = new long[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                for (int p = 0; p < l; p++) {
                    newMatrix[i][j] += matrix1[i][p] * matrix2[p][j];
                    newMatrix[i][j] %= 1_000;
                }
            }
        }

        return newMatrix;
    }
}