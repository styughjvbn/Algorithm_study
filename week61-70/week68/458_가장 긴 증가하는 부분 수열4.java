import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] nums=new int[n];

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(st.nextToken());
        }
        int[] dp=new int[n];
        List<Integer>[] lists=new ArrayList[n];

        int maxLenIndex=0;
        for (int i = 0; i < n; i++) {

            int maxNumIndex=i;
            for (int i1 = i; i1 >=0; i1--) {
                if(nums[i1]<nums[i] && dp[i1]>dp[maxNumIndex]){
                    maxNumIndex=i1;
                }
            }
            if(maxNumIndex!=i){
                dp[i]=dp[maxNumIndex]+1;
                List<Integer> temp=new ArrayList<>(lists[maxNumIndex]);
                temp.add(nums[i]);
                lists[i]=temp;
            }else{
                dp[i]=1;
                List<Integer> temp=new ArrayList<>();
                temp.add(nums[i]);
                lists[i]=temp;
            }

            if(dp[maxLenIndex]<dp[i])
                maxLenIndex=i;
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[maxLenIndex]);
//        for (List<Integer> list : lists) {
//            for (Integer i : list) {
//                System.out.printf("%d ",i);
//            }
//            System.out.println();
//        }
        for (Integer i : lists[maxLenIndex]) {
            System.out.printf("%d ",i);
        }
    }
}