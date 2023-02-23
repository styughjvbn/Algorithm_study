import sys
from collections import deque

input=sys.stdin.readline

n=int(input())
target1,target2=map(int,input().split())
target1,target2=target1-1,target2-1
m=int(input())
graph=[[] for _ in range(n)]
visit=[0 for _ in range(n)]
for i in range(m):
    x,y = map(int, input().split())
    x,y=x-1,y-1
    graph[x].append(y)
    graph[y].append(x)

queue=deque()
queue.append(target1)
visit[target1]=1
while queue:
    a=queue.popleft()
    for i in graph[a]:
        if visit[i]==0:
            queue.append(i)
            visit[i]=visit[a]+1
            if i==target2:
                print(visit[i]-1)
                exit()
print(-1)