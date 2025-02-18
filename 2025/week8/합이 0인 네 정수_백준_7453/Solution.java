import java.io.*;
import java.util.*;

public class Solution {
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
        int[] AB = new int[n * n];
        int[] CD = new int[n * n];
        int index = 0;

        // Step 1: A+B 와 C+D 가능한 모든 합을 배열에 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[index] = A[i] + B[j];
                CD[index] = C[i] + D[j];
                index++;
            }
        }

        // Step 2: 정렬 (투 포인터를 위해 필요)
        Arrays.sort(AB);
        Arrays.sort(CD);

        // Step 3: 투 포인터를 활용한 합이 0이 되는 쌍 찾기
        long zeroCount = 0;
        int p1 = 0;
        int p2 = (n * n) - 1;

        while (p1 < n * n && p2 >= 0) {
            int sum = AB[p1] + CD[p2];

            if (sum == 0) {
                long cnt1 = 1, cnt2 = 1;

                while (p1 < (n * n) - 1 && AB[p1] == AB[p1 + 1]) {
                    cnt1++;
                    p1++;
                }
                while (p2 > 0 && CD[p2] == CD[p2 - 1]) {
                    cnt2++;
                    p2--;
                }

                zeroCount += cnt1 * cnt2;
                p1++;
                p2--;
            } else if (sum < 0) {
                p1++;
            } else {
                p2--;
            }
        }

        return zeroCount;
    }
}