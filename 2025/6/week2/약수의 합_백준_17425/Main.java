import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int MAX_NUMBER = 1_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        long[] memory = new long[MAX_NUMBER+1];
        for (int i = 1; i <= MAX_NUMBER; i++) {
            for (int j = i; j <= MAX_NUMBER; j+=i) {
                memory[j]+=i;
            }
            memory[i] += memory[i - 1];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(memory[N])
                    .append('\n');
        }
        System.out.println(sb);
    }
}