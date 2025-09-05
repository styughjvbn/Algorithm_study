import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        Deque<int[]> deque = new ArrayDeque();
        for(int i = 0; i<priorities.length;i++){
            pq.add(priorities[i]);
            deque.add(new int[]{priorities[i], i});
        }
        int count = 1;
        while(true){
            int[] process = deque.pollFirst();
            if(pq.peek() != process[0]){
                deque.add(process);
            }else{
                pq.poll();
                if(process[1] == location){
                    break;
                }
                count++;
            }


        }

        return count;
    }
}