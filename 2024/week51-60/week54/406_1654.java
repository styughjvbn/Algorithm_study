import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 10000 이하의 정수
        int N = Integer.parseInt(st.nextToken()); // 1000000 이하의 정수

        int[] lan = new int[K];
        long bottom = 0;
        long top = 0;
        for (int i = 0; i < K; i++) {
            lan[i]=Integer.parseInt(br.readLine());
            top=Math.max(top,lan[i]);
        }
        top+=1;
        long middle=(top+bottom)/2;
        long result=0;
        while(top>bottom+1){
            int num_of_lan=0;
            for (int i = 0; i < K; i++) {
                num_of_lan+= (int) (lan[i]/middle);
            }

            if (num_of_lan <N) {
                top=middle;
                middle=(top+bottom)/2;
            }else{
                result=Math.max(result,middle);
                bottom=middle;
                middle=(top+bottom)/2;
            }
        }
        System.out.println(result);
    }
}