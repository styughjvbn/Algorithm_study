from collections import deque
n,m = map(int,input().split())

graph = [[] for _ in range(n+1)]
indegree = [0] * (n+1)

for i in range(m):
    order = list(map(int,input().split()))
    for i in range(1, len(order)-1):
        graph[order[i]].append(order[i+1])
        indegree[order[i+1]] +=1

q = deque([])

for i in range(1,n+1):
    if indegree[i] == 0:
        q.append(i)

ans = []
while q:
    now = q.popleft()
    ans.append(now)

    for node in graph[now]:
        indegree[node] -=1
        
        if indegree[node] == 0:
            q.append(node)

if len(ans) == n:
    for num in ans:
        print(num)
else:
    print(0)