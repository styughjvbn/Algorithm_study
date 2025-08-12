import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int[][] arr=new int[n+1][n+1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i==j)continue;
                arr[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            arr[a][b]=Math.min(arr[a][b],c);
        }
        for (int i = 1; i < n+1; i++) {
            for (int i1 = 1; i1 < n+1; i1++) {
                for (int i2 = 1; i2 < n+1; i2++) {
                    if(arr[i1][i]==Integer.MAX_VALUE||arr[i][i2]==Integer.MAX_VALUE)continue;
                    if(arr[i1][i2]>arr[i1][i]+arr[i][i2]){
                        arr[i1][i2]=arr[i1][i]+arr[i][i2];
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            for (int i1 = 1; i1 < n+1; i1++) {
                if(arr[i][i1]==Integer.MAX_VALUE){
                    sb.append(0);
                }else{
                    sb.append(arr[i][i1]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}