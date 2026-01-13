import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] lanWires = new long[k];
        for (int i = 0; i < k; i++) {
            lanWires[i] = Integer.parseInt(br.readLine());
        }

        long high = Integer.MAX_VALUE;
        long low = 0;
        long middle = (high + low) / 2;
        while (low <= high) {
//            System.out.println(low + " " + middle + " " + high);
            if (divideNum(lanWires, middle) >= n) {
                low = middle + 1;
            }else{
                high = middle - 1;
            }
            middle = (high + low) / 2;
        }
        System.out.println(high);
    }

    public static long divideNum(long[] lanWires, long divideNum) {
        long divideCount = 0;
        for (long lanWire : lanWires) {
            divideCount += lanWire / divideNum;
        }

        return divideCount;
    }
}