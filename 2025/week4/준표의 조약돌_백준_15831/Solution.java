import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[] pebbles = br.readLine().toCharArray();
        int left = 0;
        int blackCount = 0;
        int whiteCount = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            if (pebbles[right] == 'B') blackCount++;
            else whiteCount++;

            // 검은색 개수가 B 초과하면, 초과 안 날 때까지 left를 이동
            while (blackCount > B) {
                if (pebbles[left] == 'B') blackCount--;
                else whiteCount--;
                left++;
            }

            // 이제 blackCount <= B가 보장. 흰색이 W개 이상이면 길이 갱신
            if (whiteCount >= W) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        // 만약 maxLen이 한 번도 갱신되지 않았다면(=조건을 만족하는 구간 없다면) 0 출력
        System.out.println(maxLen);
    }
}