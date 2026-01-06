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
        while(true) {
            char[] str = br.readLine().toCharArray();
            if(str.length == 1 && str[0] == '.') break;

            Deque<Character> stack = new ArrayDeque<>();
            boolean valid = true;
            for (char c : str) {
                if(c == '[' || c == '(') {
                    stack.push(c);
                }else if(c == ']' || c == ')') {
                    if(stack.isEmpty()) {
                        valid = false;
                        break;
                    }
                    char topChar = stack.pop();
                    if(!((c == ']' && topChar =='[') || (c == ')' && topChar =='('))) {
                        valid = false;
                        break;
                    }
                }
            }
            if(stack.isEmpty() && valid) {
                sb.append("yes");
            }else{
                sb.append("no");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
