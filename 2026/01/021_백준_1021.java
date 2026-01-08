import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.addLast(i + 1);
        }
        int[] nums = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        int res = 0;
        for (int num : nums) {
            int iterCount = 0;
            while (!deque.isEmpty()) {
                int extNum = deque.pollFirst();
                if (num == extNum) {
                    res += Math.min(deque.size()+1 - iterCount, iterCount);
                    break;
                }
                deque.addLast(extNum);
                iterCount++;
            }
        }
        System.out.println(res);
    }
}