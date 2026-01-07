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
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty()){
                int[] topValue = stack.peek();
                if(topValue[1] < nums[i]){
                    res[topValue[0]] = nums[i];
                    stack.pop();
                }else{
                    break;
                }
            }
            stack.push(new int[]{i, nums[i]});
        }
        while(!stack.isEmpty()){
            int[] topValue = stack.pop();
            res[topValue[0]] = -1;
        }

        for (int i = 0; i < n; i++) {
            sb.append(res[i] + " ");
        }
        System.out.println(sb);
    }
}
