import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> card_set= new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            int card=Integer.parseInt(br.readLine());
            card_set.offer(card);
        }
        int result=0;
        while(card_set.size()>1){
            int card1=card_set.poll();
            int card2=card_set.poll();
            result+=card1+card2;
            card_set.offer(card1+card2);
        }
        System.out.println(result);


    }
}