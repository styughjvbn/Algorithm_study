import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> right = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> left = new PriorityQueue<>();
        int num = Integer.parseInt(br.readLine());
        right.add(num);
        sb.append(num).append('\n');
        for (int i = 1; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            if (right.peek() < num) {
                left.add(num);
            }else{
                right.add(num);
            }

            if(right.size() < left.size()){
                right.add(left.poll());
            }else if(right.size() - left.size() > 1){
                left.add(right.poll());
            }
            sb.append(right.peek()).append('\n');

        }

        System.out.println(sb);
    }
}