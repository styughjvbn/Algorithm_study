import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//나의 풀이
//목적지부터 출발지까지 역순으로 탐색하며 가장 저렴한 도시를 방문, 주유.
//주유한 도시를 저장. 출발지쪽으로 이동하며 다음으로 저렴한 도시를 방문, 주유.

//간단한 풀이
//출발지로부터 출발하여 출발지의 가격을 기준으로 둠.
//다음 도시를 이동하며 이동한 거리만큼 비용 추가
//기준보다 저렴하다면 해당 도시의 기름값을 다시 기준으로 설정
//기준보다 저렴하지 않다면 계속해서 다음 도시로 이동.
public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] load =  new int[n-1];
        st = new  StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            load[i] = Integer.parseInt(st.nextToken());
        }
        int[][] cities = new int[n-1][2];//마지막 도시의 기름 가격은 쓰이지 않음
        st = new  StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            cities[i][0] = Integer.parseInt(st.nextToken()); // 리터당 가격
            cities[i][1] = i; //인덱스
        }

        Arrays.sort(cities,(a,b)-> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] suffixSum = new int[n];
        for (int i = n-2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + load[i];
        }

        long res = 0;
        int last = n-1;
        for (int[] city : cities) {
            if(city[1] > last) continue;

            res += (long)city[0] * (suffixSum[city[1]] - suffixSum[last]);
            last = city[1];
        }

        System.out.println(res);
    }
}
