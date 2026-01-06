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
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            char[] str = br.readLine().toCharArray();
            Deque<Character> stack = new ArrayDeque<>();

            boolean isValid = true;
            for (char c : str) {
                if(c == '(') {
                    stack.push(c);
                }else{
                    if(stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;
                        break;
                    }else  {
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty() && isValid){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }
}
