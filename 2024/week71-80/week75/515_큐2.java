import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue=new ArrayDeque<>(n);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!queue.isEmpty()){
                        sb.append(queue.pollFirst()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(!queue.isEmpty()){
                        sb.append(0).append("\n");
                    }else{
                        sb.append(1).append("\n");
                    }
                    break;
                case "front":
                    if(!queue.isEmpty()){
                        sb.append(queue.getFirst()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if(!queue.isEmpty()){
                        sb.append(queue.getLast()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
