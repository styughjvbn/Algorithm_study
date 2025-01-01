import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_백준_10026_적록색약_골드5_서종원_100ms {
	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};
	static char[][] board;
	static int[][] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		board=new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j]=line.charAt(j);
			}
		}
		int normal=0;
		visit=new int[n][n];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(visit[i][j]==0) {
					normal++;
					char standard=board[i][j];
					Deque<int[]> queue= new ArrayDeque<int[]>();
					queue.add(new int[] {i,j});
					visit[i][j]=1;
					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						for (int k = 0; k < 4; k++) {
							int ni=cur[0]+di[k];
							int nj=cur[1]+dj[k];
							if(0<=ni && ni<n && 0<=nj && nj<n && visit[ni][nj]==0 && board[ni][nj]==standard) {
								visit[ni][nj]=1;
								queue.add(new int[] {ni,nj});
							}
						}
					}
				}
			}
		}
		
		visit=new int[n][n];
		int color=0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(visit[i][j]==0) {
					color++;
					char standard1=board[i][j];
					char standard2=standard1;
					if(standard1=='R') {
						standard2='G';
					}else if(standard1=='G') {
						standard2='R';
					}
					
					Deque<int[]> queue= new ArrayDeque<int[]>();
					queue.add(new int[] {i,j});
					visit[i][j]=1;
					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						for (int k = 0; k < 4; k++) {
							int ni=cur[0]+di[k];
							int nj=cur[1]+dj[k];
							if(0<=ni && ni<n && 0<=nj && nj<n && visit[ni][nj]==0 && (board[ni][nj]==standard1 || board[ni][nj]==standard2)) {
								visit[ni][nj]=1;
								queue.add(new int[] {ni,nj});
							}
						}
					}
				}
			}
		}
		System.out.println(normal+" "+color);
	}
}
