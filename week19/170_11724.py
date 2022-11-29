import sys
from collections import deque

queue=deque()

n,m=map(int,sys.stdin.readline().split())
graph=[[]for _ in range(n)]
visit=[0 for _ in range(n)]
for i in range(m):
    a,b=map(int,sys.stdin.readline().split())
    graph[a-1].append(b-1)
    graph[b-1].append(a-1)

count=1
for i in range(n):
    if visit[i]==0:
        queue.append(i)
        visit[i]=1
        while queue:
            a=queue.popleft()
            for j in range(len(graph[a])):
                if visit[graph[a][j]]==0:
                    visit[graph[a][j]]=count
                    queue.append(graph[a][j])
        count+=1


print(count-1)