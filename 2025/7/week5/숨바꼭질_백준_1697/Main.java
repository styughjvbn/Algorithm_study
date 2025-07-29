import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int finder = Integer.parseInt(st.nextToken());
        int hider = Integer.parseInt(st.nextToken());

        if( finder == hider ){
            System.out.println(0);
            return;
        }
        int[] reachTime = new int[100001];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(finder);
        reachTime[finder] = 1;
        while(!deque.isEmpty()){
            int presentPos = deque.pollFirst();
            int[] nextPos = new int[]{presentPos + 1,presentPos - 1, presentPos * 2};
            for (int i : nextPos) {
                if(i == hider) {
                    System.out.println(reachTime[presentPos]);
                    return;
                }
                if(0<= i && i <= 100000 && reachTime[i] == 0){
                    reachTime[i] = reachTime[presentPos] + 1;
                    deque.add(i);
                }
            }
        }
    }
}