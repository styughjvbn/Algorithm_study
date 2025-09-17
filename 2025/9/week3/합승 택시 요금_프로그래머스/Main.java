import java.util.*;

class Solution {
    final static int MAX_VALUE = 100_000*200+1;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dist[i], MAX_VALUE);
        }
        for(int[] fare: fares){
            int c = fare[0] -1;
            int d = fare[1] -1;
            int f = fare[2];
            dist[c][d] = f;
            dist[d][c] = f;
        }
        for(int i=0;i<n;i++){
            dist[i][i] = 0;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dist[j][k] = Math.min(dist[j][i]+dist[i][k], dist[j][k]);
                }
            }
        }
        a--,b--,s--;
        int answer = dist[s][a]+dist[s][b];
        for(int i = 0;i<n;i++){
            answer = Math.min(dist[s][i]+dist[i][a]+dist[i][b], answer);
        }

        return answer;
    }
}