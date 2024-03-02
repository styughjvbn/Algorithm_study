import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine()," ");
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine()," ");
        int b=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());

        long ans=n;
        for (int i = 0; i < n; i++) {
            int remain=nums[i]-b;
            if(remain<0)continue;
            if(remain%c>0){
                ans++;
            }
            ans+=remain/c;
        }
        System.out.println(ans);
    }
}