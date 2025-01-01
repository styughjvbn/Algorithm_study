import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] nums=new int[n];
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(br.readLine());
            set.add(nums[i]);
        }
        int ans=1;
        for (Integer i : set) {
            int prevNum=-1;
            int count=0;
            for (int j = 0; j < n; j++) {
                if(nums[j]==i)continue;
                if(nums[j]==prevNum){
                    count++;
                }else{
                    ans=Math.max(ans,count);
                    prevNum=nums[j];
                    count=1;
                }
            }
            ans=Math.max(ans,count);
        }
        System.out.println(ans);
    }
}