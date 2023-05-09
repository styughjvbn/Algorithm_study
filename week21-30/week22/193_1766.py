import sys
import heapq

input=sys.stdin.readline
heap=[]

n,m=map(int,input().split())
graph=[[]for _ in range(n+1)]
inDegree = [0 for _ in range(n+1)]
for i in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    inDegree[b] += 1

for i in range(1, n + 1):
    if inDegree[i] == 0:
        heapq.heappush(heap, i)

result=[]
while heap:
    num=heapq.heappop(heap)
    result.append(num)
    for j in graph[num]:
        inDegree[j] -= 1
        if inDegree[j] == 0:
            heapq.heappush(heap,j)
    print(num,end=" ")