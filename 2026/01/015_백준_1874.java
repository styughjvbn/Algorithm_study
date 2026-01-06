import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

//스택에 push하는 순서는 반드시 오름차순을 지키도록 한다.
//즉, 숫자 n을 뽑을 때는 스택에 n이하의 숫자가 존재한다.
public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        int baseNum = 0;
        boolean res = true;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > baseNum){
                for (int j = baseNum + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+").append('\n');
                }
                baseNum = num;
            }
            int popNum = stack.pop();
            if(popNum != num){
                res = false;
                break;
            }
            sb.append("-").append('\n');
        }

        if (res) {
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }

    }
}
