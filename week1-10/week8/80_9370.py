import sys
import heapq

T=int(sys.stdin.readline())
for _ in range(T):
    n, m, t = map(int, sys.stdin.readline().split())
    s, g, h = map(int, sys.stdin.readline().split())
    between=0
    graph=[[]for _ in range(n+1)]
    for _ in range(m):
        a,b,c=map(int,sys.stdin.readline().split())
        graph[a].append([b,c])
        graph[b].append([a,c])
        if (a==g and b==h) or (a==h and b==g):
            between=c
    candidate=[]
    for _ in range(t):
        candidate.append(int(sys.stdin.readline()))
    def dijkstra(start):
        distance = [ int(1e9)] * (n+1)
        distance[start] = 0
        heap = []
        heapq.heappush(heap,(0,start))

        while len(heap):
            dis,vertex=heapq.heappop(heap)
            if distance[vertex]<dis:#이미 더 짧은 길이의 경로가 나왔기때문에 힙에 들어온 경로는 폐기
                continue
            else:
                for i in graph[vertex]:
                    new_dis=dis+i[1]
                    if new_dis<distance[i[0]]:
                        distance[i[0]]=new_dis
                        heapq.heappush(heap,(new_dis,i[0]))

        return distance

    allpost=dijkstra(s)
    gpost=dijkstra(g)
    hpost=dijkstra(h)
    result=[]
    for i in candidate:
        if allpost[g]+hpost[i]+gpost[h]<=allpost[i] or hpost[g]+allpost[h]+gpost[i]<=allpost[i]:
            result.append(i)
    result.sort()
    print(*result)