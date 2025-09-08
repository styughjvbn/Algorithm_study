import java.util.*;

class Solution {
    int[][] visit;
    int[] di = new int[]{0,1,0,-1};
    int[] dj = new int[]{1,0,-1,0};

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        int[] posR = new int[2];

        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i].charAt(j) == 'R') posR = new int[]{i,j};
            }
        }

        visit = new int[n][m];
        Deque<int[]> deque = new ArrayDeque();
        deque.add(new int[]{posR[0], posR[1], 1});
        visit[posR[0]][posR[1]] = 1;
        while(!deque.isEmpty()){
            int[] pos = deque.poll();
            for(int k =0;k<4;k++){
                int ni = pos[0];
                int nj = pos[1];
                while(true){
                    int niCandi = ni + di[k];
                    int njCandi = nj + dj[k];
                    if(0<=niCandi && niCandi < n && 0<=njCandi && njCandi < m && board[niCandi].charAt(njCandi) != 'D'){
                        ni = niCandi;
                        nj = njCandi;
                    }else{
                        break;
                    }
                }
                if(ni == pos[0] && nj == pos[1]) continue;
                if(visit[ni][nj] != 0) continue;
                if(board[ni].charAt(nj) == 'G') return pos[2];
                visit[ni][nj] = 1;
                deque.add(new int[]{ni,nj,pos[2]+1});
            }
        }

        return -1;
    }
}