import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n=Integer.parseInt(br.readLine());
            int[] nums=new int[n];
            st=new StringTokenizer(br.readLine()," ");
            for (int i = 0; i < n; i++) {
                nums[i]=Integer.parseInt(st.nextToken());
            }
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int base=nums[i];
                int tempMax=base;
                for (int j = i+1; j < n; j++) {
                    base+=nums[j];
                    tempMax=Math.max(tempMax,base);
                }
                max=Math.max(max,tempMax);
            }
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }
}