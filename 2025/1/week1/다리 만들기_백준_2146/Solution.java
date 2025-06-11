import java.io.*;
import java.util.*;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] di = new int[]{0,1,0,-1};
    static int[] dj = new int[]{1,0,-1,0};

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        int[][] world = new int[n][n];
        for(int i = 0; i< n ;i++){
            String line = br.readLine();
            for(int j = 0; j<n;j++){
                if(line.charAt(j*2) == '1')
                    world[i][j]=1;
            }
        }

        int[][] visited = new int[n][n];
        int visitFlag = 1;
        HashMap<Integer, Deque<int[]>> islandOutline = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(world[i][j] == 1){
                    visitFlag++;
                    Deque<int[]> deque = new ArrayDeque<>();
                    deque.add(new int[]{i,j});
                    visited[i][j]=visitFlag;
                    world[i][j]=visitFlag;
                    Deque<int[]> outLines = new ArrayDeque<>();
                    while(!deque.isEmpty()){
                        int[] pos = deque.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            int ni = di[k] + pos[0];
                            int nj = dj[k] + pos[1];
                            if(0<= ni && ni<n && 0<= nj && nj<n && visited[ni][nj]!=visitFlag){
                                if(world[ni][nj] == 1){
                                    world[ni][nj] = visitFlag;
                                    deque.add(new int[]{ni,nj});
                                }
                                if(world[ni][nj] == 0){
                                    outLines.add(new int[]{ni,nj,0});
                                }
                            }
                        }
                    }
                    islandOutline.put(visitFlag, outLines);
                }
            }
        }

        int result = 20_000;
        visitFlag += 10_000;
        for (Map.Entry<Integer, Deque<int[]>> entry : islandOutline.entrySet()) {
            Deque<int[]> islandOutlineInfo =  entry.getValue();
            int islandId = entry.getKey();
            visitFlag++;
            SEARCH:
            while (! islandOutlineInfo.isEmpty()){
                int[] outLineInfo = islandOutlineInfo.pollFirst();
                for (int k = 0; k < 4; k++) {
                    int ni = di[k] + outLineInfo[0];
                    int nj = dj[k] + outLineInfo[1];
                    if(0<= ni && ni<n && 0<= nj && nj<n && visited[ni][nj]!=visitFlag){
                        if(world[ni][nj] == 0){
                            islandOutlineInfo.add(new int[]{ni,nj, outLineInfo[2]+1});
                            visited[ni][nj]=visitFlag;
                        }
                        else if(world[ni][nj] != islandId){
                            result = Math.min(result, outLineInfo[2]+1);
                            break SEARCH;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}