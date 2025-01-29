import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int k;
    static char[][] lines;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        lines = new char[2][];
        visited = new boolean[2][n];
        for (int i = 0; i < 2; i++) {
            lines[i] = br.readLine().toCharArray();
        }
        Deque<int[]> queue = new ArrayDeque<>();
        visited[0][0] = true;
        queue.add(new int[]{0, 0, 0});

        while(! queue.isEmpty()){
            int[] cur = queue.poll();
            if ( cur[1] < cur[2]) continue;
            if ( cur[1] > 0 ){
                if ( lines[cur[0]][cur[1] - 1] == '1' && !visited[cur[0]][cur[1] - 1] ){
                    visited[cur[0]][cur[1] - 1] = true;
                    queue.add(new int[]{cur[0], cur[1]-1, cur[2]+1});
                }
            }
            if ( cur[1] + 1 < n ){
                if ( lines[cur[0]][cur[1] +1] == '1' && !visited[cur[0]][cur[1]+1] ){
                    visited[cur[0]][cur[1] +1 ] = true;
                    queue.add(new int[]{cur[0], cur[1]+1, cur[2]+1});
                }
            }else {
                System.out.println(1);
                System.exit(0);
            }
            if ( cur[1] + k < n ){
                if ( lines[(cur[0]+1)%2][cur[1]+k] == '1' && !visited[(cur[0]+1)%2][cur[1]+k] ){
                    visited[(cur[0]+1)%2][cur[1]+k] = true;
                    queue.add(new int[]{(cur[0]+1)%2, cur[1]+k, cur[2]+1});
                }
            }else{
                System.out.println(1);
                System.exit(0);
            }

        }
        System.out.println(0);
    }

}