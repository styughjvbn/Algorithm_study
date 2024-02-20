import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_2252_줄세우기_골드3_서종원_412ms {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		List<Integer>[] outDegree=new List[n];
		int[] InDegree=new int[n];
		for (int i = 0; i < n; i++) {
			outDegree[i]=new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			outDegree[a].add(b);
			InDegree[b]++;
		}
		Deque<Integer> queue=new ArrayDeque<Integer>();
		for (int i = 0; i < n; i++) {
			if(InDegree[i]==0) {
				queue.add(i);
				sb.append(i+1).append(" ");
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for (int integer : outDegree[cur]) {
				InDegree[integer]--;
				if(InDegree[integer]==0) {
					queue.add(integer);
					sb.append(integer+1).append(" ");
				}
			}
		}
		System.out.println(sb);
	}

}
