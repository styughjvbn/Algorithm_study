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
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long[] houseCoordinates = new long[n];
        for (int i = 0; i < n; i++) {
            houseCoordinates[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houseCoordinates);

        long high = 1_000_000_000;
        long low = 1;
        long middle = (high + low) / 2;
        while (low <= high) {
//            System.out.println(low + " " + middle + " " + high);
            if (placeRouter(houseCoordinates, middle) >= c) {
                low = middle + 1;
            }else{
                high = middle - 1;
            }
            middle = (high + low) / 2;
        }
        System.out.println(high);
    }

    public static long placeRouter(long[] houseCoordinates, long dist) {
        long prevHouseCoordinates = houseCoordinates[0];
        int placedCount = 1;
        for (int i = 1; i < houseCoordinates.length; i++) {
            if (houseCoordinates[i] - prevHouseCoordinates >= dist) {
                placedCount++;
                prevHouseCoordinates = houseCoordinates[i];
            }
        }
//        System.out.println(placedCount);

        return placedCount;
    }
}