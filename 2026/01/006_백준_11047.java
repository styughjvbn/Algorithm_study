import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n,k;

        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st .nextToken());
        k = Integer.parseInt(st .nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += k/coins[i];

            k %= coins[i];
        }

        System.out.println(res);
    }
}
