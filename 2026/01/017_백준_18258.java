import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String oper = st.nextToken();
            switch (oper) {
                case "push":
                    queue.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty()) sb.append(-1);
                    else sb.append(queue.pollFirst());
                    sb.append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    if (queue.isEmpty()) sb.append(-1);
                    else sb.append(queue.peekFirst());
                    sb.append('\n');
                    break;
                case "back":
                    if (queue.isEmpty()) sb.append(-1);
                    else sb.append(queue.peekLast());
                    sb.append('\n');
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}