import java.util.*;

class Solution {
    List<Integer>[] graph;
    int[] info;
    int n;
    int answer = 1;

    public int solution(int[] info, int[][] edges) {
        this.graph = new List[info.length];
        n = info.length;
        this.info = info;
        for(int i = 0;i<graph.length;i++){
            graph[i] = new ArrayList();
        }

        for(int[] edge: edges){
            int parent = edge[0];
            int child = edge[1];
            graph[parent].add(child);
            graph[child].add(parent);
        }


        bfs(1, 0, 0, 1);

        return answer;
    }

    public void bfs(int visit, int nodeNum, int wolfCount, int sheepCount){

        answer = Math.max(answer, sheepCount);
        Deque<Integer> deque = new ArrayDeque();
        int localVisit = 1<<nodeNum;
        deque.add(nodeNum);
        while(!deque.isEmpty()){
            int node = deque.poll();
            for(int nextNode: graph[node]){
                if((1<<nextNode & localVisit) != 0) continue;
                if((1<<nextNode & visit) == 0){
                    int nextVisit = visit|(1<<nextNode);
                    if(info[nextNode] == 0) {
                        bfs(nextVisit, nextNode,wolfCount,sheepCount+1);
                    }else{
                        if(wolfCount+1<sheepCount)bfs(nextVisit, nextNode,wolfCount+1,sheepCount);
                    }
                }else{
                    deque.add(nextNode);
                    localVisit |= 1<<nextNode;
                }
            }
        }
    }
}