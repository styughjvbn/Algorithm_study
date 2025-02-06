import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 정방향, 역방향 그래프
    static List<Integer>[] forwardGraph, reverseGraph;
    static int n, m, S, T;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        forwardGraph = new ArrayList[n];
        reverseGraph = new ArrayList[n];
        for(int i=0; i<n; i++){
            forwardGraph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        // 간선 입력
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            forwardGraph[a].add(b);
            reverseGraph[b].add(a);
        }

        // S, T
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()) - 1;
        T = Integer.parseInt(st.nextToken()) - 1;

        // ------ 출근 경로: S -> T ------
        // 1) 정방향: S에서 출발, T 만나면 멈춤 (dfsStopAt)
        //    - 방문하되, 집합에 넣을 때는 (S,T) 제외
        Set<Integer> stForwardSet = new HashSet<>();
        boolean[] visited = new boolean[n];
        dfsStopAt(S, T, forwardGraph, visited, stForwardSet, S, T);

        // 2) 역방향: T에서 출발, 제한없이 방문 (dfsNoStop)
        //    - 방문하되, 집합에 넣을 때 (S,T) 제외
        Set<Integer> stReverseSet = new HashSet<>();
        visited = new boolean[n];
        dfsNoStop(T, reverseGraph, visited, stReverseSet, S, T);

        // S->T에서 "중간" 정점이 될 수 있는 것
        Set<Integer> stSet = new HashSet<>(stForwardSet);
        stSet.retainAll(stReverseSet);  // 교집합

        // ------ 퇴근 경로: T -> S ------
        // 1) 정방향: T에서 출발, S 만나면 멈춤
        Set<Integer> tsForwardSet = new HashSet<>();
        visited = new boolean[n];
        dfsStopAt(T, S, forwardGraph, visited, tsForwardSet, T, S);

        // 2) 역방향: S에서 출발, 제한없이 방문
        Set<Integer> tsReverseSet = new HashSet<>();
        visited = new boolean[n];
        dfsNoStop(S, reverseGraph, visited, tsReverseSet, T, S);

        // T->S에서 "중간" 정점이 될 수 있는 것
        Set<Integer> tsSet = new HashSet<>(tsForwardSet);
        tsSet.retainAll(tsReverseSet);

        // ------ 최종 교집합 ------
        stSet.retainAll(tsSet);
        System.out.println(stSet.size());
    }

    static void dfsStopAt(int start, int stop, List<Integer>[] graph,
                          boolean[] visited, Set<Integer> set,
                          int sIgnore, int tIgnore) {
        visited[start] = true;
        // '중간' 정점 집합에는 S나 T는 넣지 않음
        if (start != sIgnore && start != tIgnore) {
            set.add(start);
        }

        // 목적지(stop)에 도달하면 더 진행 안 함
        if (start == stop) return;

        for (int nxt : graph[start]) {
            if (!visited[nxt]) {
                // nxt가 stop이면 여기서 방문처리 후 끝
                if (nxt == stop) {
                    visited[nxt] = true;
                    // stop 자체는 중간 집합에 넣지 않는다
                } else {
                    dfsStopAt(nxt, stop, graph, visited, set, sIgnore, tIgnore);
                }
            }
        }
    }

    static void dfsNoStop(int start, List<Integer>[] graph,
                          boolean[] visited, Set<Integer> set,
                          int sIgnore, int tIgnore) {
        visited[start] = true;
        if (start != sIgnore && start != tIgnore) {
            set.add(start);
        }
        for (int nxt : graph[start]) {
            if (!visited[nxt]) {
                dfsNoStop(nxt, graph, visited, set, sIgnore, tIgnore);
            }
        }
    }
}
