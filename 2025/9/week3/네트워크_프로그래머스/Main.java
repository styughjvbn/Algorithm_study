import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        int[] visit = new int[n];

        for(int k =0;k<n;k++){
            if(visit[k] ==1) continue;
            Deque<Integer> deque = new ArrayDeque();
            deque.add(k);
            visit[k] = 1;
            while(!deque.isEmpty()){
                int computer = deque.poll();
                int[] edge = computers[computer];
                for(int i =0;i<n;i++){
                    if(i==computer) continue;
                    if(edge[i] == 1 && visit[i]==0){
                        deque.add(i);
                        visit[i] = 1;
                    }
                }
            }
            answer++;
        }


        return answer;
    }
}