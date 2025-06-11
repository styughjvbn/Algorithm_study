import java.util.*;
import java.io.*;

class Solution{
    static int n;
    static HashMap<Integer, int[]> dp = new HashMap<>();

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int[] result = solve(n);
        System.out.printf("%d %d", result[0], result[1]);
    }

    static int[] solve(int num) {
        if (dp.containsKey(num)) return dp.get(num);
        if (num<10){
            return new int[]{num%2,num%2};
        }
        else if (num < 100) {
            int acc = 0;
            int newNum = num/10 + num%10;
            acc += countOdd(num);
            acc += solve(newNum)[1];
            int[] values = new int[]{acc, acc};
            dp.put(num, values);
            return values;
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append(num);
            int iterNum = sb.length();
            int maxAcc = 0;
            int minAcc = 100;
            for (int i = 1; i < iterNum - 1; i++) {
                for (int j = i+1; j < iterNum; j++) {
                    int firstNum = Integer.parseInt(sb.substring(0, i));
                    int secondNum = Integer.parseInt(sb.substring(i, j));
                    int thirdNum = Integer.parseInt(sb.substring(j));
                    int newNum = firstNum + secondNum + thirdNum;
                    int oddNum = countOdd(num);
                    int[] accs = new int[]{oddNum,oddNum};
                    int[] dpAcc = solve(newNum);
                    accs[0] += dpAcc[0];
                    accs[1] += dpAcc[1];
                    maxAcc = Math.max(maxAcc, accs[1]);
                    minAcc = Math.min(minAcc, accs[0]);
                }
            }
            dp.put(num, new int[]{minAcc, maxAcc});
            return dp.get(num);
        }
    }

    static int countOdd(int num){
        int oddNum = 0;
        while(num>0){
            if ((num % 10)%2==1)oddNum++;
            num /=10;
        }
        return oddNum;
    }
}