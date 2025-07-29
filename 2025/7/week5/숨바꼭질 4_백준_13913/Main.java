import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int finder = Integer.parseInt(st.nextToken());
        int hider = Integer.parseInt(st.nextToken());

        if( finder == hider ){
            System.out.println(0);
            System.out.println(finder);
            return;
        }
        int[] reachTime = new int[100001];
        int[] prevPos = new int[100001];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(finder);
        reachTime[finder] = 1;
        prevPos[finder] = -1;
        while(!deque.isEmpty()){
            int presentPos = deque.pollFirst();
            int[] nextPos = new int[]{presentPos + 1,presentPos - 1, presentPos * 2};
            for (int i : nextPos) {
                if(i == hider) {
                    System.out.println(reachTime[presentPos]);
                    prevPos[i] = presentPos;
                    backtracking(prevPos, i);
                    sb.append(hider);
                    System.out.println(sb);
                    return;
                }
                if(0<= i && i <= 100000 && reachTime[i] == 0){
                    reachTime[i] = reachTime[presentPos] + 1;
                    deque.add(i);
                    prevPos[i] = presentPos;
                }
            }
        }
    }

    public static void backtracking(int[] prevPos, int lastPos){
        List<Integer> track = new ArrayList<>();
        while(prevPos[lastPos] != -1){
            track.add(prevPos[lastPos]);
            lastPos = prevPos[lastPos];
        }
        for (int i = track.size() - 1; i >= 0 ; i--) {
            sb.append(track.get(i)).append(' ');
        }
    }
}