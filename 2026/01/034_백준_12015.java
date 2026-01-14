import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] temp = new int[n];
        temp[0] = nums[0];
        int lastIdx = 0;
        for (int i = 1; i < n; i++) {
            if(temp[lastIdx] < nums[i]){
                temp[++lastIdx] = nums[i];
            }else{
                int targetIdx = Arrays.binarySearch(temp, 0, lastIdx + 1, nums[i]);
                if (targetIdx < 0) {
                    targetIdx = -(targetIdx + 1);
                    temp[targetIdx] = nums[i];
                }
            }
        }
        System.out.println(lastIdx+1);

    }
}