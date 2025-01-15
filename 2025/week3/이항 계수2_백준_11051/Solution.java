import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] union;
    static int[] numSeq;
    static List<Integer> resList = new ArrayList();
    static int[] res;
    static boolean can = false;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        union = new int[n];
        numSeq = new int[n*2];
        res = new int[n * 2];
        Arrays.fill(res, 17);
        Arrays.fill(numSeq, -1);
        for(int i = 0; i < n; i++){
            union[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(union);
        solve(0);

        if (can){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n * 2; i++) {
                sb.append(res[i]).append(" ");
            }
            System.out.println(sb);
        }else {
            System.out.println(-1);
        }

    }

    static void solve(int depth){
        if (depth >= n){
            for (int i = 0; i < n*2; i++) {
                if (res[i] > numSeq[i]) break;
                else if (res[i] < numSeq[i]) return;
            }
            res = Arrays.copyOf(numSeq, n*2);
            can = true;
            return;
        }
        int curNum = union[depth];
        for(int i = 0; i < 2*n-curNum-1; i++){
            if(numSeq[i] == -1 && numSeq[i+curNum+1] == -1){
                numSeq[i+curNum+1] = curNum;
                numSeq[i] = curNum;
                solve(depth+1);
                numSeq[i+curNum+1] = -1;
                numSeq[i] = -1;
            }
        }
    }
}