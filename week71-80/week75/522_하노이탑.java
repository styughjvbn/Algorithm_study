import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.Buffer;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static int k;
    static int count=0;
    public static void move(int n, int from, int to){
        if(n==1){
            count++;
            sb.append(from).append(" ").append(to).append('\n');
        }else{
            int tempPos=6-from-to;
            move(n-1,from, tempPos);
            count++;
            sb.append(from).append(" ").append(to).append('\n');
            move(n-1,tempPos,to);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        k=Integer.parseInt(br.readLine());
        if(k<=20){
            move(k,1,3);
            System.out.println(count);
            System.out.println(sb);
        }else{
            BigInteger count = new BigInteger("2");
            System.out.println(count.pow(k).subtract(BigInteger.ONE));
        }

    }
}