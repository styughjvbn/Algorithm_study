import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] nums=new int[M];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i]=Integer.parseInt(st.nextToken());
        }
        int[][] values=new int[N-1][3];
        for (int i = 0; i < N-1; i++) {
            st=new StringTokenizer(br.readLine());
            values[i][0]=Integer.parseInt(st.nextToken());
            values[i][1]=Integer.parseInt(st.nextToken());
            values[i][2]=Integer.parseInt(st.nextToken());
        }
        long[] start=new long[N];
        long[] end=new long[N];
        for (int i = 0; i < M-1; i++) {
            if(nums[i]>nums[i+1]){
                start[nums[i+1]]++;
                end[nums[i]-1]++;
            }else{
                start[nums[i]]++;
                end[nums[i+1]-1]++;
            }
        }
        for (int i = 1; i < N; i++) {
            start[i]+=start[i-1];
            end[i]+=end[i-1];
        }
        long ans=0;
        for (int i = 1; i < N; i++) {
            long count=start[i]-end[i-1];
            ans+=Math.min(count*values[i-1][1]+values[i-1][2],count*values[i-1][0]);

        }
        System.out.println(ans);
//        System.out.println(N+" "+M);
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(start));
//        System.out.println(Arrays.toString(end));
    }
}