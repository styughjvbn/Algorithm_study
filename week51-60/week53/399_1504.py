import sys
import heapq
input=sys.stdin.readline

n,e=map(int,input().split())
graph=[[] for _ in range(n)]
for i in range(e):
    a,b,c=map(int,input().split())
    a,b=a-1,b-1
    graph[a].append([b,c])
    graph[b].append([a, c])

v1,v2=map(int,input().split())
v1,v2=v1-1,v2-1

def dijckstra(vertex):
    distance=[10**12 for _ in range(n)]
    distance[vertex]=0
    heap=[(0,vertex)]
    while heap:
        prev_dis,pres_vertex=heapq.heappop(heap)
        for i in graph[pres_vertex]:
            if distance[i[0]]>distance[pres_vertex]+i[1]:
                distance[i[0]]=distance[pres_vertex]+i[1]
                heapq.heappush(heap,(distance[i[0]],i[0]))
    return distance

start_dis=dijckstra(0)

end_dis=dijckstra(n-1)

between_dis=dijckstra(v1)

result=min(start_dis[v1]+end_dis[v2],end_dis[v1]+start_dis[v2])+between_dis[v2]
if v1==0 and v2==n-1:
    print(between_dis[v2])
    exit()
if result>10**12:
    print(-1)
else:
    print(result)