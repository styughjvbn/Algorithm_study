import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> kindOfRows = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String row = br.readLine().trim();
            if (!kindOfRows.containsKey(row)) {
                kindOfRows.put(row, 1);
            } else {
                kindOfRows.put(row, kindOfRows.get(row) + 1);
            }
        }
        int k = Integer.parseInt(br.readLine());

        Set<Map.Entry<String, Integer>> entrySet = kindOfRows.entrySet();
        int result = 0;
        int kIsOdd = k % 2;
        for (Map.Entry<String, Integer> entry : entrySet) {
            int zeroCount = 0;
            for (char c : entry.getKey().toCharArray()) {
                if (c == '0') zeroCount++;
            }
            if (zeroCount > k) continue;

            if (zeroCount % 2 == kIsOdd) result = Math.max(result, entry.getValue());
        }
        System.out.println(result);
    }
}