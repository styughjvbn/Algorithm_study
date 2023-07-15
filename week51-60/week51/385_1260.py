import sys
from collections import deque
input=sys.stdin.readline

n,m,v=map(int,input().split())
vertex=[[] for _ in range(n)]
for _ in range(m):
    a,b=map(int,input().split())
    a,b=a-1,b-1
    vertex[a].append(b)
    vertex[b].append(a)

vertex=list(map(sorted,vertex))
visit=[0]*n
visit[v-1]=1
dfs_result=[]
def dfs(n):
    dfs_result.append(n+1)
    for i in vertex[n]:
        if visit[i]==0:
            visit[i]=1
            dfs(i)

dfs(v-1)
print(*dfs_result)
bfs_result=[]
def bfs(n):
    queue=deque()
    queue.append(n)
    bfs_visit=[0]*len(vertex)
    bfs_visit[n]=1
    while queue:
        a=queue.popleft()
        bfs_result.append(a+1)
        for i in vertex[a]:
            if bfs_visit[i] == 0:
                bfs_visit[i] = 1
                queue.append(i)

bfs(v-1)
print(*bfs_result)