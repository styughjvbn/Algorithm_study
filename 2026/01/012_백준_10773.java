import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        long res = 0;
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                res -= stack.poll();
            } else {
                res += num;
                stack.push(num);
            }
        }

        System.out.println(res);
    }
}
