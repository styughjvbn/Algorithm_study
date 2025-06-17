import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int a = num1;
        int b = num2;
        int c;
        do{
            c = a%b;
            a = b;
            b = c;
        }while(c>0);

        System.out.println(a);
        System.out.println(num1/a*num2);
    }
}