import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        char[] string = br.readLine().toCharArray();
        int[][] prefixes = new int[26][string.length+1];
        for (int i = 1; i <= string.length; i++) {
            int asciiCode = string[i - 1] - 'a';
            prefixes[asciiCode][i]++;
            for (int j = 0; j < 26; j++) {
                prefixes[j][i] += prefixes[j][i-1];
            }
        }

        st = new  StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int asciiCode = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken()) + 1;
            int r = Integer.parseInt(st.nextToken()) + 1;

            sb.append(prefixes[asciiCode][r] - prefixes[asciiCode][l-1]).append('\n');
        }
        System.out.println(sb);
    }
}
