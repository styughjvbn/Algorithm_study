import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while(true){
            String numberString = br.readLine();
            if(numberString == null || numberString.isEmpty())
                break;

            int number = Integer.parseInt(numberString);
            int digit = 1;
            int remain = 1%number;
            while (remain != 0){
                remain = (remain*10+1)%number;
                digit++;
            }
            sb.append(digit).append('\n');
        }

        System.out.println(sb);
    }
}