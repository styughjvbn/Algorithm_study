import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int n= Integer.parseInt( br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            pq.offer(temp);
        }

        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                pq.offer(temp);
                pq.poll();
            }
        }

        System.out.println(pq.poll());
    }
}