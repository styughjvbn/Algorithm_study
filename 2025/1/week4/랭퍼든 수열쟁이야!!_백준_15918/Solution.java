import java.util.*;
import java.io.*;

class Solution{
    static int[] numSeq;
    static int count = 0;
    static int n;
    static int fixedNum;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        numSeq = new int[n * 2 + 1];
        fixedNum = y - x - 1;
        numSeq[x] = numSeq[y] = fixedNum;

        solve(1 == fixedNum ? 2 : 1);
        System.out.println(count);
    }

    static void solve(int num) {
        if ( num > n){
            count++;
            return;
        }
        for (int i = 1; i <= n * 2 - num - 1; i++) {
            if (numSeq[i] == 0 && numSeq[i + num + 1] == 0) {
                numSeq[i] = numSeq[i + num + 1] = num;
                solve(num + 1 == fixedNum ? num + 2 : num + 1);
                numSeq[i] = numSeq[i + num + 1] = 0;
            }
        }
    }
}