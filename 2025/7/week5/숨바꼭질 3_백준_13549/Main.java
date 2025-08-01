import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int MAX_LEN = 100_000;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int finder = Integer.parseInt(st.nextToken());
        int hider = Integer.parseInt(st.nextToken());

        int[] reachTime = new int[100001];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = finder; i <= MAX_LEN; i*=2) {
            if( i == hider){
                System.out.println(0);
                return;
            }
            deque.add(i);
            reachTime[i] = 1;
            if(i==0)break;
        }
        while(!deque.isEmpty()){
            int presentPos = deque.pollFirst();
            int[] nextPos = new int[]{presentPos + 1,presentPos - 1};
            for (int k =0;k<2;k++) {
                int i = nextPos[k];
                for (int j = i; j <= MAX_LEN ; j*=2) {
                    if(j == hider) {
                        System.out.println(reachTime[presentPos]);
                        return;
                    }
                    if(0<= j  && reachTime[j] == 0){
                        reachTime[j] = reachTime[presentPos] + 1;
                        deque.add(j);
                    }
                    if(j==0)break;
                }
            }
        }
    }
}