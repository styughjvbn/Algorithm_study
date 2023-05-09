import sys
import heapq
input=sys.stdin.readline

N=int(input())
M=int(input())
graph=[[] for _ in range(N)]
for i in range(M):
    a,b,c=map(int,input().split())
    graph[a-1].append([b-1,c])
start,end=map(int,input().split())
start,end=start-1,end-1
visit=[0 for _ in range(N)]
heap=[]
distance=[10**10 for _ in range(N)]
distance[start]=0
heapq.heappush(heap,(0,start))
while heap:
    node=heapq.heappop(heap)
    if visit[node[1]]:
        continue
    visit[node[1]]=1
    for i in graph[node[1]]:
        if distance[i[0]]>distance[node[1]]+i[1]:
            distance[i[0]]=distance[node[1]]+i[1]
        if not visit[i[0]]:
            heapq.heappush(heap,(distance[node[1]]+i[1],i[0]))

print(distance[end])