import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        while(true){
            for (int num : nums) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
            nums = nextPermutation(nums);
            if( nums == null) break;
        }
        System.out.println(sb);
    }

    public static int[] nextPermutation(int[] arr) {
        int p = arr.length - 2;
        while (p >= 0 && arr[p] >= arr[p + 1])
            p--;

        if (p < 0) return null;

        int i = arr.length - 1;
        while (i > p && arr[i] <= arr[p])
            i--;

        swap(arr, i, p);

        int j = arr.length - 1;
        p++;
        while (p < j)
            swap(arr, p++, j--);

        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}