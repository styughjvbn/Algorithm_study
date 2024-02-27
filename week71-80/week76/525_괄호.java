import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            sb.append(check(br.readLine())?"YES":"NO").append('\n');
        }
        System.out.println(sb);
    }

    public static boolean check(String str){
        Deque<Character> stack=new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if(c=='('){
                stack.add('(');
            }else {
                if(stack.isEmpty())return false;
                if(stack.pollLast()!='(')return false;
            }
        }
        return stack.isEmpty();
    }
}