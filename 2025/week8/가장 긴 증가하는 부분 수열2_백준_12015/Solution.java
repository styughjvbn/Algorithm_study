import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] numSeq = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numSeq[i] = Integer.parseInt(st.nextToken());
        }

        int[] LIS = new int[n];
        LIS[0] = numSeq[0];
        int tailIndex = 0;
        for (int i = 1; i < n; i++) {
            if(numSeq[i] > LIS[tailIndex]){
                LIS[++tailIndex] = numSeq[i];
            }else{
                int targetIndex = Arrays.binarySearch(LIS, 0, tailIndex, numSeq[i]);
                if(targetIndex < 0 ){
                    LIS[-targetIndex-1] = numSeq[i];
                }
            }

        }
        System.out.println(tailIndex+1);
    }
}
