import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(br.readLine());
        int bit = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            int operand;
            switch (operator) {
                case "add":
                    operand = Integer.parseInt(st.nextToken()) - 1;
                    bit = bit | (1 << operand);
                    break;
                case "remove":
                    operand = Integer.parseInt(st.nextToken()) - 1;
                    bit = bit & ~(1 << operand);
                    break;
                case "check":
                    operand = Integer.parseInt(st.nextToken()) - 1;
                    if((bit & (1 << operand)) > 0){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                    sb.append('\n');
                    break;
                case "toggle":
                    operand = Integer.parseInt(st.nextToken()) - 1;
                    bit = bit ^ (1 << operand);
                    break;
                case "all":
                    bit = (1 << 20) - 1;
                    break;
                case "empty":
                    bit = 0;
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}