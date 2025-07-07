import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] abilities;
    static int[] AteamPlayers;
    static int[] BteamPlayers;
    static int result = 100_000_000;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        abilities = new int[N][N];
        AteamPlayers = new int[N];
        BteamPlayers = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                abilities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0, 0);
        System.out.println(result);
    }

    public static void dfs(int player, int AteamAccScore, int BteamAccScore, int AteamPlayerNum, int BteamPlayerNum) {
        if(player >= N){
            //두 팀의 인원수는 같지 않아도 되지만, 한 명 이상이어야 한다.
            if(AteamPlayerNum != 0 && BteamPlayerNum != 0){
                result = Math.min(result, Math.abs(AteamAccScore - BteamAccScore));
            }
            return;
        }

        //현재 player를 A팀에 배정
        AteamPlayers[AteamPlayerNum] = player;
        //현재 player를 A팀에 배정했을 때 이미 A팀에 존재하는 팀원들과의 전체 시너지를 구함
        int newSynergy = 0;
        for (int i = AteamPlayerNum - 1; i >= 0; i--) {
            newSynergy += abilities[player][AteamPlayers[i]] + abilities[AteamPlayers[i]][player];
        }
        //다음 player를 배정
        dfs(player + 1, AteamAccScore + newSynergy, BteamAccScore, AteamPlayerNum + 1, BteamPlayerNum);

        //현재 player를 B팀에 배정
        BteamPlayers[BteamPlayerNum] = player;
        newSynergy = 0;
        for (int i = BteamPlayerNum - 1; i >= 0; i--) {
            newSynergy += abilities[player][BteamPlayers[i]] + abilities[BteamPlayers[i]][player];
        }
        dfs(player + 1, AteamAccScore, BteamAccScore + newSynergy, AteamPlayerNum, BteamPlayerNum + 1);
    }
}