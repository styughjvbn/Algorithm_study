import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int num=Integer.parseInt(br.readLine());
            int[] numbers=new int[101];
            StringTokenizer st=new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                numbers[Integer.parseInt(st.nextToken())]+=1;
            }
            int result=0;
            for (int i1 = 0; i1 < numbers.length; i1++) {
                if(numbers[i1]>=numbers[result]){
                    result=i1;
                }
            }
            System.out.printf("#%d %d\n",num,result);
        }
    }
}