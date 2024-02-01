import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        String[] set=new String[N];
        for (int i = 0; i < N; i++) {
            set[i]= br.readLine().trim();
        }
        int ans=0;
        for (int i = 0; i < M; i++) {
            String input=br.readLine().trim();
            for (int i1 = 0; i1 < N; i1++) {
                if(set[i1].contentEquals(input)){
                    ans++;
                    break;
                }

            }
        }
        System.out.println(ans);
    }
}