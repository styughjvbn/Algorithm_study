import math
import sys
import heapq

v, e = map(int, sys.stdin.readline().split())
V = {}

for i in range(1, v + 1):
    V[i] = []
for i in range(1,e+1):
    a, b, c = map(int, sys.stdin.readline().split())
    V[a].append([b, c])
    V[b].append([a, c])

def dijkstra(start):
    distance = [math.inf] * (v + 1)
    distance[start] = 0
    heap = []
    heapq.heappush(heap,(0,start))

    while len(heap):
        dis,vertex=heapq.heappop(heap)
        if distance[vertex]<dis:#이미 더 짧은 길이의 경로가 나왔기때문에 힙에 들어온 경로는 폐기
            continue
        else:
            for i in V[vertex]:
                new_dis=dis+i[1]
                if new_dis<distance[i[0]]:
                    distance[i[0]]=new_dis
                    heapq.heappush(heap,(new_dis,i[0]))
    return distance

v1,v2=map(int,sys.stdin.readline().split())
dist1=dijkstra(1)
dist2=dijkstra(v1)
dist3=dijkstra(v2)
result=min(dist1[v1] + dist2[v2] + dist3[v], dist1[v2] + dist2[v]+dist3[v1])
if result<math.inf:
    print(result)
else:
    print(-1)


