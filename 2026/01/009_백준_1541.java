import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//더하기 연산들을 우선으로 계산하여 빼기 연산의 값을 늘린다.
public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer minusDivider = new StringTokenizer(br.readLine(),"-");
        int res = calcPlus(minusDivider.nextToken());
        while(minusDivider.hasMoreTokens()){
            res -= calcPlus(minusDivider.nextToken());
        }

        System.out.println(res);
    }

    public static int calcPlus(String str){
        StringTokenizer plusDvider = new StringTokenizer(str,"+");
        int num = Integer.parseInt(plusDvider.nextToken());
        while(plusDvider.hasMoreTokens()){
            num += Integer.parseInt(plusDvider.nextToken());
        }

        return num;
    }
}
