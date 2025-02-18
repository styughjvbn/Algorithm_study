import java.io.*;
import java.util.*;

public class SolutionPrev {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(countZeroSums(A, B, C, D, n));
    }

    public static long countZeroSums(int[] A, int[] B, int[] C, int[] D, int n) {
        Map<Integer, Integer> ABMap = new HashMap<>();
        long zeroCount = 0;

        // Step 1: (A+B) 값들을 해시맵에 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = A[i] + B[j];
                ABMap.put(sum, ABMap.getOrDefault(sum, 0) + 1);
            }
        }

        // Step 2: (C+D) 값들을 계산하면서 -sum이 ABMap에 있는지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = C[i] + D[j];
                if (ABMap.containsKey(-sum)) {
                    zeroCount += ABMap.get(-sum);
                }
            }
        }

        return zeroCount;
    }
}
