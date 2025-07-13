import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[][] paper;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                paper[i][j] = line.charAt(j) - '0';
            }
        }

        int max=0;
        for(int tmp=0,size=(1<<(N*M));tmp<size;tmp++) { // 모든 경우 체크

            int sum=0;
            int order;
            for(int i=0;i<N;i++) { //가로
                order=1;
                for(int j=M-1;j>=0;j--) {
                    int num=j+i*M;
                    if((tmp&(1<<num))>0) {
                        sum += (paper[i][j]*order); //자릿수 계산해서 더하기
                        order*=10;
                    } else {
                        order=1; //세로면 자릿수 초기화
                    }
                }
            }
            for(int j=0;j<M;j++) { //세로
                order=1;
                for(int i=N-1;i>=0;i--) {
                    int num = j+i*M;
                    if((tmp&(1<<num))==0) {
                        sum += (paper[i][j]*order);
                        order*=10;
                    } else {
                        order=1;
                    }
                }
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}