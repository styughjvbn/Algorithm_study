import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] budgetReqs = new int[n];

        int lowBound = 1;
        int highBound = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            budgetReqs[i] = Integer.parseInt(st.nextToken());
            highBound = Math.max(highBound, budgetReqs[i]);
        }
        int totalBudget = Integer.parseInt(br.readLine());

        int result = lowBound;
        int midBound ;
        while(lowBound <= highBound){
            midBound = (lowBound + highBound)/2;
            int sumBudgetReq = 0;
            for (int budgetReq : budgetReqs) {
                sumBudgetReq += Math.min(budgetReq, midBound);
            }
            if (sumBudgetReq <= totalBudget){
                result = midBound;
                lowBound = midBound + 1;
            }else{
                highBound = midBound -1;
            }
        }
        System.out.println(result);
    }
}