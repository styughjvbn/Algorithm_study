import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] signMatrix;
    static int[][] sum;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        char[] signMatrixString = br.readLine().toCharArray();
        signMatrix = new int[n][n];
        sum = new int[n][n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                signMatrix[i][j] = signCharToInt(signMatrixString[idx++]);
            }
        }
        dfs(0);
    }

    public static void dfs(int depth){
        if(depth >= n){
            for (int i = 0; i < n; i++) {
                sb.append(sum[i][i]).append(" ");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (signMatrix[depth][depth] == 0){
            sum[depth][depth] = 0;
            if (isPossible(depth)) dfs(depth + 1);
        }else{
            for (int i = 1; i <= 10; i++) {
                sum[depth][depth] = i * signMatrix[depth][depth];
                if( isPossible(depth))
                    dfs(depth + 1);
            }
        }
    }
    public static boolean isPossible(int idx){
        for (int i = idx - 1; i >= 0; i--) {
            int temp = sum[i][idx - 1] + sum[idx][idx];
            if ((signMatrix[i][idx] == 0 && temp != 0) ||
                    (signMatrix[i][idx] == 1 && temp <= 0) ||
                    (signMatrix[i][idx] == -1 && temp >= 0))
                return false;
            sum[i][idx] = temp;
        }
        return true;
    }

    public static int signCharToInt(char signChar){
        if(signChar == '-'){
            return -1;
        }else if(signChar == '+'){
            return 1;
        }
        return 0;
    }
}