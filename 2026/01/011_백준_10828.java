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
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            switch(oper) {
                case "push":
                    int a = Integer.parseInt(st.nextToken());
                    stack.push(a);
                    break;
                case "pop":
                    if(!stack.isEmpty()) sb.append(stack.pop());
                    else sb.append("-1");
                    sb.append('\n');
                    break;
                case "size":
                    sb.append(stack.size());
                    sb.append('\n');
                    break;
                case "empty":
                    if(!stack.isEmpty()) sb.append(0);
                    else sb.append(1);
                    sb.append('\n');
                    break;
                case "top":
                    if(!stack.isEmpty()) sb.append(stack.peek());
                    else sb.append("-1");
                    sb.append('\n');
                    break;
                default:
                    break;
            }

        }

        System.out.println(sb);
    }
}
