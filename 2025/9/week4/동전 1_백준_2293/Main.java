import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] kind = new int[k+1];
        kind[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = coin; j <= k; j++) {
                kind[j] += kind[j - coin];
            }
        }

        System.out.println(kind[k]);
    }
}