import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] di = new int[]{-2,-1,1,2,2,1,-1,-2};
    static int[] dj = new int[]{1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (; t > 0; t--) {
            int l = Integer.parseInt(br.readLine());
            Deque<int[]> deque = new ArrayDeque<>();
            int[][] visit = new int[l][l];
            st = new StringTokenizer(br.readLine(), " ");
            int[] startPos = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine(), " ");
            int[] targetPos = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            if(startPos[0] == targetPos[0] && startPos[1] == targetPos[1]){
                sb.append(0).append('\n');
                continue;
            }

            deque.add(startPos);
            visit[startPos[0]][startPos[1]] = 1;
            boolean isReach = false;
            while (!deque.isEmpty() && !isReach) {
                int[] pos = deque.pollFirst();
                for (int k = 0; k < 8; k++) {
                    int ni = pos[0] + di[k];
                    int nj = pos[1] + dj[k];
                    if (0 <= ni && ni < l && 0 <= nj && nj < l) {
                        if(targetPos[0] == ni && targetPos[1] == nj){
                            sb.append(visit[pos[0]][pos[1]]).append('\n');
                            isReach = true;
                            break;
                        }
                        if(visit[ni][nj] == 0){
                            visit[ni][nj] = visit[pos[0]][pos[1]] + 1;
                            deque.add(new int[]{ni,nj});
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}