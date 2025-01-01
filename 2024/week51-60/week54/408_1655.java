import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //출력 값이 많다면 string으로 만들어서 출력하는 것이 빠르다.
        StringBuilder sb = new StringBuilder();

        int n= Integer.parseInt( br.readLine());
        PriorityQueue<Integer> max_queue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> min_queue = new PriorityQueue<Integer>();
        int num=Integer.parseInt(br.readLine());

        min_queue.offer(-num);
        sb.append(num+"\n");
        for (int i = 0; i < n-1; i++) {
            num=Integer.parseInt(br.readLine());
            if (-min_queue.peek()>num){
                min_queue.offer(-num);
                if (min_queue.size() >max_queue.size()+1) {
                    max_queue.offer(-min_queue.poll());
                }
            }
            else{
                max_queue.offer(num);
                if (min_queue.size() <max_queue.size()) {
                    min_queue.offer(-max_queue.poll());
                }
            }
            sb.append(-min_queue.peek()+"\n");
        }
        System.out.println(sb);
    }
}