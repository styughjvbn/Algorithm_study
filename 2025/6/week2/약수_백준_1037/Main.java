import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int realMeasureCount = Integer.parseInt(br.readLine());
        int[] realMeasures = new int[realMeasureCount];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < realMeasureCount; i++) {
            realMeasures[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(realMeasures);
        int halfOfRealMeasureCount = realMeasureCount / 2;
        int result = realMeasures[halfOfRealMeasureCount];
        result *= realMeasureCount % 2 == 1 ? realMeasures[halfOfRealMeasureCount] : realMeasures[halfOfRealMeasureCount - 1];

        System.out.println(result);
    }
}
