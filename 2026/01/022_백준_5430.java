import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {
            char[] oper = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String strNums = br.readLine();
            boolean error = false;
            st = new StringTokenizer(strNums, "[,]");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            boolean reversed = false;
            int front = 0;
            int rear = n - 1;

            for (char c : oper) {
                if (c == 'R') {
                    reversed = !reversed;
                }else{
                    if (front > rear) {
                        error = true;
                        break;
                    }
                    if(!reversed){
                        front++;
                    }else{
                        rear--;
                    }
                }
            }

            if (error) {
                sb.append("error");
            }else{
                printArr(front, rear, reversed, nums);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void printArr(int front, int rear, boolean reversed, int[] nums){
        sb.append('[');
        if(!reversed){
            for (int i = front; i <= rear; i++) {
                sb.append(nums[i]);
                if (i != rear) {
                    sb.append(",");
                }
            }
        }else{
            for (int i = rear; i >= front; i--) {
                sb.append(nums[i]);
                if (i != front) {
                    sb.append(",");
                }
            }
        }
        sb.append(']');
    }
}