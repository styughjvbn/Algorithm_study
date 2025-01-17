import java.util.*;
import java.io.*;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        HashSet<Integer> valueHash = new HashSet<>();
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            valueHash.add(nums[i]);
        }
        if(valueHash.contains(c)){ // 물건 1개만 골랐을 때
            System.out.println(1);
        }else{
            Arrays.sort(nums);
            for (int i = 0; i < n; i++) { // 물건 2개만 골랐을 때
                if(nums[i]*2 >= c)break;
                if(valueHash.contains(c - nums[i])){
                    System.out.println(1);
                    return;
                }else{
                    for (int j = i+1; j < n; j++) {//물건 3개를 골랐을 때
                        if(nums[j]*2 >= c - nums[i])break;
                        if(valueHash.contains(c - nums[i] - nums[j])){
                            System.out.println(1);
                            return;
                        }
                    }
                }
            }
            System.out.println(0);
        }

    }
}