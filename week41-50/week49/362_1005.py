import sys
from collections import deque
input=sys.stdin.readline

t=int(input())
for _ in range(t):
    n,k=map(int,input().split())
    time=list(map(int,input().split()))

    graph=[[] for _ in range(n)]
    ingraph = [[] for _ in range(n)]
    indegree = [0]*n
    for i in range(k):
        a,b=map(int,input().split())
        a,b=a-1,b-1
        graph[b].append(a)
        ingraph[a].append(b)
        indegree[b]+=1

    queue=deque()
    order=[]
    for i in range(n):
        if indegree[i]==0:
            queue.append(i)
            order.append(i)
    while queue:
        node=queue.popleft()
        for i in ingraph[node]:
            indegree[i]-=1
            if indegree[i]==0:
                queue.append(i)
                order.append(i)
    for i in order:
        max_time=0
        for j in graph[i]:
            max_time=max(max_time,time[j])
        time[i] += max_time
    w = int(input())
    print(time[w-1])