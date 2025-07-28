import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] di = new int[]{0, 1, 0, -1};
    static int[] dj = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        int[][] estate = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int estateNum = 0;
        List<Integer> houseCountPerEstate = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1' && estate[i][j] == 0) {
                    houseCountPerEstate.add(bfs(i, j, estate, ++estateNum, map));
                }
            }
        }
        houseCountPerEstate.sort(Comparator.comparingInt(a -> a));
        sb.append(estateNum).append('\n');
        for (Integer i : houseCountPerEstate) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    static int bfs(int startI, int startJ, int[][] estate, int estateNum, char[][] map){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{startI, startJ,});
        estate[startI][startJ] = estateNum;
        int houseCount = 0;
        while(!deque.isEmpty()){
            int[] houseInfo = deque.pollFirst();
            houseCount++;
            for (int k = 0; k < 4; k++) {
                int ni = houseInfo[0] + di[k];
                int nj = houseInfo[1] + dj[k];
                if(!(0<= ni && ni < estate.length && 0 <= nj && nj< estate.length))
                    continue;
                if(estate[ni][nj] != 0 || map[ni][nj] == '0')
                    continue;

                estate[ni][nj] = estateNum;
                deque.add(new int[]{ni,nj});
            }
        }
        return houseCount;
    }
}