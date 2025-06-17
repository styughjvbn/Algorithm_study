import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_NUM = 1_000_001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        boolean[] sieve = new boolean[MAX_NUM];
        sieve[1] = true;
        int count = 1_000_001 - 2;
        int[] primeNumbers = new int[count];
        int idx = 0;
        for (int i = 2; i < MAX_NUM; i++) {
            for (int j = i * 2; j < MAX_NUM; j += i) {
                if (!sieve[j]) {
                    sieve[j] = true;
                    count--;
                }
            }
            if (!sieve[i])
                primeNumbers[idx++] = i;
        }

        int[] number = new int[MAX_NUM];
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            if(number[n] == 0) {
                for (int primeNumber : primeNumbers) {
                    if (!sieve[n - primeNumber]) {
                        number[n] = primeNumber;
                        break;
                    }
                }
                if (number[n] == 0 ) number[n] = -1;
            }

            int a = number[n];
            if (a == -1) {
                sb.append("Goldbach's conjecture is wrong.");

            } else {
                sb.append(n).append(" = ").append(a).append(" + ").append(n - a);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}