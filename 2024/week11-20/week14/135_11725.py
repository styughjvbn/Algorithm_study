import sys
from collections import deque

n=int(sys.stdin.readline())
graph=[[] for _ in range(n+1)]
for i in range(n-1):
    a,b=map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)


result=[0 for _ in range(n+1)]
queue=deque()
queue.append(1)
visit=[0 for _ in range(n+1)]
visit[1]=1
while len(queue):
    node=queue.popleft()
    for i in ((graph[node])):
        if visit[i]==0:
            result[i]=node

            queue.append(i)
            visit[i]=1

for i in range(2,n+1):
    print(result[i])
