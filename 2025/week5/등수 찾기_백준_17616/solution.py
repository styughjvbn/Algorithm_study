import sys
from collections import deque

def bfs(graph:list[list], visit, visitFlag, startVertex):
    queue = deque()
    queue.append(startVertex)
    visit[startVertex] = visitFlag
    count = 0
    while queue:
        for vertex in graph[queue.popleft()]:
            if visit[vertex] is not visitFlag:
                visit[vertex] = visitFlag
                queue.append(vertex)
                count+=1
    return count

input = sys.stdin.readline

n,m,x = map(int,input().split())
downGraph = [[] for _ in range(n)]
upGraph = [[] for _ in range(n)]
visit = [0 for _ in range(n)]
for _ in range(m):
    u,v = map(lambda a :int(a)-1,input().split())
    downGraph[u].append(v)
    upGraph[v].append(u)
print(bfs(upGraph, visit, 2, x-1)+1, n-bfs(downGraph, visit, 1, x-1))