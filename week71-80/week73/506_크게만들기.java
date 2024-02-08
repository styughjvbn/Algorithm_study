import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        String number=br.readLine().trim();
        Deque<Character> deque=new ArrayDeque<>();
        deque.add(number.charAt(0));
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i < N; i++) {
            while(M>0&&deque.getLast()<number.charAt(i)){
                M--;
                deque.pollLast();
                if(deque.isEmpty())break;
            }
            if(deque.add(number.charAt(i)));
        }
        while(M>0){
            deque.pollLast();
            M--;
        }
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        System.out.println(sb);
    }
}