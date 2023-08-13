import sys
import heapq

input=sys.stdin.readline

V,E=map(int,input().split())
K=int(input())-1
graph=[[] for _ in range(V)]
for i in range(E):
    u,v,w=map(int,input().split())
    u,v=u-1,v-1
    graph[u].append((v,w))

dist=[10**7 for _ in range(V)]
dist[K]=0
heap=[(0,K)]

while heap:
    distance,cur_v=heapq.heappop(heap)
    if dist[cur_v]<distance:
        continue
    for dest,weight in graph[cur_v]:
        if dist[dest]>dist[cur_v]+weight:
            dist[dest]=dist[cur_v]+weight
            heapq.heappush(heap,(dist[dest],dest))
for idx, value in enumerate(dist):
    if idx==V:
        print(0)
    else:
        if value==10**7:
            print("INF")
        else:
            print(value)