import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean[] nums = new boolean[10];
    static char[] inequalitySigns;
    static int k;
    static long maxNum = 0;
    static long minNum = 10_000_000_000L;

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());
        inequalitySigns = new char[k];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            inequalitySigns[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            nums[i] = true;
            dfs(0, (long) (Math.pow(10, k)*i), i);
            nums[i] = false;
        }
        System.out.printf("%0"+(k+1)+"d\n", maxNum);
        System.out.printf("%0"+(k+1)+"d\n", minNum);
    }

    static void dfs(int depth, long acc, int prevNum){
        if (depth >= k) {
//            System.out.println(acc);
            minNum = Math.min(minNum, acc);
            maxNum = Math.max(maxNum, acc);
            return;
        }

        if ( inequalitySigns[depth] == '>'){
            for (int i = prevNum - 1; i >= 0; i--) {
                if(nums[i]) continue;
                nums[i] = true;
                dfs(depth +1, (long) (acc+Math.pow(10,(k-depth-1))*i), i);
                nums[i] = false;
            }
        }else{
            for (int i = prevNum + 1; i < 10; i++) {
                if(nums[i]) continue;
                nums[i] = true;
                dfs(depth +1, (long) (acc+Math.pow(10,(k-depth-1))*i), i);
                nums[i] = false;
            }
        }
    }
}