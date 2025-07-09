import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = nextPermutation(nums);
        StringBuilder sb = new StringBuilder();
        if(result == null) sb.append(-1);
        else{
            for (int i = 0; i < n; i++) {
                sb.append(result[i]).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static int[] nextPermutation(int[] arr){
        int i = arr.length - 2;
        while( i >= 0 && arr[i] >= arr[i+1]){
            i -=1;
        }
        int pivot = i;

        if (pivot < 0){
            return null;
        }

        int j = arr.length -1;
        while (j > pivot && arr[j] <= arr[pivot]) {
            j-=1;
        }

        int temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;

        int k = arr.length -1;
        pivot +=1;
        while(pivot < k){
            temp = arr[pivot];
            arr[pivot++] = arr[k];
            arr[k--] = temp;
        }
        return arr;
    }
}