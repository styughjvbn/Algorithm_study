import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] meeting = new int[2];
            meeting[0] = Integer.parseInt(st.nextToken());
            meeting[1] = Integer.parseInt(st.nextToken());
            meetings[i] = meeting;
        }

        //1. 끝나는 시간이 빠르고 2. 시작 시간이 빠른 순서로
        Arrays.sort(meetings, (o1,o2)->{
            if(o1[1]==o2[1]) return o1[0]-o2[0];
            return o1[1]-o2[1];
        });

        int endTime = 0;
        int res = 0;
        for (int[] meeting : meetings) {
            if(meeting[0] >= endTime) {
                endTime= meeting[1];
                res++;
            }
        }
        System.out.println(res);
    }
}
