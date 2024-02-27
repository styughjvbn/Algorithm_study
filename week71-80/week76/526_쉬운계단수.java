import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        long[][] count=new long[n][10];
        Arrays.fill(count[0],1);
        count[0][0]=0;
        for (int i = 1; i < n; i++) {
            if(count[i-1][0]>0){
                count[i][1]+=count[i-1][0];
            }
            for (int j = 1; j <= 8; j++) {
                count[i][j-1]+=count[i-1][j];
                count[i][j+1]+=count[i-1][j];
            }
            if(count[i-1][9]>0){
                count[i][8]+=count[i-1][9];
            }
            for (int k = 0; k < 10; k++) {
                count[i][k]%=1_000_000_000;
            }
//            System.out.println(Arrays.toString(count[i]));
        }
        long ans=0;
        for (long j : count[n-1]) {
            ans+=j;
            ans%=1_000_000_000;
        }

        System.out.println(ans);
    }
}