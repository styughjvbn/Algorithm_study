import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        long result = 0;
        int digit = 1;
        long minBoundary = 0;
        long maxBoundary = 9;

        while (maxBoundary < N) {
            result += (maxBoundary - minBoundary) * digit;
            minBoundary = maxBoundary;
            maxBoundary = (minBoundary + 1) * 10 - 1;
            digit++;
        }
        result += (N - minBoundary) * digit;
        System.out.println(result);
    }
}